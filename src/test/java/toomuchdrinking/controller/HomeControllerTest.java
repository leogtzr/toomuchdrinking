package toomuchdrinking.controller;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import toomuchdrinking.bean.DrinkType;
import toomuchdrinking.repository.ConsumedBeersRepository;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ConsumedBeersRepository repository;

    @Test
    public void shouldRenderIndexPageWithSpecifiedOptions() throws Exception {

        final List<DrinkType> drinkTypes = Arrays.
                asList(new DrinkType(1, "CERVEZA"),
                        new DrinkType(2, "Pulque")
                );

        Mockito.when(repository.drinkTypes()).thenReturn(drinkTypes);

        mvc.perform(
                MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML)).
                    andExpect(MockMvcResultMatchers.status().isOk()).
                        andExpect(content().string(CoreMatchers.containsString("Pulque")));
    }

}
