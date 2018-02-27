package toomuchdrinking.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import toomuchdrinking.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {AppConfig.class})
public class ConsumedBeersRepositoryTest {

    @Autowired
    private ConsumedBeersRepository repository;

    @Test
    public void shouldReturnComments() throws Exception {
        System.out.println(repository.findAll());
    }

}
