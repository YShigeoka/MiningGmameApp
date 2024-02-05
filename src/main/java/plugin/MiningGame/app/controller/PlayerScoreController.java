package plugin.MiningGame.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import plugin.MiningGame.app.mapper.data.PlayerScore;
import plugin.MiningGame.app.service.PlayerScoreService;

@RestController
public class PlayerScoreController {


  public final PlayerScoreService service;

  public PlayerScoreController(PlayerScoreService service){
    this.service = service;
  }

  @RequestMapping(value = "/playerScoreList", method = RequestMethod.GET)
  public List<PlayerScore>playerScoreList() {
    return  service.searchPlayerScoreList();
  }

}
