package br.com.meli.bootcamp.link.tracker.dto;

public class LinkInsertionDTO {
    private String uri;
    private String password;

    public LinkInsertionDTO(String uri, String password) {
        this.uri = uri;
        this.password = password;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
