package id.co.indivara.jdt12.json;

import id.co.indivara.jdt12.json.entity.Employee;
import id.co.indivara.jdt12.json.processor.JsonProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee();
		emp.setEmployeeId(1);
		emp.setFirstName("Budi");
		emp.setSalary(2000);
//		JsonProcessor.tulisObjectKeJson(emp,"d:/tulisobjectkejson1.json");

		Employee emp2 = JsonProcessor.bacaJsonKeObject("d:/tulisobjectkejson1.json");
		System.out.println(emp2);

//		JsonProcessor.bacaArrayJsonDariFile("d:/daftarobjectkearrayjson.json");
//		ArrayList<Employee> empList = new ArrayList<>();
//		empList.add(new Employee(2, "Amir", 3000));
//		empList.add(new Employee(3, "Curly", 4000));
//		empList.add(new Employee(4, "Deddy", 1000));
//		JsonProcessor.tulisDaftarObjectKeArrayJson(empList, "d:/daftarobjectkearrayjson.json");

	}

	@Bean
	public CommandLineRunner bacaArrayJson(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				JsonProcessor.bacaArrayJsonDariFile("d:/daftarobjectkearrayjson.json");
			}
		};
	}
}
