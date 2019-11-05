package br.gov.sp.campinas.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("usuario")
public class Usuario implements Serializable {

    @Id
    @Field("id")
    @JsonProperty("id")
    private String id;
    @Field("email")
    @JsonProperty("email")
    @Email
    private String email;
    @Field("senha")
    @JsonProperty("senha")
    @NotBlank
    @Size(min = 8,max = 20)
    private String senha;
    @Field("status")
    @JsonProperty("status")
    private String status;
    @Field("tipoUsuario")
    @JsonProperty("tipo_usuario")
    @NotBlank
    private TipoUsuario tipoUsuario;
    @Field("professor")
    @JsonProperty("professor")
    private Professor professor;
    @Field("responsavel")
    @JsonProperty("responsavel")
    private Responsavel responsavel;
    @CreatedDate
    @Builder.Default
    @JsonProperty("timestamp")
    private LocalDateTime createdDate = LocalDateTime.now();
    private List<Authority> authorities = new ArrayList<Authority>(){
        {
            add(Authority.ROLE_USER);
        }
    };
}
