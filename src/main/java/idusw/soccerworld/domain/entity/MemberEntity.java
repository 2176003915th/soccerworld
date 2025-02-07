package idusw.soccerworld.domain.entity;

import idusw.soccerworld.domain.dto.MemberDto;
import lombok.Data;

import java.util.Date;

@Data
public class MemberEntity {
    private long memberId;
    private String id;
    private String password;
    private String name;
    private String nickname;
    private int gender;
    private Date birthday;
    private int point;
//    private TeamEntity teamEntity;

    public static MemberEntity dtoToEntity(MemberDto memberDto) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(memberDto.getMemberId());
        memberEntity.setId(memberDto.getId());
        memberEntity.setPassword(memberDto.getPassword());
        memberEntity.setName(memberDto.getName());
        memberEntity.setNickname(memberDto.getNickname());
        memberEntity.setGender(memberDto.getGender());
        memberEntity.setBirthday(memberDto.getBirthday());
        memberEntity.setPoint(memberDto.getPoint());
//        memberEntity.setTeamEntity(TeamEntity.dtoToEntity(memberDto.getTeamDto()));
        return memberEntity;
    }
}
