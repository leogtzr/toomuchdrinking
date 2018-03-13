package toomuchdrinking.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import toomuchdrinking.service.DrinkStatsService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(StatsController.class)
public class StatsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DrinkStatsService drinkStatsService;

    @Test
    public void shouldRenderStatsPage() throws Exception {
        mvc.perform(get("/stats")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(content().string(containsString("<title>stats</title>")));
    }


}
