package br.com.uri.sample.post.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class SampleEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
