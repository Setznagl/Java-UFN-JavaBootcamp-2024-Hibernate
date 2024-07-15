package JPA.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Categoria {

    @Id
    @Column(name = "id", nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 50 , nullable = false)
    private String nome;

    @Column(name = "categoria" , nullable = true)
    @OneToMany(mappedBy = "categoria" )
    private List<Livro> livros;

    // Construtor Simples
    public Categoria(String nome) {
        this.nome = nome;
    }
    // ToString
    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", nome=" + nome + '}';
    }
}
