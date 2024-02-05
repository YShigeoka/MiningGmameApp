package plugin.MiningGame.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plugin.MiningGame.app.mapper.PlayerScoreMapper;
import plugin.MiningGame.app.mapper.data.GameConfig;
import plugin.MiningGame.app.mapper.data.PlayerScore;

@Service
public class PlayerScoreService {

  public final PlayerScoreMapper mapper;


  public PlayerScoreService(PlayerScoreMapper mapper) {
    this.mapper = mapper;
  }

  public List<PlayerScore> searchPlayerScoreList(){
    return mapper.selectplayerScoreList();
  }

}
