package plugin.MiningGame.app.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import plugin.MiningGame.app.mapper.data.GameConfig;
import plugin.MiningGame.app.mapper.data.PlayerScore;

@Mapper
public interface PlayerScoreMapper {
  @Select("select * from player_score order by id asc")
  List<PlayerScore> selectplayerScoreList();

}
