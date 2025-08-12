package application.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
    // Criando um conjunto de dados
    //private List<String> frutas = Arrays.asList("Maçã", "Uva", "Banana", "Pera");
    private List<String> frutas = new ArrayList <String>();

    @GetMapping
    public List<String> home() {
        return frutas;
    }

    @PostMapping
    public List<String> insert(@RequestBody String fruta) {
        frutas.add(fruta);
        return frutas;
    }
}