package khj.eatingrecord.repository;

import jakarta.persistence.EntityManager;
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

    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    public Optional<Member> findById(String id) {
        Member member =  em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
}
