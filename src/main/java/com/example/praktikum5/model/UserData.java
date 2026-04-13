package com.example.praktikum5.model;

/**
 * Model untuk menampung data mahasiswa sesuai ketentuan tugas.
 * Menambahkan atribut jenisKelamin agar sesuai dengan form input.
 */
public class UserData {
    private String nama;
    private String nim;
    private String jenisKelamin; // Tambahan untuk memenuhi syarat tugas [cite: 89]

    // Constructor Kosong
    public UserData() {}

    // Constructor dengan Parameter
    public UserData(String nama, String nim, String jenisKelamin) {
        this.nama = nama;
        this.nim = nim;
        this.jenisKelamin = jenisKelamin;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}