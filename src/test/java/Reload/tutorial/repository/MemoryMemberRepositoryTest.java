package Reload.tutorial.repository;


import Reload.tutorial.Domain.Member;
import Reload.tutorial.Repository.MemberRepository;
import Reload.tutorial.Repository.MemoryMemberRepository;
//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

//import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        // 멤버 생성 후 저장하고 잘 반환되는지 확인
        Member member = new Member();
        member.setName("spring1");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findById() {
        // 계정 두개를 만들고 assertThat으로 해당 아이디가 맞는지 체크하기
        Member member1 = new Member();
        member1.setName("진영");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("창진");
        repository.save(member2);

        Member result = repository.findByName("진영").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        // 계정 두개를 만들고 assertThat으로 해당 아이디가 맞는지 체크하기
        Member member1 = new Member();
        member1.setName("진영");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("창진");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
