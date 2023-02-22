package khj.eatingrecord.repository;

import khj.eatingrecord.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    void saveTest() {
        MemberDto memberDto = new MemberDto();
        memberDto.setId("1234abcd");
        memberDto.setAge(20);
        memberDto.setGender('F');

        memberRepository.save(memberDto);

        assertThat(memberRepository.findById(memberDto.getId()).get().getId()).isEqualTo(memberDto.getId());
        assertThat(memberRepository.findById(memberDto.getId()).get().getAge()).isEqualTo(memberDto.getAge());
        assertThat(memberRepository.findById(memberDto.getId()).get().getHeight()).isEqualTo(memberDto.getHeight());
    }
}