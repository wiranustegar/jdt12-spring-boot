package id.co.indivara.jdt12.bookclient;

import id.co.indivara.jdt12.bookclient.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookclientApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate (RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner akses(RestTemplate restTemplate) throws Exception{
		return args -> {
			Book book =restTemplate.getForObject("http://localhost/book.json", Book.class);

			System.out.println("Book Id: " + book.getBookId());
			System.out.println("Book Title: " + book.getTitle());
			System.out.println("Book Price: " + book.getPrice());
		};
	}

}
