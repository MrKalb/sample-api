package br.com.uri.sample.post.controller;

import br.com.uri.sample.post.entities.SampleEntity;
import br.com.uri.sample.post.usecases.GetSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    @Autowired
    private GetSample getSample;

    @GetMapping("/sample/{id}")
    public ResponseEntity<SampleEntity> getSample
            (@PathVariable("id") Long id
            ) {
            return ResponseEntity.ok(getSample.getSample(id));
    }
}