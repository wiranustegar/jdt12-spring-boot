package id.co.indivara.jdt12.jpamysqllombok;

import id.co.indivara.jdt12.jpamysqllombok.entity.ResponseMessage;
import id.co.indivara.jdt12.jpamysqllombok.entity.User;
import id.co.indivara.jdt12.jpamysqllombok.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class JpamysqllombokApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpamysqllombokApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		RestTemplateBuilder builder = new RestTemplateBuilder();
		RestTemplate template = builder.build();

		//TAMBAHKAN 2 BARIS BERIKUT INI JIKA ADA METHOD PATCH YANG AKAN DIPANGGIL
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		template.setRequestFactory(requestFactory);

		while (true){
			System.out.println("===MENU===");
			System.out.println("1. Entry Data");
			System.out.println("2. Update Data");
			System.out.println("3. Find Data");
			System.out.println("4. Delete Data");
			System.out.println("5. Show All Data");
			System.out.println("6. Find By Name");
			System.out.println("7. Delete By Email");
			System.out.println("8. EXIT");
			System.out.print("Pilih [1/.../7]: ");
			String pilihan = sc.nextLine();
			if (pilihan.equals("1")){
				System.out.println("===Entry Data===");
				System.out.print("Nama: ");
				String nama = sc.nextLine();
				System.out.print("Email: ");
				String email = sc.nextLine();
				User user = new User(null, nama, email);
				ResponseMessage rm =  template.postForObject("http://localhost:8080/create", user, ResponseMessage.class);
				System.out.println("Code: " + rm.getCode() + " Message: " + rm.getMessage());
			} else if (pilihan.equals("2")) {
				System.out.println("===Update Data===");
				System.out.print("id User : ");
				String id = sc.nextLine();


				User u = template.getForObject("http://localhost:8080/find/" + id, User.class);
				System.out.print("Nama: " + u.getName() + " Change to: ");
				String nama =sc.nextLine();
				if (!nama.isEmpty()){
					u.setName(nama);
				}

				System.out.print("Email: " + u.getEmail() + " Change to: ");
				String email = sc.nextLine();
				if (!email.isEmpty()){
					u.setEmail(email);
				}

				User user = new User(Integer.parseInt(id), nama, email);
				ResponseMessage rm = template.patchForObject("http://localhost:8080/update", user, ResponseMessage.class);
				System.out.println("Code: " + rm.getCode() + " Message: " + rm.getMessage());

			} else if (pilihan.equals("3")) {
				System.out.println("===Find Data===");
				System.out.print("id user: ");
				String id = sc.nextLine();
				User user = template.getForObject("http://localhost:8080/find/" + id, User.class);
				System.out.println(user.getName());
				System.out.println(user.getEmail());
//				System.out.println("Code: " + user.getCode() + " Message: " + rm.getMessage());
			} else if (pilihan.equals("4")) {
				System.out.println("===Delete Data===");
				System.out.print("id user: ");
				String id = sc.nextLine();
				ResponseMessage rm =  template.getForObject("http://localhost:8080/delete/" + id, ResponseMessage.class);
				System.out.println("Code: " + rm.getCode() + " Message: " + rm.getMessage());

			} else if (pilihan.equals("5")) {
				System.out.println("===Show All Data===");
				ArrayList list = template.getForObject("http://localhost:8080/all", ArrayList.class);
				for (Object c : list){
					System.out.println(((LinkedHashMap)c).get("name"));
					LinkedHashMap<String, String > lm = (LinkedHashMap)c;
					for (Map.Entry m : lm.entrySet()){
						System.out.println(m.getKey() + " :" + m.getValue());
					}
					System.out.println("--------------");
				}
			} else if (pilihan.equals("6")) {
				System.out.println("===Find By Name===");
				System.out.print("Nama: ");
				String nama = sc.nextLine();
				ArrayList<User> list = template.getForObject("http://localhost:8080/findname?name=" + nama, ArrayList.class);
				for (Object c : list){
					System.out.println(((LinkedHashMap)c).get("name"));
					LinkedHashMap<String, String > lm = (LinkedHashMap)c;
					for (Map.Entry m : lm.entrySet()){
						System.out.println(m.getKey() + " :" + m.getValue());
					}
					System.out.println("--------------");
				}
			} else if (pilihan.equals("7")) {
				System.out.println("===Delete By Email===");
				System.out.print("id user: ");
				String email = sc.nextLine();
				ResponseMessage rm =  template.getForObject("http://localhost:8080/deleteemail/" + email, ResponseMessage.class);
				System.out.println("Code: " + rm.getCode() + " Message: " + rm.getMessage());
			} else if (pilihan.equals("8")) {
				break;
			}

//			ResponseEntity<List<User>> userResponse =
//					template.exchange(url+"/user",
//							HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
//							});
//			List<User> users = userResponse.getBody();
//			for(User user: users) System.out.println(user);
		}
	}
}
