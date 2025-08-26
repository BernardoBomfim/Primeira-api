package application.model;

import application.record.AlunoDTO;
import application.record.AlunoinsertDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int idade;

    public Aluno(AlunoDTO dados){
        this.setId(dados.id());
        this.setIdade(dados.idade());
        this.setNome(dados.nome());

    }
    public Aluno(AlunoinsertDTO dados){
        this.setIdade(dados.idade());
        this.setNome(dados.nome());

    }
}