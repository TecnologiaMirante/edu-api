package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name = "sexo", nullable = false, length = 9)
    private String sexo;

    @Column(name = "cpf", nullable = false, length = 15)
    private String cpf;

    @Column(name = "matricula", nullable = false, length = 50)
    private String matricula;

    @Column(name = "avatarUrl", nullable = false, length = 100)
    private String avatar;

    @Column(name = "data_de_nascimento", nullable = false, length = 100)
    private LocalDateTime dateDeNascimento;

    @Column(name = "status", nullable = false, length = 10)
    private String status;

    @Column(name = "instagram_url", nullable = false, length = 100)
    private String instagram;

    @Column(name = "facebook_url", nullable = false, length = 100)
    private String facebook;

    @Column(name = "whatssapp_url", nullable = false, length = 100)
    private String whatssapp;

    @Column(name = "twitter_url", nullable = false, length = 100)
    private String twitter;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;

    @Column(name = "bairro", nullable = false, length = 100)
    private String bairro;

    @Column(name = "numero_endereco", nullable = false, length = 100)
    private Integer numeroEndereco;

    @Column(name = "complemento", nullable = false, length = 100)
    private String complemento;

    @Column(name = "cep", nullable = false, length = 100)
    private Integer cep;

    @Column(name = "referencia", nullable = false, length = 100)
    private String referencia;

    @ManyToOne
    @JoinColumn(name = "id_escola")
    private Escola escola;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Professor> professorList = new ArrayList<>();

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Aluno> alunoList = new ArrayList<>();

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Admin> adminList = new ArrayList<>();


}