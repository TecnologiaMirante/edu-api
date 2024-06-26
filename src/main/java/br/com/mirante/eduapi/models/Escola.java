package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name = "estado", nullable = false, length = 2)
    private String estado;

    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;

    @Column(name = "bairro", nullable = false, length = 50)
    private String bairro;

    @Column(name = "numero", nullable = false, length = 5)
    private String numero;

    @Column(name = "logradouro", nullable = false, length = 150)
    private String logradouro;

    @Column(name = "complemento", length = 150)
    private String complemento;

    @Column(name = "cep", nullable = false, length = 15)
    private String cep;

    @Column(name = "referencia", nullable = false, length = 150)
    private String referencia;

}
