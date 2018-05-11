package crawler.demo.service;


import crawler.demo.model.WebResult;
import crawler.demo.repository.ScheduleUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetrieveResultServiceImpl implements RetrieveResultService {

    @Autowired
    ScheduleUrlRepository scheduleUrlRepository;

    @Override
    public WebResult retrieveResult(String url) {
        return scheduleUrlRepository.getResult(url);
    }
}

