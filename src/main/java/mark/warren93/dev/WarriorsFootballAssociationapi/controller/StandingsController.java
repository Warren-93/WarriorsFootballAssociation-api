package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Team;
import mark.warren93.dev.WarriorsFootballAssociationapi.service.StandingsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/standings")
public class StandingsController {
    private final StandingsService standings;

    public StandingsController(StandingsService standings) {
        System.out.println("We have hit Standings API");
        this.standings = standings;
    }

    @GetMapping("/{divisionId}/standings")
    public List<Team> getStandings(@PathVariable String divisionId) {
        return standings.computeDivisionStandings(divisionId);
    }
}
