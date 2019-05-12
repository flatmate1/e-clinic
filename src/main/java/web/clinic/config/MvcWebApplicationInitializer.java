package web.clinic.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebApplicationInitializer 
	extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	// Load database and spring security configuration
	  protected Class<?>[] getRootConfigClasses() {
	    return new Class[] { AppConfig.class, WebSecurityConfig.class};
	  }

	  // Load spring web configuration
	  protected Class<?>[] getServletConfigClasses() {
	    return new Class[] { WebConfig.class };
	  }
	  
	  protected String[] getServletMappings() {
	    return new String[] { "/" };
	  }

}
