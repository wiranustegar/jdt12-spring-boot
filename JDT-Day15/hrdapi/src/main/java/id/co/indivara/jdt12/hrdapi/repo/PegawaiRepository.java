package id.co.indivara.jdt12.hrdapi.repo;

import id.co.indivara.jdt12.hrdapi.entity.Pegawai;

import java.util.List;

public interface PegawaiRepository {
    int save(Pegawai pegawai);
    int update(Pegawai pegawai);
    int deleteByNip(String nip);
    List<Pegawai> findAll();
    List<Pegawai> findByNama(String nama);
    Pegawai findByNip(String nip);
}
