package br.com.uri.sample.post.usecases;

import br.com.uri.sample.post.entities.SampleEntity;

public interface GetSample {

   SampleEntity getSample(Long id);

}
