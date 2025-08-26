package application.service;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import application.repository.AlunoRepository;
import application.record.AlunoDTO;
import application.record.AlunoinsertDTO;
import application.model.Aluno;
import application.service.AlunoService;


@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepo;

    public Iterable<AlunoDTO> getAll() {
        return alunoRepo.findAll().stream().map(AlunoDTO::new).toList();
    }

    public AlunoDTO insert(AlunoinsertDTO novoAluno) {
        return new AlunoDTO(alunoRepo.save(new Aluno(novoAluno)));
    }
    
    public AlunoDTO getOne(long id) {
        Optional<Aluno> resultado = alunoRepo.findById(id);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aluno não encontrado"
            );
        }
        return new AlunoDTO(resultado.get());
    }

    public AlunoDTO update(long id, AlunoDTO novosDados) {
        Optional <Aluno> resultado = alunoRepo.findById(id);

        if(resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aluno não encontrada"
            );
        }
        resultado.get().setIdade(novosDados.idade());
        resultado.get().setNome(novosDados.nome());
        
        return new AlunoDTO(alunoRepo.save (resultado.get()));
    }
}
