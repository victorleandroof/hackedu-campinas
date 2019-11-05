package br.gov.sp.campinas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("mensagem")
public class Mensagem implements Serializable {

    @Id
    @Field("id")
    @JsonProperty("id")
    private String id;
    @Field("mensagem")
    @JsonProperty("mensagem")
    @NotBlank
    private String mensagem;
    @DBRef
    private Mono<Responsavel> responsavel;
    @DBRef
    private Mono<Professor> professor;
    @CreatedDate
    @Builder.Default
    @JsonProperty("timestamp")
    private LocalDateTime createdDate = LocalDateTime.now();

}
