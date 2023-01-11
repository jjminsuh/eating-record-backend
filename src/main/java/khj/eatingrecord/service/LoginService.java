package khj.eatingrecord.service;

import jakarta.transaction.Transactional;
import khj.eatingrecord.dto.MemberDto;
import khj.eatingrecord.entity.Member;
import khj.eatingrecord.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    @Autowired
    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean isExist(MemberDto memberDto) {
        return !memberRepository.findById(memberDto.getId()).isEmpty();
    }

    public void join(MemberDto memberDto) {
        memberRepository.save(memberDto);
    }
}
