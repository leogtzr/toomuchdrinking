package toomuchdrinking.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.embedded.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.web.client.*;
import org.springframework.http.*;
import org.springframework.test.context.junit4.*;
import toomuchdrinking.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerIT {

    private static final String URI = "/";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template = new TestRestTemplate();

    @Test
    public void retrieveHomePage() throws Exception {
        final ResponseEntity<String> response = template.getForEntity(createURL(URI), String.class);
        assertThat(response.getBody()).contains("<title>toomuchdrinking</title>");
    }

    private String createURL(final String uri) {
        return String.format("http://localhost:%s%s", port, uri);
    }

}

