package app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;

    @JsonProperty("nome")
    @NotBlank(message = "Nome da marca é obrigatório")
    private String nome;

    @OneToMany(mappedBy = "marca",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    @JsonProperty("carros")
    private List<Carro> carros;

    public void setId(long id) {
        this.id = id;
    }
}
