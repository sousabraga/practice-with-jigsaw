package br.com.casadocodigo;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import br.com.casadocodigo.http.data.Books;
import br.com.casadocodigo.domain.model.Book;
import br.com.casadocodigo.nf.service.NFEmissor;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Lista de livros disponiveis");

		List<Book> books = Books.all();

		IntStream.range(0, books.size())
			.forEach(i -> {
				System.out.println(i + " - " + books.get(i).getName());
			}
		);

		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Digite o número	do livro que quer comprar: ");
			int number = scanner.nextInt();
			
			Book book = books.get(number);

			System.out.println("O livro	escolhido foi: " + book.getName());
			System.out.println("Informe	seu	nome, para que possamos	emitir a nota fiscal");

			scanner	= new Scanner(System.in);
			String name = scanner.nextLine();

			NFEmissor emissor = new NFEmissor();
			emissor.emit(name, book);

			System.out.println("Obrigado!");
			
			Books.findSimilar(book).ifPresentOrElse(showSimilar, noSuggestions);

			// segura a	execução para o	código assíncrono terminar
			System.out.println("Aperte o enter para sair");
			scanner = new Scanner(System.in);
			scanner.nextLine();
						
			emissor.close();
		} catch (Exception e) {
			System.err.println("Ops, aconteceu	um	erro: " + e);
		} 
	}

	private static Consumer<Book> showSimilar = similar -> {
		System.out.println("Talvez você também goste do livro: " + similar.getName());
	};

	private static Runnable noSuggestions = () -> {
		System.out.println("Não	temos nenhuma sugestão de livro similar no momento");
	};

}
