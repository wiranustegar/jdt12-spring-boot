package id.co.exercise.day14;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ini otomatis Running");
	}

	@Bean
	public CommandLineRunner runDenganLambdaExpression(){
		return (args) -> {
			System.out.println("ini Run dengan Lambda");
		};
	}

	@Bean
	public CommandLineRunner runDenganAnonymousInnerClass(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("ini Run dengan Anonymous Inner Class");
			}
		};
	}

	@Bean
	public CommandLineRunner runDenganClassBiasa(){
		return new BiasaClass();
	}


}
