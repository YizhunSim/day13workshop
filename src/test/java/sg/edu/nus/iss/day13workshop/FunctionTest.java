package sg.edu.nus.iss.day13workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class FunctionTest {
  private Path workingDir;
  private Logger logger = Logger.getLogger(FunctionTest.class.getName());

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void readContact() throws IOException{
    this.workingDir = Path.of("", "/Users/Zhun/Desktop/VTTP/vttp2022_batch2_v2/day13workshop/data");
    Path file = this.workingDir.resolve("95848009");
    String content = Files.readString(file);
    assertThat(content, is(notNullValue()));
  }

  @Test
  public void saveContact() throws Exception {
    MultiValueMap<String, String> payload = new LinkedMultiValueMap<String, String>();
    payload.add("name", "Yizhun");
    payload.add("email", "yizhun.sim@gmail.com");
    payload.add("phone", "12345678");

    logger.log(Level.INFO, "" + objectMapper.writeValueAsString(payload));
  }
}
