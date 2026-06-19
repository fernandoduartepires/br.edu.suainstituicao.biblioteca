package br.edu.suainstituicao.biblioteca.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String nacionalidade;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "autor")
    
    private List<Livro> livros = new ArrayList<>();

    public Autor() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", nacionalidade=" + nacionalidade + ", dataNascimento="
				+ dataNascimento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(id, other.id);
	}

	public Autor(String nome, String nacionalidade, LocalDate dataNascimento, List<Livro> livros) {
		super();
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.dataNascimento = dataNascimento;
		this.livros = livros;
	}

    
    
    
    

}