package khj.eatingrecord.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import khj.eatingrecord.dto.MemberDto;
import khj.eatingrecord.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LoginService loginService;

    @Test
    void testLogin() throws Exception {

        MemberDto memberDto = new MemberDto();
        memberDto.setId("1234abcd");
        String expectedJson = "{\"isExist\":false}";


        MvcResult result = mockMvc.perform(post("/login")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(memberDto)))
                        .andExpect(status().isOk())
                        .andReturn();

        String actualJson = result.getResponse().getContentAsString();

        assertThat(actualJson).isEqualTo(expectedJson);
    }
}