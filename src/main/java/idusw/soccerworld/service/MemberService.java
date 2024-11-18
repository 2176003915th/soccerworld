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

    public MemberDto loginCheck(String id) {
        MemberEntity memberEntity = memberRepository.select(id);
        if (memberEntity == null) {
            return null;
        }
        return MemberDto.entityToDto(memberEntity);
    }
}
