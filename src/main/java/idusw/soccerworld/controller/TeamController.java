package idusw.soccerworld.controller;

import idusw.soccerworld.service.ScheduleService;
import idusw.soccerworld.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class TeamController {
    final TeamService teamService;
    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping("/admin/team")
    public String goAdminTeam(){

        return "admin/teamAPI";
    }

    @GetMapping("/teamInfo")
    @ResponseBody
    public Object getTeamInfo(@RequestParam(required = false,value="leagueNum")int leagueNum){
        ResponseEntity<Map> response = teamService.getTeamInfo(leagueNum);
        return response;
    }

    @PostMapping("/admin/insertTeams")
    @ResponseBody
    public ResponseEntity insertTeams(@RequestBody Map<String, Object> teamsData){
        int result = teamService.insertTeamInfo(teamsData);
        if(result > 0) {
            return new ResponseEntity<>("성공적으로 등록되었습니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("게임 등록 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
