package id.co.indivara.jdt12.hrdapi.controller;

import id.co.indivara.jdt12.hrdapi.entity.Pegawai;
import id.co.indivara.jdt12.hrdapi.entity.ResponseMessage;
import id.co.indivara.jdt12.hrdapi.repo.PegawaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;

@RestController
public class PegawaiController {

    @Autowired
    @Qualifier("jdbcPegawaiRepository")
    private PegawaiRepository pegawaiRepository;

    @PostMapping("/create")
    public ResponseMessage createPegawai(@RequestBody Pegawai pegawai){
        if (pegawaiRepository.save(pegawai) > 0){
            return new ResponseMessage(200,"INSERT SUCCESS");
        }
        return new ResponseMessage(201,"INSERT FAILED");
    }

    @PostMapping("/update")
    private ResponseMessage updatePegawai(@RequestBody Pegawai pegawai){
        if (pegawaiRepository.update(pegawai) > 0){
            return new ResponseMessage(200,"UPDATE SUCCESS");
        }
        return new ResponseMessage(201,"UPDATE FAILED");
    }

    @GetMapping("/delete/{nip}")
    private ResponseMessage deletePegawai(@PathVariable String nip){
        if (pegawaiRepository.deleteByNip(nip) > 0){
            return new ResponseMessage(200,"DELETE SUCCESS");
        }
        return new ResponseMessage(201,"DELETE FAILED");

    }

    @GetMapping("/findnip/{nip}")
    public Pegawai findPegawaiByNip(@PathVariable String nip){
        return pegawaiRepository.findByNip(nip);
    }

    @GetMapping("/findnama/{nama}")
    public ArrayList<Pegawai> findPegawaiByNama(@PathVariable String nama){
        return (ArrayList<Pegawai>) pegawaiRepository.findByNama(nama);
    }

    @GetMapping("/all")
    public ArrayList<Pegawai> findAllPegawai(){
        return (ArrayList<Pegawai>) pegawaiRepository.findAll();
    }

}
