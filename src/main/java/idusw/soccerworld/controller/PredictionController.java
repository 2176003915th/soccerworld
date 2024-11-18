package idusw.soccerworld.controller;

import idusw.soccerworld.service.MemberService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class PredictionController {
    final MemberService memberService;
    public PredictionController(MemberService memberService){
        this.memberService = memberService;
    }
    @GetMapping("/prediction")
    public String goPrediction(Model model) {

        model.addAttribute("fixtureId",22);
        return "/fixture/prediction";
    }

    @PostMapping("/prediction")
    @ResponseBody
    public ResponseEntity inputPrediction(@RequestBody Map<String, Object> predictionData) {
        int userId = (int) predictionData.get("userId");
        HttpHeaders headers= new HttpHeaders();
        System.out.println(userId);
        return new ResponseEntity("ok",headers, HttpStatus.OK);
    }

    @GetMapping("/login")
    public String login(){
        return "/main/login";
    }


}