package idusw.soccerworld.repository;

import idusw.soccerworld.domain.dto.MemberDto;
import idusw.soccerworld.domain.entity.MemberEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    SqlSessionTemplate sessionTemplate;
    public MemberRepository (SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }
    public MemberDto select(String id) {
        return sessionTemplate.selectOne("MemberName.selectMember", id);
    }

    public MemberDto selectByMemberId(long memberId) {
        return sessionTemplate.selectOne("MemberName.selectByMemberId", memberId);
    }
}
