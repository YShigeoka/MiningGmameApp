package plugin.MiningGame.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import plugin.MiningGame.app.DuplicateConfigException;
import plugin.MiningGame.app.mapper.data.GameConfig;
import plugin.MiningGame.app.mapper.data.GenerateBlocks;
import plugin.MiningGame.app.service.ConfigService;

@RestController
public class ConfigController {

  public final ConfigService service;

  public ConfigController(ConfigService service) {
    this.service = service;
  }


  @GetMapping(value = "/configList")
  public List<GameConfig> serachConfigList(){
    return service.searchConfigList();
  }

  @GetMapping(value = "/config")
  public GameConfig serachConfig(@RequestParam String difficulty) {
    return service.searchConfig(difficulty);
  }

  @GetMapping(value = "/GenerateBlocksList")
  public List<GenerateBlocks> generateBlocksList(@RequestParam String difficulty){
    return service.searchGenerateBlocksList(difficulty);
  }

  @PostMapping(value = "/config")
  public ResponseEntity<GameConfig> registerConfig(@RequestBody GameConfig config)throws Exception{
    GameConfig registerConfig = service.registerConfig(config);
    return new ResponseEntity<>(config, HttpStatus.OK);
  }

  @PostMapping(value = "/updateBlockScore")
  public ResponseEntity<List<GenerateBlocks>> updateBlockScore(@RequestBody GenerateBlocks blocks){
    List<GenerateBlocks> updateGenerateBlocksList = service.updateBlockScore(blocks);
    return new ResponseEntity<>(updateGenerateBlocksList, HttpStatus.OK);
  }

  @ExceptionHandler(value = DuplicateConfigException.class)
  public ResponseEntity<Map<String, String>> handleDuplicateConfig(
      DuplicateConfigException e, HttpServletRequest request) {
    Map<String, String> body = Map.of(
        "timestamp", ZonedDateTime.now().toString(),
        "status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
        "error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
        "message", e.getMessage(),
        "path", request.getRequestURI());
    return new ResponseEntity(body, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
