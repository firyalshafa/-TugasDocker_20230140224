package com.example.praktikum5.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mahasiswa")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    private String nim;
    private String jenisKelamin;
    private String foto; // Menyimpan nama file foto


    public UserData() {}

    public UserData(String nama, String nim, String jenisKelamin, String foto) {
        this.nama = nama;
        this.nim = nim;
        this.jenisKelamin = jenisKelamin;
        this.foto = foto;
    }

    // Getter dan Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }
    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }
    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }
}