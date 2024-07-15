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

public class Usuario {
    @Id
    @Column(name = "id_dep", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String nome;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
    private List<Livro> livros;

    public Usuario(String nome) {
        this.nome = nome;
    }
}
