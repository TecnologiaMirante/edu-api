package br.com.mirante.eduapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Questoes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    //RELACIONAMENTO AVALIACAO QUESTOES
    @ManyToOne
    @JoinColumn(name = "id_avaliacao", nullable = false)
    private Avaliacao avaliacao;

    //RELACIONAMENTO DISCIPLINA QUESTOES
    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    //RELACIONAMENTO CONTEUDO QUESTOES
    @ManyToOne
    @JoinColumn(name = "id_conteudo", nullable = false)
    private Conteudo conteudo;

    //RELACIONAMENTO QUESTOES OPCOES
    @OneToMany(mappedBy = "questoes", cascade = CascadeType.ALL)
    private List<Opcoes> questoesOpcoesList = new ArrayList<>();


    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
