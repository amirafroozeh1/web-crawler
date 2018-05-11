package crawler.demo.model;


public class WebResult {

    private String title;
    private String date;
    private String url;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WebResult(String title, String date, String url, String content) {
        this.title = title;
        this.date = date;
        this.url = url;
        this.content = content;
    }

    public WebResult(){

    }
}
