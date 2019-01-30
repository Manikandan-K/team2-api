package spicinemas.api.db;

import org.jooq.DSLContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class ShowRepositoryTest {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    DSLContext dslContext;


    @Test
    public void getDistinctMovieIdsByLocation() {
        List movieIds = showRepository.getDistinctMovieIdsByLocation(1);
       Assert.assertEquals(1, movieIds.size());
       Assert.assertEquals(1l,movieIds.get(0));
    }
}