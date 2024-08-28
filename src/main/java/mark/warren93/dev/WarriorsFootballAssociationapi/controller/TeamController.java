package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Team;
import mark.warren93.dev.WarriorsFootballAssociationapi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController{
    @Autowired
    private TeamService service;
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        try {
            Team createTeam = service.createTeam(team);
            return new ResponseEntity<>(createTeam, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/allTeams")
    public ResponseEntity<List<Team>> getTeams() {
        List<Team> allTeams = service.findAllTeams();
        System.out.println(allTeams);
        return new ResponseEntity<>(allTeams, HttpStatus.OK);
    }
    @GetMapping("/teamByTeamName")
    public ResponseEntity<Optional<Team>> getSingleTeamByTeamName(@RequestParam String team_name){
        Optional<Team> getSingleTeamByTeamName = service.findTeamByTeamName(team_name);
        return new ResponseEntity<>(getSingleTeamByTeamName, HttpStatus.OK);
    }
}