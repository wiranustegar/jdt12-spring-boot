package id.co.indivara.jdt12.bookstoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookstoreapiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreapiApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BookstoreapiApplication.class);
	}

	//	@Profile("firstrun")
//	@Bean
//	CommandLineRunner initDatabase(BookRepository bookRepository){
//		return args -> {
//			bookRepository.save(new Book("Cara anu", "Jeka rowling", new BigDecimal(19.80)));
//			bookRepository.save(new Book("Cara bernafas", "John doe", new BigDecimal(14.80)));
//		};
//	}

}
