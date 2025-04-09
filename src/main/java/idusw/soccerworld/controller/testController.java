package idusw.soccerworld.controller;

import idusw.soccerworld.service.SchedulerService;
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

    SchedulerService schedulerService;

    public testController(SchedulerService schedulerService){
        this.schedulerService = schedulerService;
    }

    @GetMapping("/test/schedule")
    @ResponseBody
    public void getFixture(@RequestParam(required = false, value = "selectedDate")String paramDate,
                             @RequestParam(required = false, value = "leagueName")String leagueName) {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> req = RequestEntity
                .get("https://api.football-data.org/v4/competitions/PD/matches")
                .header("X-Auth-Token", "b65ddca6324442efb04ba9e08d7efa93")
                .build();
        System.out.println(restTemplate.exchange(req, String.class));
        ResponseEntity<Map> response = restTemplate.exchange(req,Map.class);
    }

    @GetMapping("/test/zzzz")
    public void testmanzd(){
        schedulerService.refreshGames();
    }

}
