package plugin.MiningGame.app.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import plugin.MiningGame.app.mapper.data.GameConfig;
import plugin.MiningGame.app.mapper.data.GenerateBlocks;

@Mapper
public interface GameConfigMapper {
  @Select("select * from game_config order by id asc")
  List<GameConfig> selectConfigList();


  @Select("select * from game_config where difficulty = #{difficulty} order by id asc")
  GameConfig selectConfig(String difficulty);

  @Select("select * from generate_blocks inner join game_config on generate_blocks.difficulty = game_config.difficulty where generate_blocks.difficulty = #{difficulty} order by generate_blocks.id asc")
  List<GenerateBlocks> selectGenerate_blocksList(String difficulty);

  @Insert("insert game_config(game_time, difficulty) values(#{gameTime}, #{difficulty})")
  int insertConfig(GameConfig config);

  @Update("update generate_blocks set score = #{score} where block_name = #{blockName} and difficulty = #{difficulty}")
  int updateBlockScore(GenerateBlocks blocks);


}
