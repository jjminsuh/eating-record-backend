package khj.eatingrecord.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import khj.eatingrecord.dto.MemberDto;
import khj.eatingrecord.repository.MemberRepository;
import khj.eatingrecord.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;


    @Test
    void loginTest() throws Exception {

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

    @Test
    void signUpTest() throws Exception {
        MemberDto memberDto = new MemberDto();
        memberDto.setId("1234abcd");
        memberDto.setAge(20);

        String expectedJson = "{\"id\":\"1234abcd\",\"height\":0,\"gender\":null,\"age\":20,\"weight\":0,\"num_meal\":0,\"goal\":null}";

        MvcResult result = mockMvc.perform(post("/sign-up")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(memberDto)))
                        .andExpect(status().isOk())
                        .andReturn();

        String actualJson = result.getResponse().getContentAsString();

        assertThat(actualJson).isEqualTo(expectedJson);

        MemberDto responseDto = objectMapper.readValue(actualJson, MemberDto.class);

        assertThat(responseDto.getId()).isEqualTo(memberDto.getId());
        assertThat(responseDto.getAge()).isEqualTo(memberDto.getAge());
    }
}