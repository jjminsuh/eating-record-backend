package khj.eatingrecord.repository;

import jakarta.persistence.EntityManager;
import khj.eatingrecord.dto.MemberDto;
import khj.eatingrecord.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberRepository {

    private final EntityManager em;

    @Autowired
    public MemberRepository(EntityManager em) {
        this.em = em;
    }

    public Optional<Member> findById(String id) {
        Member member =  em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    public Optional<Member> save(MemberDto memberDto) {
        Member member = memberDto.toEntity();
        em.persist(member);

        return findById(member.getId());
    }
}
