/*
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
*/

#pragma once //agar tidak terjadi multiple inclusion
#include <string>
#include "Mesin.h"
using namespace std;

//deklarasi fungsi untuk format rupiah (bisa dipanggil di mana saja)
inline string formatRupiah(long n) {
    string s = to_string(n), out;
    int c = 0;
    for (int i = (int)s.size() - 1; i >= 0; i--) {
        out.insert(out.begin(), s[i]);
        if (++c % 3 == 0 && i > 0) out.insert(out.begin(), '.');
    }
    return "Rp" + out;
}

// Base class (abstract) - Hierarchical Inheritance: Mobil & Motor
class Kendaraan {
private:
    string kode;
    string merek;
    long hargaPerHari;
    Mesin mesin;   // COMPOSITION: Mesin dibuat & dimiliki Kendaraan
public:
    Kendaraan(string kode, string merek, long hargaPerHari,
              string tipeMesin, int cc, string bahanBakar)
        : kode(kode), merek(merek), hargaPerHari(hargaPerHari), mesin(tipeMesin, cc, bahanBakar) {}
    virtual ~Kendaraan() {}

    // Getter
    string getKode() const { 
        return kode; 
    }
    string getMerek() const { 
        return merek; 
    }
    long getHargaPerHari() const { 
        return hargaPerHari; 
    }
    const Mesin& getMesin() const { 
        return mesin; 
    }

    // Setter
    void setKode(string kode) { 
        this->kode = kode; 
    }
    void setMerek(string merek) { 
        this->merek = merek; 
    }
    void setHargaPerHari(long hargaPerHari) { 
        this->hargaPerHari = hargaPerHari; 
    }
    // Mesin tetap dimiliki Kendaraan (composition): dibuat ulang di dalam, bukan dari luar
    void setMesin(string tipeMesin, int cc, string bahanBakar) {
        mesin = Mesin(tipeMesin, cc, bahanBakar);
    }

    virtual string getJenis() const = 0;                       // abstract
    virtual string getDetail() const = 0;                      // abstract
    virtual long hitungBiaya(int hari) const { 
        return hargaPerHari * hari; 
    } // bisa di-override
};
