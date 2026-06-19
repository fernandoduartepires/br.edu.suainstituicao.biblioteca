package br.edu.suainstituicao.biblioteca.repositories;

import br.edu.suainstituicao.biblioteca.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}