package br.com.meli.bootcamp.link.tracker.advisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class LinkControllerAdvisor {

    @ExceptionHandler({MalformedURLException.class, URISyntaxException.class})
    public ResponseEntity<Object> handleUrlMalformed(
            MalformedURLException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Invalid URL");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
