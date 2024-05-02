package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Team;
import mark.warren93.dev.WarriorsFootballAssociationapi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/teams")
public class TeamController{

    @Autowired
    private TeamService service;

    @GetMapping("/allTeams")
    public ResponseEntity<List<Team>> getTeams() {
        List<Team> allTeams = service.findAllTeams();
        System.out.println(allTeams);
        return new ResponseEntity<>(allTeams, HttpStatus.OK);
    }
}