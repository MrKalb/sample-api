package br.com.uri.sample.post.usecases;

import br.com.uri.sample.post.dto.SampleDTO;
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
    public br.com.uri.sample.post.model.Sample doSample(SampleDTO sampleDTO) {
        SampleEntity entity = saveEntity(sampleDTO);
        return br.com.uri.sample.post.model.Sample.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    private SampleEntity saveEntity(SampleDTO sampleDTO) {
        SampleEntity entity = SampleEntity.builder()
                .name(sampleDTO.getName())
                .build();
        return sampleRepository.save(entity);
    }
}
