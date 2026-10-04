/*
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
*/

#pragma once //agar tidak terjadi multiple inclusion
#include "Kendaraan.h"

class Motor : public Kendaraan {
private:
    string jenisMotor;
    int jumlahHelm;
public:
    Motor(string kode, string merek, long harga, string tipeMesin, int cc, string bahanBakar, string jenisMotor, int jumlahHelm)
        : Kendaraan(kode, merek, harga, tipeMesin, cc, bahanBakar),
          jenisMotor(jenisMotor), jumlahHelm(jumlahHelm) {}

    string getJenis() const override { 
        return "Motor"; 
    }
    string getDetail() const override {
        return jenisMotor + ", " + to_string(jumlahHelm) + " helm";
    }
    // Motor: biaya sewa + sewa helm Rp5.000/helm/hari
    long hitungBiaya(int hari) const override {
        return Kendaraan::hitungBiaya(hari) + (long)jumlahHelm * 5000 * hari;
    }
};
