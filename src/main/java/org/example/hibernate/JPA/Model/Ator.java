package org.example.hibernate.JPA.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Ator {
    @Id
    @Column(name= "cod_ator",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
