package plugin.MiningGame.app.mapper.data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class GameConfig {

  private int id;
  private int gameTime;
  private String difficulty;

}
