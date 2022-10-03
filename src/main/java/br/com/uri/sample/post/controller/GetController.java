package br.com.uri.sample.post.controller;

import br.com.uri.sample.post.dto.SampleResponse;
import br.com.uri.sample.post.model.Sample;
import br.com.uri.sample.post.usecases.GetSample;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    private final GetSample getSample;

    public GetController(GetSample getSample) {
        this.getSample = getSample;
    }

    @GetMapping("/sample/{id}")
    public ResponseEntity<SampleResponse> getSample
            (@PathVariable("id") Long id
            ) {
            return ResponseEntity.ok(sampleToSampleResponse(getSample.getSample(id)));
    }

    private SampleResponse sampleToSampleResponse(Sample sample) {
        return SampleResponse.builder()
                .id(sample.getId())
                .name(sample.getName())
                .build();
    }
}
