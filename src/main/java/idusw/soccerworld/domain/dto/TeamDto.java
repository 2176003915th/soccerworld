package idusw.soccerworld.domain.dto;

import idusw.soccerworld.domain.entity.TeamEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.NStringTypeHandler;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamDto {
    private long teamId;
    private String name;
    private String league;
    private String logo;
    private String headCoach;
    private String stadium;
    private String location;

}
