package br.com.uri.sample.post.usecases;

import br.com.uri.sample.post.dto.SampleDTO;

public interface Sample {

    br.com.uri.sample.post.model.Sample doSample(SampleDTO sampleDTO);
}
