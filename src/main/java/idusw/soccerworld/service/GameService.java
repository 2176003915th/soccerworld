package idusw.soccerworld.service;

import idusw.soccerworld.domain.dto.GameDto;
import idusw.soccerworld.domain.dto.TeamDto;
import idusw.soccerworld.domain.entity.GameEntity;
import idusw.soccerworld.repository.GameRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GameService {
    final GameRepository gameRepository;

    public static LocalDateTime convertUtcToKst(String utcDateTimeStr) {
        ZonedDateTime utcDateTime = ZonedDateTime.parse(utcDateTimeStr);
        ZonedDateTime kstDateTime = utcDateTime.withZoneSameInstant(ZoneId.of("Asia/Seoul"));
        return kstDateTime.toLocalDateTime();
    }

    public GameService (GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameDto> getGamesByDate(String date){
        List<GameDto> gameDtoList = gameRepository.selectByDate(date);
        System.out.println("서비스:" + date);
        System.out.print(gameDtoList);
        return gameDtoList;
    }

    public GameDto getGameByGameId(int gameId){ //
        GameDto gameDto = gameRepository.selectByGameId(gameId);
        return gameDto;
    }



    public int insertGames(List<Map> gameDataList){
        List<GameDto> gameDtoList = new ArrayList<>();
        int result;

        for(Map gameData: gameDataList) {

            Map gameScore = (Map) gameData.get("score");
            Map gameGoals = (Map) gameScore.get("fullTime");
            Map gameTeamHome = (Map) gameData.get("homeTeam");
            Map gameTeamAway = (Map) gameData.get("awayTeam");

            TeamDto teamHomeDto = TeamDto.builder()
                    .teamId((Integer) gameTeamHome.get("id"))
                    .build();
            TeamDto teamAwayDto = TeamDto.builder()
                    .teamId((Integer) gameTeamAway.get("id"))
                    .build();

            int homeScore = 0;
            int awayScore = 0;
            int gameResult = 3;

            if(gameScore.containsKey("winner")) {
                homeScore = (int) gameGoals.get("home");
                awayScore = (int) gameGoals.get("away");

                if("HOME_TEAM".equals(gameScore.get("winner").toString())){
                    gameResult = 0;
                } else if("DRAW".equals(gameScore.get("winner").toString())){
                    gameResult = 1;
                } else if("AWAY_TEAM".equals(gameScore.get("winner").toString())){
                    gameResult = 2;
                }
            }

            GameDto gameDto = GameDto.builder()
                    .gameId((int) gameData.get("id"))
                    .homeTeamDto(teamHomeDto)
                    .awayTeamDto(teamAwayDto)
                    .dateTime(convertUtcToKst(gameData.get("utcDate").toString()))
                    .round((Integer) gameData.get("matchday"))
                    .homeScore(homeScore)
                    .awayScore(awayScore)
                    .result(gameResult)
                    .build();

            gameDtoList.add(gameDto);
        }
        result = gameRepository.insertGames(gameDtoList);
        System.out.println(gameDtoList);
        return result;
    } //외부에서 데이터를 호출하고 post요청으로 데이터를 보내 백엔드에서 저장할 시
}
