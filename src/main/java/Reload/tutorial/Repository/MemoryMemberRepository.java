package Reload.tutorial.Repository;

import Reload.tutorial.Domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository {
    // 속성
    // 아이디, 저장소
    private static Long sequence = 0L;
    private static ConcurrentHashMap<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // 멤버에 해당 id가 있는지 찾는 것
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // 전체 멤버
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
