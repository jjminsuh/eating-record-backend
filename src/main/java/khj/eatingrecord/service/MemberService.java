package khj.eatingrecord.service;

import jakarta.transaction.Transactional;
import khj.eatingrecord.dto.MemberDto;
import khj.eatingrecord.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean isExist(MemberDto memberDto) {
        return !memberRepository.findById(memberDto.getId()).isEmpty();
    }

    public MemberDto join(MemberDto memberDto) {
        return memberRepository.save(memberDto).get().toDto();
    }

    public MemberDto getMember(String id) {
        return memberRepository.findById(id).get().toDto();
    }
}
