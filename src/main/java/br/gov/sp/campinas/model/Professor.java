package br.gov.sp.campinas.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("professor")
public class Professor implements Serializable {

    @Id
    @Field("id")
    @JsonProperty("id")
    private String id;
    @Field("nome")
    @JsonProperty("nome")
    @NotBlank
    @Size(max = 100,min = 8)
    private String nome;

}
