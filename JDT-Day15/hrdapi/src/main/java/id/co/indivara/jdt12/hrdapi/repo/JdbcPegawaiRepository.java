package id.co.indivara.jdt12.hrdapi.repo;

import id.co.indivara.jdt12.hrdapi.entity.Pegawai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcPegawaiRepository implements PegawaiRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Pegawai pegawai) {
        return jdbcTemplate.update("INSERT INTO pegawai (nip, nama, gaji, alamat, posisi, pendidikan, status, kelamin, umur, department) VALUES(?,?,?,?,?,?,?,?,?,?)", pegawai.getNip(), pegawai.getNama(), pegawai.getGaji(), pegawai.getAlamat(), pegawai.getPosisi(), pegawai.getPendidikan(), pegawai.getStatus(), pegawai.getKelamin(), pegawai.getUmur(), pegawai.getDepartment());
    }

    @Override
    public int update(Pegawai pegawai) {
        return jdbcTemplate.update("UPDATE pegawai SET nama=?, gaji=?, alamat=?, posisi=?, pendidikan=?, status=?, kelamin=?, umur=?, department=? WHERE nip=?", pegawai.getNama(), pegawai.getGaji(), pegawai.getAlamat(), pegawai.getPosisi(), pegawai.getPendidikan(), pegawai.getStatus(), pegawai.getKelamin(), pegawai.getUmur(), pegawai.getDepartment(), pegawai.getNip());
    }

    @Override
    public int deleteByNip(String nip) {
        return jdbcTemplate.update("DELETE FROM pegawai WHERE nip=?", nip);
    }

    @Override
    public List<Pegawai> findAll() {
        return jdbcTemplate.query("SELECT * FROM pegawai",
                (rs, rowNum)-> new Pegawai(
                        rs.getString("nip"),
                        rs.getString("nama"),
                        rs.getDouble("gaji"),
                        rs.getString("alamat"),
                        rs.getString("posisi"),
                        rs.getString("pendidikan"),
                        rs.getString("status"),
                        rs.getString("kelamin"),
                        rs.getInt("umur"),
                        rs.getString("department")
                )
        );
    }

    @Override
    public List<Pegawai> findByNama(String nama) {
        return jdbcTemplate.query("SELECT * FROM pegawai WHERE nama=?",
                new Object[]{nama},
                (rs, rowNum)-> new Pegawai(
                        rs.getString("nip"),
                        rs.getString("nama"),
                        rs.getDouble("gaji"),
                        rs.getString("alamat"),
                        rs.getString("posisi"),
                        rs.getString("pendidikan"),
                        rs.getString("status"),
                        rs.getString("kelamin"),
                        rs.getInt("umur"),
                        rs.getString("department")
                )
                );
    }

    @Override
    public Pegawai findByNip(String nip) {
        return jdbcTemplate.queryForObject("SELECT * FROM pegawai WHERE nip=?",
                new Object[]{nip},
                (rs,rowNum)->new Pegawai(
                        rs.getString("nip"),
                        rs.getString("nama"),
                        rs.getDouble("gaji"),
                        rs.getString("alamat"),
                        rs.getString("posisi"),
                        rs.getString("pendidikan"),
                        rs.getString("status"),
                        rs.getString("kelamin"),
                        rs.getInt("umur"),
                        rs.getString("department")));
    }
}
