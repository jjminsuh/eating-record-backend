package khj.eatingrecord.service;

import khj.eatingrecord.dto.MemberDto;
import khj.eatingrecord.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class LoginServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LoginService loginService;

    @Test
    void joinTest() {
        MemberDto memberDto = new MemberDto();
        memberDto.setId("1234abcd");

        assertThat(loginService.isExist(memberDto)).isEqualTo(false);

        loginService.join(memberDto);

        assertThat(loginService.isExist(memberDto)).isEqualTo(true);
    }
}