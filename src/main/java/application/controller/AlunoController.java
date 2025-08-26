package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import application.record.AlunoDTO;
import application.record.AlunoinsertDTO;
import application.repository.AlunoRepository;
import application.service.AlunoService;


@RestController
@RequestMapping("/alunos")

public class AlunoController{
    @Autowired
    private AlunoRepository alunoRepo;

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public AlunoDTO insert(@RequestBody AlunoinsertDTO novoAluno){
        return alunoService.insert(novoAluno);
    }

    @GetMapping
    public Iterable<AlunoDTO> getALL() {
        return alunoService.getAll();
    }

    @GetMapping("/{id}")
    public AlunoDTO getOne(@PathVariable long id) {
        return alunoService.getOne(id);
    }

    @PutMapping("/{id}")
    public AlunoDTO update(@PathVariable long id, @RequestBody AlunoDTO novosDados){
        return alunoService.update(id, novosDados);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        if(!alunoRepo.existsById(id)){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aluno não encontrada");
        }
        alunoRepo.deleteById(id);
    }
}