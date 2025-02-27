package com.example.demo.services;

import com.example.demo.model.MembersDB;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void save(MembersDB membersDB) {
        memberRepository.save(membersDB);
    }

    public List<MembersDB> getMemberDBByName(String name) {
        return (List<MembersDB>) memberRepository.findByName(name);
    }

    public List<MembersDB> getAll() {
        return (List<MembersDB>) memberRepository.findAll();
    }
}
