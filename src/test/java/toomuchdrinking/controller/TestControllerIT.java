package toomuchdrinking.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import toomuchdrinking.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template = new TestRestTemplate();

    @Test
    public void retrieveStats() throws Exception {
        final String uri = "/comments";
        final ResponseEntity<String> response = template.getForEntity(createURL(uri), String.class);
        /*
        System.out.println(response.getBody());
        Assert.assertTrue(response.getStatusCode() == HttpStatus.OK);
        JSONAssert.assertEquals("{\"ok\":true,\"needs\":[]}", response.getBody(), false);
        */
    }

    private String createURL(final String uri) {
        return "http://localhost:" + port + uri;
    }

}
