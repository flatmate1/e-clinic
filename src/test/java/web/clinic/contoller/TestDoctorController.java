package web.clinic.contoller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import web.clinic.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={WebConfig.class})
@WebAppConfiguration
public class TestDoctorController {
 
    private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext wac;
 
    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
 
    @Test
    public void testHome() throws Exception {
    	ResultMatcher ok = MockMvcResultMatchers.status().isOk();
    	
    	MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/doctors");
    	
    	this.mockMvc.perform(builder)
        .andExpect(ok);
    }
 

 
}