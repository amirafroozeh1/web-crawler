package crawler.demo.service;

import crawler.demo.repository.ScheduleUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ScheduleUrlServiceImpl implements ScheduleURLService {

    @Autowired
    ScheduleUrlRepository scheduleUrlRepository;

    @Override
    @Async("processExecutor")
    public void scheduleUrl(String url) {
        scheduleUrlRepository.saveUrls(url);
    }
}
