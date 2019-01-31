package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spicinemas.api.dto.ShowVO;
import spicinemas.api.management.ShowManagement;

import java.util.Date;
import java.util.List;

@RestController
public class ShowController {

    @Autowired
    private ShowManagement showManagement;

    @RequestMapping(value = "/movies/{movieId}/shows",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,params = {"location", "showDate"})
    public List<ShowVO> getShows(@RequestParam(value = "location") long location,
                                 @RequestParam(value = "showDate") @DateTimeFormat(pattern="dd-MM-yyyy") Date showDate,
                                 @PathVariable(value = "movieId") long movieId
    ) {
        return showManagement.getShows(movieId, location, showDate);
    }

}
