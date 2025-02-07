package idusw.soccerworld.service;

import idusw.soccerworld.domain.dto.MemberDto;
import idusw.soccerworld.domain.entity.MemberEntity;
import idusw.soccerworld.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    final MemberRepository memberRepository;
    public MemberService (MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberDto checkLogin(String id) { //로그인시 정보 확인
        MemberDto memberDto = memberRepository.select(id); //일단 해당 Id를 가진 정보를 불러옴
        if (memberDto == null) {
            return null;
        }
        System.out.println("로그인시 정보 : " + memberDto);
        return memberDto;
    }

    public MemberDto getMemberByMemberId (long memberId) {
        MemberDto memberDto = memberRepository.selectByMemberId(memberId);
        return memberDto;
    }
}
