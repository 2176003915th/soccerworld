package idusw.soccerworld.domain.entity;

import idusw.soccerworld.domain.dto.TeamDto;
import lombok.Data;

@Data
public class TeamEntity {
    private long teamId;
    private String name;
    private String league;
    private String logo;
    private String headCoach;
    private String stadium;
    private String location;
    public static TeamEntity dtoToEntity(TeamDto teamDto){
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setTeamId(teamDto.getTeamId());
        teamEntity.setName(teamDto.getName());
        teamEntity.setLogo(teamDto.getLogo());
        teamEntity.setLeague(teamDto.getLeague());
        teamEntity.setHeadCoach(teamDto.getHeadCoach());
        teamEntity.setStadium(teamDto.getStadium());
        teamEntity.setLocation(teamDto.getLocation());
        return teamEntity;
    }
}

