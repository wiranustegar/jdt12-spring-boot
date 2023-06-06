package id.co.indivara.jdt12.validation.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
    @NotNull(message = "Maaf, Nama wajib diisi")
    @Size(min = 2, max = 30, message = "Nama minimal 2 huruf, max 30 huruf")
    private String nama;

    @NotNull(message = "Maaf, umur wajib diisi")
    @Min(value = 18, message = "Umur harus lebih dari 18 tahun")
    private Integer umur;
    private String keterangan;

    public Person() {
    }

    public Person(String nama, Integer umur, String keterangan) {
        this.nama = nama;
        this.umur = umur;
        this.keterangan = keterangan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nama='" + nama + '\'' +
                ", umur=" + umur +
                ", keterangan='" + keterangan + '\'' +
                '}';
    }
}
