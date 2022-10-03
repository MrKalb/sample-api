package br.com.uri.sample.post.usecases;

import br.com.uri.sample.post.dto.SampleDTO;
import br.com.uri.sample.post.dto.SampleResponse;
import br.com.uri.sample.post.entities.SampleEntity;
import br.com.uri.sample.post.repository.SampleRepository;
import org.springframework.stereotype.Service;

@Service
public class SampleUseCase implements Sample {

    private final SampleRepository sampleRepository;

    public SampleUseCase(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public SampleResponse doSample(SampleDTO sampleDTO) {
        SampleEntity entity = new SampleEntity();
        entity.setName(sampleDTO.getName());
        sampleRepository.save(entity);
        return new SampleResponse(sampleDTO.getName() + sampleDTO.getId());
    }
}
