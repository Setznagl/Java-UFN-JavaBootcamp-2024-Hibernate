package JPA.Model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Livro {
    @Id
    @Column(name = "isbn", nullable = false , unique = true ,length = 13)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long isbn;
    /*
    ALTER TABLE Livro
    ALTER COLUMN isbn TYPE bigint USING isbn::bigint;
    */

    @Column(length = 50 , nullable = false)
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_do_livro")
    private Categoria categoria;

    @Column(nullable = false)
    private Integer quantidade;

    public Livro(String nome) {
        this.nome = nome;
    }
}

/*
@ToString.Exclude
private Double salario;
*/
