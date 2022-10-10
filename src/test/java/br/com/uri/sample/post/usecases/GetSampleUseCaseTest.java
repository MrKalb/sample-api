package br.com.uri.sample.post.usecases;

import br.com.uri.sample.post.entities.SampleEntity;
import br.com.uri.sample.post.exceptions.SampleNotFoundException;
import br.com.uri.sample.post.model.Sample;
import br.com.uri.sample.post.repository.SampleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class GetSampleUseCaseTest {

    @Mock
    private SampleRepository sampleRepository;

    private GetSampleUseCase getSampleUseCase;

    @BeforeEach
    public void initService() {
        this.getSampleUseCase = new GetSampleUseCase(sampleRepository);
    }

    @Test
    public void givenAValidIdWhenGettingSampleShouldReturnSample(){
        Long id = 1L;
        Mockito.when(sampleRepository.findById(id)).thenReturn(Optional.of(getMockEntity(id)));
        Sample result = getSampleUseCase.getSample(id);
        Assertions.assertEquals(id, result.getId());
    }

    @Test
    public void givenAInvalidIdWhenGettingSampleShouldThrowException(){
        Long id = 1L;
        Mockito.when(sampleRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(SampleNotFoundException.class, () ->
            getSampleUseCase.getSample(id));
    }

    private SampleEntity getMockEntity(Long id) {

        return SampleEntity.builder().id(id).name("test").build();
    }

}
