package mark.warren93.dev.WarriorsFootballAssociationapi.service;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Team;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    TeamRepo repository;
    public List<Team> findAllTeams() {
        return repository.findAll();
    }

    public Optional<Team> findTeamByTeamName(String team_name){
        return repository.findTeamByTeamName(team_name);
    }
}
