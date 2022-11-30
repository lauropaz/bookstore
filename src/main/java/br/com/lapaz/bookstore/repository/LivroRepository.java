package br.com.lapaz.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lapaz.bookstore.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
