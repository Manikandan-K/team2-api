/*
package spicinemas.api.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.management.MovieManagement;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
@ContextConfiguration(classes = SpiCinemasApplication.class) // >>>> issue here
public class MovieControllerTest {


    @Autowired
    MockMvc mvc;

    @MockBean
    private MovieManagement movieManagement;


    @Test
    public void testMovieOK()
            throws Exception {
        given(movieManagement.getMovies(any(),any(),any())).willReturn(new ArrayList<>());
        mvc.perform(get("/movies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}*/
