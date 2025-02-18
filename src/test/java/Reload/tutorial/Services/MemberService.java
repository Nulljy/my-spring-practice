package Reload.tutorial.Services;

import Reload.tutorial.Domain.Member;
import Reload.tutorial.Repository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    public void join() {
        Member member = new Member();
        member.setName("진영");
        // 중복 확인하기
        isDuplicated();
        // db에 저장
        memberRepository.save(member);
        System.out.println("회원가입에 성공하였습니다.");
//        return member.getId();
    }

    @Test
    public void isDuplicated() {
        Member member = new Member();
        member.setName("진영");
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
                });
        System.out.println("중복된 아이디가 존재하지 않습니다.");
    }

    @Test
    public void findMembers() {
        memberRepository.findAll()
    }
}
