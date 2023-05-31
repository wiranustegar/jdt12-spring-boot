package id.co.indivara.jpamysql;

import id.co.indivara.jpamysql.entity.User;
import id.co.indivara.jpamysql.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Scanner;

@SpringBootApplication
public class JpamysqlApplication{
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpamysqlApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		while (true){
//			System.out.println("===MENU===");
//			System.out.println("1. Entry Data");
//			System.out.println("2. Update Data");
//			System.out.println("3. Find Data");
//			System.out.println("4. Delete Data");
//			System.out.println("5. Show All Data");
//			System.out.println("6. Find By Name");
//			System.out.println("7. Delete By Email");
//			System.out.print("Pilih : [1/.../7]");
//			String pilihan = sc.nextLine();
//			if (pilihan.equals("1")){
//				System.out.println("===Entry Data===");
//				System.out.print("Nama: ");
//				String nama = sc.nextLine();
//				System.out.print("Email: ");
//				String email = sc.nextLine();
//				User user = new User(nama, email);
//				userRepository.save(user);
//			} else if (pilihan.equals("2")) {
//				try {
//					System.out.println("===Update Data===");
//					System.out.println("id user: ");
//					String id = sc.nextLine();
//
//					User u = (User)userRepository.findById(Integer.parseInt(id)).get();
//					System.out.print("Nama: "+ u.getName() + " Change to: ");
//					String nama = sc.nextLine();
//					if (!nama.isEmpty()){
//						u.setName(nama);
//					}
//					System.out.println("Email: " + u.getEmail() + " Change to: ");
//					String email = sc.nextLine();
//					if (!email.isEmpty()){
//						u.setEmail(email);
//					}
//					userRepository.save(u);
//				} catch (Exception ex){
//					System.out.println("Data tidak ada " + ex.getMessage());
//				}
//			} else if (pilihan.equals("3")) {
//				try {
//					System.out.println("==Find Data By ID");
//					System.out.print("id user: ");
//					String id = sc.nextLine();
//					User u = (User) userRepository.findById(Integer.parseInt(id)).get();
//					System.out.println("Nama: "+u.getName());
//					System.out.println("Email: "+u.getEmail());
//				} catch (Exception ex) {
//					System.out.println("Data tidak ada " + ex.getMessage());
//				}
//			} else if (pilihan.equals("4")) {
//				try {
//					System.out.println("===Delete Data===");
//					System.out.print("id user: ");
//					String id = sc.nextLine();
//					userRepository.deleteById(Integer.parseInt(id));
//				} catch (EmptyResultDataAccessException ex){
//					System.out.println("Data tidak ada " + ex.getMessage());
//				} catch (Exception ex){
//					System.out.println("ERROR " + ex.getMessage());
//				}
//			} else if (pilihan.equals("5")) {
//				System.out.println("===ALL DATA===");
//				for (User c : userRepository.findAll() ){
//					System.out.println("Nama: " + c.getName());
//					System.out.println("Email: " + c.getEmail());
//					System.out.println("---------------");
//				}
//
////				 Iterable<User> u = userRepository.findAll();
////				 u.forEach((c)-> {
////					 System.out.println("ID: " + c.getId());
////					 System.out.println("Nama: " + c.getName());
////					 System.out.println("Email: " + c.getEmail());
////					 System.out.println("----------------");
////				 });
//			} else if (pilihan.equals("6")) {
//				try {
//					System.out.println("===Find By Name");
//					System.out.print("Nama: ");
//					String nama = sc.nextLine();
//					for (User c : userRepository.findByName(nama)){
//						System.out.println("Nama: " + c.getName());
//						System.out.println("Email: " + c.getEmail());
//					}
//				} catch (Exception ex){
//					System.out.println("Data tidak ada " + ex.getMessage());
//				}
//			} else if (pilihan.equals("7")) {
//				try {
//					System.out.println("===Delete By Email");
//					System.out.print("Email: ");
//					String email = sc.nextLine();
//					userRepository.deleteByEmail(email);
//				} catch (Exception ex){
//					System.out.println("Data tidak ada " + ex.getMessage());
//				}
//			}
//		}
//	}
}
