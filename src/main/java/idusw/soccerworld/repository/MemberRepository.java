package idusw.soccerworld.repository;

import idusw.soccerworld.domain.entity.MemberEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    SqlSessionTemplate sessionTemplate;
    public MemberRepository (SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }
    public MemberEntity select(String id) {
        return sessionTemplate.selectOne("MemberName.selectMember", id);
    }
}
