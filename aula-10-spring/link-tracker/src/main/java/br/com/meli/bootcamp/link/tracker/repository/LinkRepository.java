package br.com.meli.bootcamp.link.tracker.repository;

import br.com.meli.bootcamp.link.tracker.domain.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinkRepository {

    private static final Map<Integer, Link> MAP = new HashMap<Integer, Link>();
    private static Integer counter = 0;

    public Link findById(Integer id) {
        return MAP.get(id);
    };

    public List<Link> findAll() {
        return new ArrayList<>(MAP.values());
    }

    public void insertLink(String uri) {
        MAP.put(counter, new Link(counter, uri));
        counter++;
    }

    public Link insertLinkWithPassword(String uri, String password) {
        Link link = new Link(counter, uri, password);
        MAP.put(counter, link);
        counter++;
        return link;
    }

    public void updateLink(Integer id, String uri) {
        Link link = findById(id);
        link.setUri(uri);
    }

    public void increaseRedirectCounter(Integer id) {
        Link link = findById(id);
        link.increaseRedirects();
    }

    public void invalidateLink(Integer id) {
        Link link = findById(id);
        link.invalidate();
    }

    public void removeLink(Integer id) {
        MAP.remove(id);
    }

}
