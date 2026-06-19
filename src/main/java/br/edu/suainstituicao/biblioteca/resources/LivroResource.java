package br.edu.suainstituicao.biblioteca.resources;

import br.edu.suainstituicao.biblioteca.entities.Livro;
import br.edu.suainstituicao.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService service;

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        List<Livro> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) {
        Livro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Livro> insert(@RequestBody Livro obj) {
        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Este é o endpoint personalizado para buscar os livros de um autor específico!
    @GetMapping(value = "/autor/{autorId}")
    public ResponseEntity<List<Livro>> findByAutorId(@PathVariable Long autorId) {
        List<Livro> list = service.findByAutor(autorId);
        return ResponseEntity.ok().body(list);
    }
}