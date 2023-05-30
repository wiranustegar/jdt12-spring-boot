package id.co.indivara.jdt12.hellospring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	public static void main(String[] args) {
		//mirip seperti kita memanggil start() pada Thread
		//semua kode di atas baris ini, akan jalan pertama
		//baris kode inilah yang akan memanggil run() secara otomatis
		SpringApplication.run(DemoApplication.class, args);
		//semua kode di bawaha baris ini akan selalu jalan paling akhir
		System.out.println("Baris ini pasti akan jalan terakhir");
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.print("Nama: ");
			String nama = sc.nextLine();
			System.out.print("Alamat: ");
			String alamat = sc.nextLine();

			System.out.print("Lagi: y/t : ");
			String jawaban = sc.nextLine();
			if (jawaban.equalsIgnoreCase("t")){
				System.exit(0);
			}
		}

	}

}
