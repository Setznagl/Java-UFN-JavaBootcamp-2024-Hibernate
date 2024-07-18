package JPA.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Livro {
    @Id
    @Column(name = "ISBN", nullable = false , unique = true ,length = 14)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;

    @Column(name = "Nome", length = 50 , nullable = false)
    private String nome;

    @Column(name = "Categoria", length = 50, nullable = true)
    private String categoria;

    @Column(name = "Quantidade", nullable = false)
    private Integer quantidade;

    //Construtor Simples
    public Livro(String nome) {
        this.nome = nome;
    };
    // ToString
    @Override
    public String toString() {
        return "Livro{" + "isbn=" + isbn + ", nome=" + nome +
        ", categoria=" + categoria + ", quantidade=" + quantidade +'}';
    }
}

