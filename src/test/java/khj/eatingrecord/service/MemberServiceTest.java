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
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    void joinTest() {
        MemberDto memberDto = new MemberDto();
        memberDto.setId("1234abcd");

        assertThat(memberService.isExist(memberDto)).isEqualTo(false);

        memberService.join(memberDto);

        assertThat(memberService.isExist(memberDto)).isEqualTo(true);
    }

    @Test
    void getMemberTest() {
        String id = "1234abcd";
        int age = 20;
        char gender = 'M';

        MemberDto memberDto = new MemberDto();
        memberDto.setId(id);
        memberDto.setAge(age);
        memberDto.setGender(gender);

        memberService.join(memberDto);

        assertThat(memberService.getMember(id).getGender()).isEqualTo(gender);
        assertThat(memberService.getMember(id).getAge()).isEqualTo(age);
    }
}