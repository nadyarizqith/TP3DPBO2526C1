/*
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
*/

#pragma once //agar tidak terjadi multiple inclusion
#include <string>
using namespace std;

// Class PART pada Composition: Mesin dimiliki oleh Kendaraan
class Mesin {
private:
    string tipe;
    int cc;
    string bahanBakar;
public:
    Mesin(string tipe, int cc, string bahanBakar)
        : tipe(tipe), cc(cc), bahanBakar(bahanBakar) {}

    string getTipe() const { 
        return tipe; 
    }
    int getCC() const { 
        return cc; 
    }
    string getBahanBakar() const { 
        return bahanBakar; 
    }

    string info() const {
        return tipe + " " + to_string(cc) + "cc (" + bahanBakar + ")";
    }
};
