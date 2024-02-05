package plugin.MiningGame.app.service;

import java.util.List;
import org.springframework.stereotype.Service;
import plugin.MiningGame.app.DuplicateConfigException;
import plugin.MiningGame.app.mapper.GameConfigMapper;
import plugin.MiningGame.app.mapper.data.GameConfig;
import plugin.MiningGame.app.mapper.data.GenerateBlocks;

@Service
public class ConfigService {


  public final GameConfigMapper mapper;

  public ConfigService(GameConfigMapper mapper) {
    this.mapper = mapper;
  }

  public List<GameConfig> searchConfigList(){
    return mapper.selectConfigList();
  }

  public GameConfig searchConfig(String difficulty) {
    return mapper.selectConfig(difficulty);
  }

  public List<GenerateBlocks> searchGenerateBlocksList(String difficulty){
    return mapper.selectGenerate_blocksList(difficulty);
  }

  public  GameConfig registerConfig (GameConfig config) throws Exception{
    if(searchConfig(config.getDifficulty()) != null){
      throw new DuplicateConfigException("Duplicate Config Error!");
    }
    mapper.insertConfig(config);
    return mapper.selectConfig(config.getDifficulty());
  }

  public List<GenerateBlocks> updateBlockScore (GenerateBlocks blocks){
    mapper.updateBlockScore(blocks);
    return mapper.selectGenerate_blocksList(blocks.getDifficulty());
  }


}
