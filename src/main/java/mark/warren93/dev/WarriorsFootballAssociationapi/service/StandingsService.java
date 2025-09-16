package mark.warren93.dev.WarriorsFootballAssociationapi.service;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Team;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.DivisionRepository;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StandingsService {

    private final TeamRepository teamRepo;
    private final DivisionRepository divRepo;

    public StandingsService(TeamRepository teamRepo, DivisionRepository divRepo) {
        this.teamRepo = teamRepo;
        this.divRepo = divRepo;
    }

    public List<Team> computeDivisionStandings(String divisionId) {
        List<Team> teams = teamRepo.findByDivisionId(divisionId);

        teams.sort(
                Comparator.comparingInt(Team::getPoints).reversed()
                        .thenComparingInt(Team::getGoalDiff).reversed()
                        .thenComparingInt(Team::getGoalsFor).reversed()
                        .thenComparing(Team::getName)
        );

        int rank = 1;
        for (Team t : teams) {
            t.setRank(rank++);
        }
        return teams;
    }

    public Map<String, List<Team>> computeAllStandings() {
        Map<String, List<Team>> standings = new HashMap<>();

        divRepo.findAll().forEach(div -> {
            List<Team> teams = computeDivisionStandings(div.getDivisionId()); // fixed here
            standings.put(div.getName(), teams);
        });
        return standings;
    }
}
