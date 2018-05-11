package crawler.demo.unit.service;


import crawler.demo.model.WebResult;
import crawler.demo.repository.ScheduleUrlRepository;
import crawler.demo.service.RetrieveResultService;
import crawler.demo.service.RetrieveResultServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RetrieveResultServiceTest {


    @InjectMocks
    private RetrieveResultService retrieveResultService = new RetrieveResultServiceImpl();

    @Mock
    private ScheduleUrlRepository scheduleUrlRepository;

    private String url;
    private WebResult result;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        url = "www.google.com";
        result = new WebResult();
    }

    @Test
    public void retrieveResultTest() throws Exception {
        when(retrieveResultService.retrieveResult(url)).thenReturn(result);
        WebResult scheduleUrlRepositoryResult = scheduleUrlRepository.getResult(url);
        assertThat(scheduleUrlRepositoryResult, is(equalTo(result)));
    }
}