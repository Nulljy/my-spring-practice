package Reload.tutorial.Repository;
import Reload.tutorial.Domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 공통적인 부분
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
