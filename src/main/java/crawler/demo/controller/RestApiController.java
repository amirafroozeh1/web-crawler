package crawler.demo.controller;

import crawler.demo.model.WebResult;
import crawler.demo.service.RetrieveResultService;
import crawler.demo.service.ScheduleURLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class RestApiController {

    private static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    private final ScheduleURLService scheduleURLService;
    private final RetrieveResultService retrieveResultService;

    @Autowired
    public RestApiController(ScheduleURLService scheduleURLService, RetrieveResultService retrieveResultService) {
        this.scheduleURLService = scheduleURLService;
        this.retrieveResultService = retrieveResultService;
    }

    /**
     * This method receives URL. I used post method instead of get method because this url has "/" character( Other solution is encoding the url)
     */
    @RequestMapping(value = "/scheduleURL", method = RequestMethod.POST)
    public ResponseEntity<?> scheduleURL(@RequestBody String url) {

        logger.info("scheduling a url ");
        scheduleURLService.scheduleUrl(url);
        return new ResponseEntity<>("scheduled a url", HttpStatus.OK);
    }

    /**
     *  This method receives URL. I used post method instead of get method because this url has "/" character( Other solution is encoding the url)
     */
    @RequestMapping(value = "/getResult", method = RequestMethod.POST)
    public ResponseEntity<?> retrieveResult(@Valid @RequestBody String url) throws IOException {

        logger.info("creating a list of fractions ");
        WebResult result = retrieveResultService.retrieveResult(url);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
