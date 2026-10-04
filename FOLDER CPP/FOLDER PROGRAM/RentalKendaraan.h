/*
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
*/

#pragma once //agar tidak terjadi multiple inclusion
#include <iostream>
#include <iomanip>
#include <vector>
#include <memory>
#include "Kendaraan.h"
using namespace std;

class RentalKendaraan {
private:
    string namaRental;
    vector<unique_ptr<Kendaraan>> daftar;   // ARRAY OF OBJECT + COMPOSITION (rental memiliki kendaraan)
public:
    RentalKendaraan(string namaRental) : namaRental(namaRental) {}

    bool tambahKendaraan(unique_ptr<Kendaraan> k) {
        for (auto& item : daftar) {
            if (item->getKode() == k->getKode()) return false;  // kode harus unik
        }
        daftar.push_back(move(k));
        return true;
    }

    int jumlah() const { 
        return (int)daftar.size(); 
    }

    void tampilkanSemua(int hari) const {
        const string garis(136, '=');
        cout << garis << endl;
        cout << "DAFTAR KENDARAAN - " << namaRental << " (simulasi sewa " << hari << " hari)" << endl;
        cout << garis << endl;
        cout << left << setw(4) << "No" << setw(8) << "Kode" << setw(8) << "Jenis"
             << setw(22) << "Merek" << setw(34) << "Mesin" << setw(14) << "Harga/Hari"
             << setw(24) << "Detail" << "Biaya " << hari << " Hari" << endl;
        cout << string(136, '-') << endl;
        int no = 1;
        long total = 0;
        for (auto& k : daftar) {
            cout << left << setw(4) << no++ << setw(8) << k->getKode() << setw(8) << k->getJenis()
                 << setw(22) << k->getMerek() << setw(34) << k->getMesin().info()
                 << setw(14) << formatRupiah(k->getHargaPerHari())
                 << setw(24) << k->getDetail() << formatRupiah(k->hitungBiaya(hari)) << endl;
            total += k->hitungBiaya(hari);
        }
        cout << string(136, '-') << endl;
        cout << "Total kendaraan: " << daftar.size() << " | Total potensi pendapatan: "
             << formatRupiah(total) << endl;
        cout << garis << endl << endl;
    }
};
