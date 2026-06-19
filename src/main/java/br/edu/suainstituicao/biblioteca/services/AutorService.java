package br.edu.suainstituicao.biblioteca.services;

import br.edu.suainstituicao.biblioteca.entities.Autor;
import br.edu.suainstituicao.biblioteca.exceptions.ResourceNotFoundException;
import br.edu.suainstituicao.biblioteca.repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository repository;

    AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public List<Autor> findAll() {
        return repository.findAll();
    }

    public Autor findById(Long id) {
        Optional<Autor> obj = repository.findById(id);
     
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Autor insert(Autor obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public Autor update(Long id, Autor obj) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        obj.setId(id);
        return repository.save(obj);
    }
}