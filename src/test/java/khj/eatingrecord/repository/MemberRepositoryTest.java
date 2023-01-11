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

        memberRepository.save(memberDto);

        assertThat(memberRepository.findById(memberDto.getId()).get().getId()).isEqualTo(memberDto.getId());
    }
}