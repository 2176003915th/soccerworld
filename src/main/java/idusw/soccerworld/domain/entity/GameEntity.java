package idusw.soccerworld.domain.entity;

import idusw.soccerworld.domain.dto.GameDto;
import idusw.soccerworld.domain.dto.TeamDto;
import lombok.Data;

import java.util.Date;

@Data
public class GameEntity {
    private long gameId;
    private TeamEntity homeTeamEntity;
    private TeamEntity awayTeamEntity;
    private Date dateTime;
    private Integer homeScore;
    private Integer awayScore;
    private Integer result;

    public static GameEntity dtoToEntity(GameDto gameDto){
        GameEntity gameEntity = new GameEntity();
        gameEntity.setGameId(gameDto.getGameId());
        gameEntity.setHomeTeamEntity(TeamEntity.dtoToEntity(gameDto.getHomeTeamDto()));
        gameEntity.setAwayTeamEntity(TeamEntity.dtoToEntity(gameDto.getAwayTeamDto()));
//        gameEntity.setDateTime(gameDto.getDateTime());
        gameEntity.setHomeScore(gameDto.getHomeScore());
        gameEntity.setAwayScore(gameDto.getAwayScore());
        gameEntity.setResult(gameDto.getResult());
        return gameEntity;
    }
}
