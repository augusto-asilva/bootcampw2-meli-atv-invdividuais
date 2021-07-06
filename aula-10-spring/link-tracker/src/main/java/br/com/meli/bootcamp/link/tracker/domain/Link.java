package br.com.meli.bootcamp.link.tracker.domain;

public class Link {
    private int id;
    private String uri;
    private int redirects;
    private boolean valid;
    private String password;

    public Link(int id, String uri) {
        this.id = id;
        this.uri = uri;
        this.redirects = 0;
        this.valid = true;
        this.password = "";
    }

    public Link(int id, String uri, String password) {
        this.id = id;
        this.uri = uri;
        this.redirects = 0;
        this.valid = true;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getRedirects() {
        return redirects;
    }

    public void increaseRedirects() {
        this.redirects++;
    }

    public boolean isValid() {
        return valid;
    }

    public String getPassword() {
        return password;
    }

    public void invalidate() {
        this.valid = false;
    }
}
