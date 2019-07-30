package com.company;

import com.company.controller.GuestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.company.utills.CSRFTokenHolder.TOKEN_ATTR_NAME;
import static com.company.utills.CSRFTokenHolder.getCsrfToken;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class GuestControllerTest {

    @Autowired
    private GuestController guestController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contexLoads() {
        assertThat(guestController).isNotNull();
    }

    @Test
    public void getHomePage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getServiceCalculatorPage() throws Exception {
        this.mockMvc.perform(get("/calculate"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void isApplicationCreated() throws Exception {
        CsrfToken csrfToken = getCsrfToken();
        this.mockMvc.perform(post("/calculate").sessionAttr(TOKEN_ATTR_NAME, csrfToken)
                .param(csrfToken.getParameterName(), csrfToken.getToken())
                .param("weight","100").param("deliveryAddress","Kyiv"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/calculate/result"));
    }

    @Test
    public void resultPage() throws Exception {
        this.mockMvc.perform(get("/calculate/result"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/div/div[1]/h2").string("Cost of delivery"));
    }
}
