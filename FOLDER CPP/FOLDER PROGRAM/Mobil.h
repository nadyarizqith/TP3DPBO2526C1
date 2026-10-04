/*
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
*/

#pragma once //agar tidak terjadi multiple inclusion
#include "Kendaraan.h"

class Mobil : public Kendaraan {
private:
    int jumlahPintu;
    int kapasitas;
public:
    Mobil(string kode, string merek, long harga, string tipeMesin, int cc, string bahanBakar, int jumlahPintu, int kapasitas)
        : Kendaraan(kode, merek, harga, tipeMesin, cc, bahanBakar),
          jumlahPintu(jumlahPintu), kapasitas(kapasitas) {}

    string getJenis() const override { 
        return "Mobil"; 
    }
    string getDetail() const override {
        return to_string(jumlahPintu) + " pintu, " + to_string(kapasitas) + " penumpang";
    }
    // Mobil: biaya sewa + asuransi 10%
    long hitungBiaya(int hari) const override {
        long dasar = Kendaraan::hitungBiaya(hari);
        return dasar + dasar / 10;
    }
};
