package crawler.demo.integration;

import crawler.demo.service.RetrieveResultService;
import crawler.demo.service.ScheduleURLService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestApiIntegrationTest {


    @Autowired
    RetrieveResultService retrieveResultService;

    @Autowired
    ScheduleURLService scheduleURLService;

    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();

    private String url;
    @Before
    public void setUp() {
        url = "www.yahoo.com";
    }

    @Test
    public void scheduleURLTest() throws Exception {

        ResponseEntity<?> responseEntity = restTemplate.postForEntity("/scheduleURL", url,
                String.class
        );
        int status = responseEntity.getStatusCodeValue();

        Assert.assertEquals("Correct Response Status", HttpStatus.OK.value(), status);
    }

    @Test
    public void getResultTest() throws Exception {

        ResponseEntity<?> responseEntity = restTemplate.postForEntity("/scheduleURL", url,
                String.class
        );
        int status = responseEntity.getStatusCodeValue();

        Assert.assertEquals("Correct Response Status", HttpStatus.OK.value(), status);
    }
}
