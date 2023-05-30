package id.co.indivara.jdt12.restclient;

import id.co.indivara.jdt12.restclient.entity.Pegawai;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestclientApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Pegawai pegawai = restTemplate.getForObject("http://localhost/pegawai.json", Pegawai.class);

			System.out.println(pegawai);
		};

	}

}
