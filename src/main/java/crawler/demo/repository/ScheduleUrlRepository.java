package crawler.demo.repository;

import crawler.demo.model.WebResult;

public interface ScheduleUrlRepository {

    void saveUrls(String url);

    WebResult getResult(String url);

}
