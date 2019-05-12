package web.clinic.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
 
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.jdbcAuthentication()
        	.dataSource(dataSource)
        	.usersByUsernameQuery("select username, password, enabled from "
        			+ "przychodnia.user having username=?")
        	.authoritiesByUsernameQuery("select username, role from "
        			+ "przychodnia.user_roles having username=?");      	
  }
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
          .csrf().disable()
          .authorizeRequests()
          .antMatchers("/test").hasRole("ADMIN")
          .antMatchers("/anonymous*").anonymous()
          .antMatchers("/login*","/register*","/doctor*").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .loginPage("/login")
          .defaultSuccessUrl("/", true)
          //.failureUrl("/login.html?error=true")
          .and()
          .logout()
          .logoutSuccessUrl("/login")
          .permitAll();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

     