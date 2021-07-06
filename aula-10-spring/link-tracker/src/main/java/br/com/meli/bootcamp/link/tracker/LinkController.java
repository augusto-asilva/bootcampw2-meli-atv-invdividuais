package br.com.meli.bootcamp.link.tracker;

import br.com.meli.bootcamp.link.tracker.domain.Link;
import br.com.meli.bootcamp.link.tracker.dto.LinkInsertionDTO;
import br.com.meli.bootcamp.link.tracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    LinkService service;

    @GetMapping("/")
    public ResponseEntity<List<Link>> getAllLinks() {
        List<Link> links = service.get();
        return new ResponseEntity<>(links, HttpStatus.FOUND);
    }

    @GetMapping("/404")
    public ResponseEntity<String> get404() {
        return new ResponseEntity<>("Link not found!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{linkId}")
    public RedirectView getLinkAndRedirect(@PathVariable Integer linkId, @RequestParam String password, RedirectAttributes attributes) {
        Link link = service.get(linkId);
        if (!service.hasPassword(link.getId())) {
            attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
            attributes.addAttribute("attribute", "redirectWithRedirectView");
            return new RedirectView(link.getUri());
        }
        if (service.validatePassword(link.getId(), password)) {
            attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
            attributes.addAttribute("attribute", "redirectWithRedirectView");
            return new RedirectView(link.getUri());
        }
        return new RedirectView("http://localhost:8080/link/404");
    }

    @PostMapping("/")
    public ResponseEntity<Link> postLink(@RequestBody LinkInsertionDTO linkInsertionDTO) {
        Link link = service.addLinkFromDTO(linkInsertionDTO);
        return new ResponseEntity<>(link, HttpStatus.CREATED);
    }

    @GetMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invadateLink(@PathVariable Integer linkId) {
        service.invalidateLink(linkId);
        return new ResponseEntity<>("invalidated", HttpStatus.OK);
    }
}
