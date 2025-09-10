package mark.warren93.dev.WarriorsFootballAssociationapi.service;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Team;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StandingsService {


    private final TeamRepository teamRepo;

    public StandingsService(TeamRepository teamRepo) {
        this.teamRepo = teamRepo;
    }

    public List<Team> computeDivisionStandings(String divisionId) {
        // Load all teams in this division
        List<Team> teams = teamRepo.findByDivisionId(divisionId);

        // Sort by points, goal diff, goals for, then name
        teams.sort(
                Comparator.comparingInt(Team::getPoints).reversed()
                        .thenComparingInt(Team::getGoalDiff).reversed()
                        .thenComparingInt(Team::getGoalsFor).reversed()
                        .thenComparing(Team::getName)
        );

        // Assign ranks (1, 2, 3, …)
        int rank = 1;
        for (Team t : teams) {
            t.setRank(rank++); // <-- requires `rank` field in Team
        }

        return teams;
    }
}
