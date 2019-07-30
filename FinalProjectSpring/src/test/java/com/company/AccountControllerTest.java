package com.company;

import com.company.controller.AccountController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.company.utills.CSRFTokenHolder.TOKEN_ATTR_NAME;
import static com.company.utills.CSRFTokenHolder.getCsrfToken;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/users-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/users-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@WithUserDetails("example@mail.com")
public class AccountControllerTest {

    @Autowired
    private AccountController accountController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contexLoads() {
        assertThat(accountController).isNotNull();
    }

    @Test
    public void getMainPage() throws Exception {
        this.mockMvc.perform(get("/account"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getApplicationPage() throws Exception {
        this.mockMvc.perform(get("/account/application"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getShoppingBasketPage() throws Exception {
        this.mockMvc.perform(get("/account/shopping_basket"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getPaymentPage() throws Exception {
        this.mockMvc.perform(get("/account/payment"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void usersPageAccessDenied() throws Exception {
        this.mockMvc.perform(get("/account/all_users"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    @WithUserDetails("ruslan.kovshar@gmail.com")
    public void usersPageAccessAllowed() throws Exception {
        this.mockMvc.perform(get("/account/all_users"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void payment() throws Exception {
        CsrfToken csrfToken = getCsrfToken();
        this.mockMvc.perform(post("/account/payment/pay").sessionAttr(TOKEN_ATTR_NAME, csrfToken)
                .param(csrfToken.getParameterName(), csrfToken.getToken())
                .param("amount", "100"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/account"));
    }

    @Test
    public void makeApplication() throws Exception {
        CsrfToken csrfToken = getCsrfToken();
        this.mockMvc.perform(post("/account/application")
                .sessionAttr(TOKEN_ATTR_NAME, csrfToken)
                .param(csrfToken.getParameterName(), csrfToken.getToken())
                .param("amount", "100")
                .param("weight", "15")
                .param("type", "Load")
                .param("localDate", "2019-07-31")
                .param("deliveryAddress", "Kyiv")
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/account/application"));
    }
}
