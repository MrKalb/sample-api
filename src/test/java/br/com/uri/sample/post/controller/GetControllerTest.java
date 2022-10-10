package br.com.uri.sample.post.controller;

import br.com.uri.sample.post.exceptions.SampleNotFoundException;
import br.com.uri.sample.post.model.Sample;
import br.com.uri.sample.post.usecases.GetSample;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = GetController.class)
public class GetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetSample getSample;


    @Test
    public void givenAValidIdWhenGettingSampleShouldReturnSampleResponse() throws Exception {
        Long id = 1L;
        String URI = "/sample/" + id;

        Mockito.when(getSample.getSample(id)).thenReturn(mockSample(id));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    @Test
    public void givenAInvalidIdWhenGettingSampleShouldThrowSampleNotFoundException() throws Exception {
        Long id = 1L;
        String URI = "/sample/" + id;

        Mockito.when(getSample.getSample(id)).thenThrow(new SampleNotFoundException("Sample not found"));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist());
    }

    private Sample mockSample(Long id) {
        return Sample.builder()
                .id(id)
                .name("test")
                .build();
    }

}
