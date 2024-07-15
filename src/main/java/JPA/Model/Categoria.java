package JPA.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Categoria {

    @Id
    @Column(name = "id", nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 50)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros;

    public Categoria(String nome) {
        this.nome = nome;
    }
}
