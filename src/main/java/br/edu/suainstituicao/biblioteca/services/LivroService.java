package br.edu.suainstituicao.biblioteca.services;

import br.edu.suainstituicao.biblioteca.entities.Livro;
import br.edu.suainstituicao.biblioteca.exceptions.ResourceNotFoundException;
import br.edu.suainstituicao.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public List<Livro> findAll() {
        return repository.findAll();
    }

    public Livro findById(Long id) {
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Livro insert(Livro obj) {
        validarRegrasDeNegocio(obj);
        return repository.save(obj);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public Livro update(Long id, Livro obj) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        validarRegrasDeNegocio(obj);
        obj.setId(id);
        return repository.save(obj);
    }


    public List<Livro> findByAutor(Long autorId) {
        return repository.findByAutorId(autorId);
    }


    private void validarRegrasDeNegocio(Livro obj) {
        if (obj.getAnoPublicacao() != null && obj.getAnoPublicacao() > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("O ano de publicação não pode ser maior que o ano atual.");
        }
        if (obj.getNumeroPaginas() != null && obj.getNumeroPaginas() <= 0) {
            throw new IllegalArgumentException("O número de páginas deve ser maior que zero.");
        }
    }
}