package br.com.uri.sample.post.usecases;

import br.com.uri.sample.post.entities.SampleEntity;
import br.com.uri.sample.post.exceptions.SampleNotFoundException;
import br.com.uri.sample.post.model.Sample;
import br.com.uri.sample.post.repository.SampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetSampleUseCase implements GetSample {

    private final SampleRepository sampleRepository;

    public GetSampleUseCase(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public Sample getSample(Long id) {
        SampleEntity entity = sampleRepository.findById(id)
                .orElseThrow(() -> new SampleNotFoundException("Sample não encontrado"));

        return entityToModel(entity);
    }

    private Sample entityToModel(SampleEntity entity) {
        return Sample.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
