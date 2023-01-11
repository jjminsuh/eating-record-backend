package khj.eatingrecord.service;

import jakarta.transaction.Transactional;
import khj.eatingrecord.domain.Member;
import khj.eatingrecord.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean isExist(Member member) {
        return memberRepository.findById(member.getId()).isEmpty();
    }

    public void join(Member member) {
        memberRepository.save(member);
    }
}
