package plugin.MiningGame.app.mapper.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class GenerateBlocks {
  private int id;
  private String difficulty;
  private String blockName;
  private int score;


}
