package idusw.soccerworld.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class testController {

    @GetMapping("/test/schedule")
    @ResponseBody
    public void getFixture(@RequestParam(required = false, value = "selectedDate")String paramDate,
                             @RequestParam(required = false, value = "leagueName")String leagueName) {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> req = RequestEntity
                .get("https://api.football-data.org/v4/competitions/PL/scorers")
                .header("X-Auth-Token", "b65ddca6324442efb04ba9e08d7efa93")
                .build();
        System.out.println(restTemplate.exchange(req, String.class));
        ResponseEntity<Map> response = restTemplate.exchange(req,Map.class);
    }

    //    public void insertGamesExample(){ //JSON OBJECT
//        RestTemplate restTemplate = new RestTemplate();
//        RequestEntity<Void> request = RequestEntity
//                .get("https://v3.football.api-sports.io/fixtures?date=2025-01-19&league=39&season=2024&timezone=Asia/seoul")
//                .header(String.valueOf(apiHeaders))
//                .build();
////        System.out.println(request);
////        String result = restTemplate.exchange(request, String.class).getBody();
//
//        ResponseEntity<Map> responseData = restTemplate.exchange(request,Map.class);
//        List<Map<String, Object>> responseDataList = (List<Map<String, Object>>) responseData.getBody().get("response");
//        JSONArray jsonResponseList = new JSONArray(responseDataList);
//        List<GameDto> gameDtoList = new ArrayList<>();
//        if(jsonResponseList != null) {
//            for (int i = 0; i < jsonResponseList.length(); i++) {
//                GameDto gameDto = new GameDto();
//                TeamDto teamHomeDto = new TeamDto();
//                TeamDto teamAwayDto = new TeamDto();
//                JSONObject gameJson = (JSONObject) jsonResponseList.get(i);
//                JSONObject gameJsonFixture = gameJson.getJSONObject("fixture");
//                JSONObject gameJsonGoals = gameJson.getJSONObject("goals");
//                JSONObject gameJsonTeam = gameJson.getJSONObject("teams");
//                JSONObject gameJsonTeamHome = gameJsonTeam.getJSONObject("home");
//                JSONObject gameJsonTeamAway = gameJsonTeam.getJSONObject("away");
//
//                teamHomeDto.setTeamId(gameJsonTeamHome.getLong("id"));
//                teamAwayDto.setTeamId(gameJsonTeamAway.getLong("id"));
//
//                gameDto.setGameId(gameJsonFixture.getLong("id"));
//                gameDto.setHomeTeamDto(teamHomeDto);
//                gameDto.setAwayTeamDto(teamAwayDto);
//                gameDto.setHomeScore(gameJsonGoals.getInt("home"));
//                gameDto.setAwayScore(gameJsonGoals.getInt("away"));
//                LocalDateTime localDateTime = OffsetDateTime.parse(gameJsonFixture.getString("date")).toLocalDateTime(); //string -> dateTime 변환
//                gameDto.setDateTime(localDateTime);
//
//                if(gameJsonGoals.getInt("home") > gameJsonGoals.getInt("away")){
//                    gameDto.setResult(0);
//                } else if(gameJsonGoals.getInt("home") == gameJsonGoals.getInt("away")){
//                    gameDto.setResult(1);
//                } else if(gameJsonGoals.getInt("home") < gameJsonGoals.getInt("away")){
//                    gameDto.setResult(2);
//                }
//
//                gameDtoList.add(gameDto);
//            }
//
//            gameRepository.insertGames(gameDtoList);
//        }
//
//    } //백엔드에서 api 호출 하고 데이터 가공 시
}
