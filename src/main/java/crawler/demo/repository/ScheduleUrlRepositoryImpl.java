package crawler.demo.repository;

import crawler.demo.model.WebResult;
import crawler.demo.service.RetrieveResultServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class ScheduleUrlRepositoryImpl implements ScheduleUrlRepository {

    private static final int MAX_DEPTH = 10;
    private static final Logger logger = LoggerFactory.getLogger(RetrieveResultServiceImpl.class);

    private Set<String> links = new HashSet<>();
    private Map<String, WebResult> results = new HashMap<>();

    @Override
    public void     saveUrls(String url) {
        saveLinks(url, 0);
    }

    @Override
    public WebResult getResult(String url) {
        return results.get(url);
    }

    private void saveLinks(String URL, int depth) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        if ((!links.contains(URL) && (depth < MAX_DEPTH))) {

            logger.info(">>>>>> Depth: " + depth + " (" + URL + ")");
            try {
                links.add(URL);

                Document doc = Jsoup.connect(URL).get();
                String title = doc.title();
                results.put(URL, new WebResult(title, dateFormat.format(date), URL, doc.toString()));
                Elements linksOnPage = doc.select("a[href]");
                depth++;

                for (Element page : linksOnPage) {
                    saveLinks(page.attr("abs:href"), depth);
                }
            } catch (IOException e) {
                logger.error("For '" + URL + "': " + e.getMessage());
            } catch (Exception e) {
                logger.error("For '" + URL + "': " + e.getMessage());
            }
        }
    }
}
