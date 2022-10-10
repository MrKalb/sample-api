package br.com.uri.sample.post.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sample {

    private Long id;

    private String name;

}
