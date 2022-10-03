package br.com.uri.sample.post.usecases;

import br.com.uri.sample.post.entities.SampleEntity;
import br.com.uri.sample.post.exceptions.SampleNotFoundException;
import br.com.uri.sample.post.repository.SampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class GetSampleUseCase implements GetSample {

    private final SampleRepository sampleRepository;

    public GetSampleUseCase(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public SampleEntity getSample(Long id) {
        Optional<SampleEntity> optional = sampleRepository.findById(id);

        if(optional.isEmpty()) {
            log.error("sample not found");
            throw new SampleNotFoundException("Sample não encontrado");
        }

        return optional.get();
    }
}
