package br.com.uri.sample.post.usecases;

import br.com.uri.sample.post.dto.SampleDTO;
import br.com.uri.sample.post.dto.SampleResponse;

public interface Sample {

    SampleResponse doSample(SampleDTO sampleDTO);
}
