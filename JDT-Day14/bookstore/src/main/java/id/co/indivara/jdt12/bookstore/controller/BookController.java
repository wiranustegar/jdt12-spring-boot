package id.co.indivara.jdt12.bookstore.controller;

import id.co.indivara.jdt12.bookstore.entity.Book;
import id.co.indivara.jdt12.bookstore.entity.BukuMahal;
import id.co.indivara.jdt12.bookstore.entity.BukuMurah;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookController {


    @GetMapping("/book/{isbn}/{judul}/{pengarang}")
    public Book tampilkanBuku(@PathVariable("isbn") String isbn,
                              @PathVariable("judul") String judul,
                              @PathVariable("pengarang") String pengarang){

        return new Book(isbn, judul, pengarang);
    }

//    @PostMapping("/simpan")
//    public Book simpanBuku(@RequestBody Book jsonData){
//        Book b = jsonData;
//        b.setPengarang(b.getPengarang()+ " Ini dari json");
//        return b;
//    }

    @PostMapping("/simpan")
    public BukuMahal simpanBuku (@RequestBody Book jsonData){
        Book b = jsonData;
        BukuMahal bm = new BukuMahal();
        bm.setIsbn(b.getIsbn());
        bm.setJudul(b.getJudul());
        bm.setPengarang(b.getPengarang());
        bm.setKemasan("Kotak Kayu");
        bm.setCover("Plastik");
        return bm;
    }

    @GetMapping("/all")
    public ArrayList<Book> findAllBook(){
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("A111", "Semut Merah", "Aguy"));
        list.add(new Book("B222", "Dunia Halo", "Carlo"));
        list.add(new Book("C333", "Lajak Baut", "Bugy"));

        return list;
    }

    @PostMapping("/termurah")
    public BukuMurah findBukuTermurah(@RequestBody ArrayList<BukuMurah> list){
        BukuMurah buku = list.get(1);
        for (BukuMurah b : list){
            if (b.getHarga() < buku.getHarga()){
                buku = b;
            }
        }

        return buku;
    }

//    @GetMapping("/jual")
//    public Book jualBukuGet(@RequestParam(value = "isbn", defaultValue = "defaultISBN") String isbn,
//                         @RequestParam(value = "judul", defaultValue = "noTitle") String judul,
//                         @RequestParam(value = "pengarang", defaultValue = "noName") String pengarang){
//
//        return new Book(isbn, judul,pengarang + " ini GET");
//    }
//
//    @PostMapping("/jual")
//    public Book jualBukuPost(@RequestParam(value = "isbn", defaultValue = "defaultISBN") String isbn,
//                         @RequestParam(value = "judul", defaultValue = "noTitle") String judul,
//                         @RequestParam(value = "pengarang", defaultValue = "noName") String pengarang){
//
//        return new Book(isbn, judul,pengarang + " ini POST");
//    }
//
//    @PutMapping("/jual")
//    public Book jualBukuPut(@RequestParam(value = "isbn", defaultValue = "defaultISBN") String isbn,
//                         @RequestParam(value = "judul", defaultValue = "noTitle") String judul,
//                         @RequestParam(value = "pengarang", defaultValue = "noName") String pengarang){
//
//        return new Book(isbn, judul,pengarang + " ini PUT");
//    }
//
//    @PatchMapping("/jual")
//    public Book jualBukuPatch(@RequestParam(value = "isbn", defaultValue = "defaultISBN") String isbn,
//                         @RequestParam(value = "judul", defaultValue = "noTitle") String judul,
//                         @RequestParam(value = "pengarang", defaultValue = "noName") String pengarang){
//
//        return new Book(isbn, judul,pengarang + " ini PATCH");
//    }
//
//    @DeleteMapping("/jual")
//    public Book jualBukuDelete(@RequestParam(value = "isbn", defaultValue = "defaultISBN") String isbn,
//                         @RequestParam(value = "judul", defaultValue = "noTitle") String judul,
//                         @RequestParam(value = "pengarang", defaultValue = "noName") String pengarang){
//
//        return new Book(isbn, judul,pengarang + " ini DELETE");
//    }
}
