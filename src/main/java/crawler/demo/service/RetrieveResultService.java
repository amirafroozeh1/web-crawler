package crawler.demo.service;

import crawler.demo.model.WebResult;

import java.io.IOException;

public interface RetrieveResultService {

    WebResult retrieveResult(String url) throws IOException;

}
