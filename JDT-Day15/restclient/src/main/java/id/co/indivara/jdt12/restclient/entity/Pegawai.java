package id.co.indivara.jdt12.restclient.entity;

public class Pegawai {
    private String nip;
    private String nama;
    private double gaji;
    private String alamat;
    private String posisi;
    private String pendidikan;
    private String status;
    private String kelamin;
    private int umur;
    private String department;

    public Pegawai() {
    }

    public Pegawai(String nip, String nama, double gaji, String alamat, String posisi, String pendidikan, String status, String kelamin, int umur, String department) {
        this.nip = nip;
        this.nama = nama;
        this.gaji = gaji;
        this.alamat = alamat;
        this.posisi = posisi;
        this.pendidikan = pendidikan;
        this.status = status;
        this.kelamin = kelamin;
        this.umur = umur;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Pegawai{" +
                "nip='" + nip + '\'' +
                ", nama='" + nama + '\'' +
                ", gaji=" + gaji +
                ", alamat='" + alamat + '\'' +
                ", posisi='" + posisi + '\'' +
                ", pendidikan='" + pendidikan + '\'' +
                ", status='" + status + '\'' +
                ", kelamin='" + kelamin + '\'' +
                ", umur=" + umur +
                ", department='" + department + '\'' +
                '}';
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
