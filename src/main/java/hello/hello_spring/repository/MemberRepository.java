package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 저장 기능
    // Oprional은 찾고자 하는 값이 null인경우, oprional로 감싸서 반환해준다.
    Optional<Member> findById(Long id); // ID로 회원 찾기 기능
    Optional<Member> findByName(String name); // 이름으로 회원 찾기 기능
    List<Member> findAll();
}
