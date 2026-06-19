package br.edu.suainstituicao.biblioteca.repositories; 

import br.edu.suainstituicao.biblioteca.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
   List<Livro> findByAutorId(Long autorId);
}