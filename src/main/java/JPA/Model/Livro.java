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
    @Column(name = "isbn", nullable = false , unique = true ,length = 13)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;

    @Column(length = 50 , nullable = false)
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_do_livro")
    private Categoria categoria;

    @Column(nullable = false)
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

