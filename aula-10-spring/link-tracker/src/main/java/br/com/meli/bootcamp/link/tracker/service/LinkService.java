package br.com.meli.bootcamp.link.tracker.service;

import br.com.meli.bootcamp.link.tracker.domain.Link;
import br.com.meli.bootcamp.link.tracker.dto.LinkInsertionDTO;
import br.com.meli.bootcamp.link.tracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class LinkService {

    @Autowired
    LinkRepository repository;

    public Link get(Integer id) {
        return repository.findById(id);
    };

    public List<Link> get() {
        return repository.findAll();
    }

    public void addLink(String uri) {
        repository.insertLink(uri);
    }

    public Link addLinkFromDTO(LinkInsertionDTO linkInsertionDTO) {
        try {
            URI url = new URL(linkInsertionDTO.getUri()).toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return repository.insertLinkWithPassword(linkInsertionDTO.getUri(), linkInsertionDTO.getPassword());
    }

    public void updateLink(Integer id, String uri) {
        repository.updateLink(id, uri);
    }

    public void updateRedirectCounter(Integer id) {
        repository.increaseRedirectCounter(id);
    }

    public void invalidateLink(Integer id) {
        repository.invalidateLink(id);
    }

    public void deleteLink(Integer id) {
        repository.removeLink(id);
    }

    public boolean hasPassword(Integer id) {
        Link link = repository.findById(id);
        if (link.getPassword() == "" || link.getPassword() == null) {
            return false;
        }

        return true;
    }

    public boolean validatePassword(Integer id, String password) {
        Link link = repository.findById(id);
        if (link.getPassword() == password) {
            return true;
        }
        return false;
    }

}
