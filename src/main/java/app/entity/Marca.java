package app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private long id;

    @JsonProperty("name")
    private String nome;

    @JsonProperty("cnpj")
    private String cnpj;

    @OneToMany(mappedBy = "marca",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Carro> carros;


    public void setId(long id) {
        this.id = id;
    }

}
