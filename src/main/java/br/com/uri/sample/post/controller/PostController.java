package br.com.uri.sample.post.controller;

import br.com.uri.sample.post.dto.SampleDTO;
import br.com.uri.sample.post.dto.SampleResponse;
import br.com.uri.sample.post.usecases.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private Sample sample;

    @PostMapping("/sample")
    public ResponseEntity<SampleResponse> post(@RequestBody SampleDTO sampleDTO) {

        return ResponseEntity.ok(sample.doSample(sampleDTO));
    }
}
