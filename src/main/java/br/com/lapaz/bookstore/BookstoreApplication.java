package br.com.lapaz.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.lapaz.bookstore.model.Categoria;
import br.com.lapaz.bookstore.model.Livro;
import br.com.lapaz.bookstore.repository.CategoriaRepository;
import br.com.lapaz.bookstore.repository.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	LivroRepository livroRepository;
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de Informatica");
		Categoria cat2 = new Categoria(null, "Romance", "Doramas");
		
		
		Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "LoremIpsum", cat1);
		Livro livro2 = new Livro(null, "Aprenda Java Dormindo", "Robert Dude", "LoremIpsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(livro1,livro2));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		livroRepository.saveAllAndFlush(Arrays.asList(livro1,livro2));
		
	}

}
