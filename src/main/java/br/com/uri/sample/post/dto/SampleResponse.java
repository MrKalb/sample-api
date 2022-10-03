package br.com.uri.sample.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SampleResponse {

    private Long id;

    private String name;

}
