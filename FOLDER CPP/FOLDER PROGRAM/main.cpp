/*
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
*/

#include <iostream>
#include "Mobil.h"
#include "Motor.h"
#include "RentalKendaraan.h"
using namespace std;

int main() {
    RentalKendaraan rental("Rental Nusantara");
    const int HARI = 3;

    // Data awal (hardcode)
    rental.tambahKendaraan(make_unique<Mobil>("MB001", "Toyota Avanza", 350000, "Inline-4", 1500, "Bensin", 5, 7));
    rental.tambahKendaraan(make_unique<Motor>("MT001", "Honda Vario", 80000, "Single", 125, "Bensin", "Matic", 2));
    rental.tambahKendaraan(make_unique<Mobil>("MB002", "Honda Brio", 280000, "Inline-3", 1200, "Bensin", 5, 5));

    cout << ">>> DATA SEBELUM DITAMBAHKAN" << endl;
    rental.tampilkanSemua(HARI);

    // Penambahan data (statis)
    cout << ">>> MENAMBAHKAN DATA BARU..." << endl;
    bool ok1 = rental.tambahKendaraan(make_unique<Mobil>("MB003", "Toyota Innova Zenix", 600000, "Inline-4 Hybrid", 1987, "Hybrid", 5, 7));
    bool ok2 = rental.tambahKendaraan(make_unique<Motor>("MT002", "Kawasaki Ninja", 150000, "Parallel-Twin", 250, "Bensin", "Sport", 1));
    bool ok3 = rental.tambahKendaraan(make_unique<Motor>("MT003", "Yamaha NMAX", 100000, "Single", 155, "Bensin", "Matic", 2));
    bool ok4 = rental.tambahKendaraan(make_unique<Mobil>("MB001", "Duplikat Test", 100000, "X", 1000, "Bensin", 4, 4)); // kode duplikat
    cout << "Tambah MB003 : " << (ok1 ? "berhasil" : "gagal") << endl;
    cout << "Tambah MT002 : " << (ok2 ? "berhasil" : "gagal") << endl;
    cout << "Tambah MT003 : " << (ok3 ? "berhasil" : "gagal") << endl;
    cout << "Tambah MB001 : " << (ok4 ? "berhasil" : "gagal (kode sudah dipakai)") << endl << endl;

    cout << ">>> DATA SESUDAH DITAMBAHKAN" << endl;
    rental.tampilkanSemua(HARI);
    return 0;
}
