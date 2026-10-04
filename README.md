JANJI:
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

#DESAIN DIAGRAM PROGRAM:
![alt text](<tp3 dpbo DRAWIO FINALL.png>)


                 RentalKendaraan
                       ◆  (composition, 0..*)
                       │
                  Kendaraan  (abstract)  ◆────── Mesin   (composition)
                  /       \
              Mobil       Motor           (hierarchical inheritance)

HUbungan antar relasi:

Kendaraan <|-- Mobil : extends inheritance
Kendaraan <|-- Motor : extends inheritance
Kendaraan *-- Mesin : composition
RentalKendaraan *--  Kendaraan : composition (array of object)


classDiagram
    class Mesin {
        -String tipe
        -int cc
        -String bahanBakar
        +getTipe() String
        +getCC() int
        +getBahanBakar() String
        +info() String
    }
    class Kendaraan {
        <<abstract>>
        #String kode
        #String merek
        #long hargaPerHari
        #Mesin mesin
        +getKode() String
        +getMerek() String
        +getHargaPerHari() long
        +getMesin() Mesin
        +getJenis()* String
        +getDetail()* String
        +hitungBiaya(hari) long
    }
    class Mobil {
        -int jumlahPintu
        -int kapasitas
        +getJenis() String
        +getDetail() String
        +hitungBiaya(hari) long
    }
    class Motor {
        -String jenisMotor
        -int jumlahHelm
        +getJenis() String
        +getDetail() String
        +hitungBiaya(hari) long
    }
    class RentalKendaraan {
        -String namaRental
        -List~Kendaraan~ daftar
        +tambahKendaraan(k) bool
        +jumlah() int
        +tampilkanSemua(hari) void
    }
    
##PENJELASAN ATRIBUT DAN METHODS SETIAP KELAS:

1. Mesin (class PART pada composition)

Atribut (private):
- tipe       : tipe mesin (contoh: Inline-4, Single)
- cc         : kapasitas mesin (cc)
- bahanBakar : jenis bahan bakar (Bensin / Hybrid)

Method (public):
- getTipe(), getCC(), getBahanBakar()    : getter masing-masing atribut
- setTipe(), setCC(), setBahanBakar()    : setter masing-masing atribut
- info()                                 : mengembalikan string ringkas, contoh "Inline-4 1500cc (Bensin)"

2. Kendaraan (Parent Class, abstract)

Atribut (private):
- kode         : ID unik kendaraan
- merek        : nama / merek kendaraan
- hargaPerHari : harga sewa dasar per hari
- mesin        : objek Mesin milik kendaraan (composition)

Method (public):
- getKode(), getMerek(), getHargaPerHari(), getMesin() : getter
- setKode(), setMerek(), setHargaPerHari()             : setter
- setMesin(tipe, cc, bahanBakar)                       : mengganti mesin; objek Mesin dibuat ulang
                                                         di dalam Kendaraan (bukan dikirim dari luar)
                                                         agar tetap composition
- getJenis()                                           : abstract, jenis kendaraan ("Mobil"/"Motor")
- getDetail()                                          : abstract, detail khusus tiap anak class
- hitungBiaya(hari)                                    : biaya dasar = hargaPerHari x hari
                                                         (di-override oleh anak class)

3. Mobil (Child dari Kendaraan)

Atribut (private):
- jumlahPintu : jumlah pintu mobil
- kapasitas   : kapasitas penumpang

Method (public):
- getJumlahPintu(), getKapasitas()   : getter
- setJumlahPintu(), setKapasitas()   : setter
- getJenis()                         : mengembalikan "Mobil"
- getDetail()                        : contoh "5 pintu, 7 penumpang"
- hitungBiaya(hari)                  : override, biaya dasar + asuransi 10%

4. Motor (Child dari Kendaraan)

Atribut (private):
- jenisMotor : Matic / Sport
- jumlahHelm : jumlah helm yang disewakan

Method (public):
- getJenisMotor(), getJumlahHelm()   : getter
- setJenisMotor(), setJumlahHelm()   : setter
- getJenis()                         : mengembalikan "Motor"
- getDetail()                        : contoh "Matic, 2 helm"
- hitungBiaya(hari)                  : override, biaya dasar + sewa helm Rp5.000 x jumlahHelm x hari

5. RentalKendaraan (class pengelola)

Atribut (private):
- namaRental : nama usaha rental
- daftar     : array/list/vector berisi objek Kendaraan (array of object)

Method (public):
- getNamaRental(), setNamaRental()  : getter dan setter nama rental
- tambahKendaraan(k)                : menambah kendaraan ke daftar; return false jika kode sudah dipakai
- cariKendaraan(kode)               : mencari kendaraan berdasarkan kode (null/None/nullptr jika tidak ada)
- jumlah()                          : jumlah kendaraan saat ini
- tampilkanSemua(hari)              : mencetak tabel lengkap semua kendaraan + biaya sewa + total pendapatan

#STRUKTUR FILE:

Main
├── FOLDER CPP
│   ├── CPP
│   │   ├── Mesin.h
│   │   ├── Mobil.h
│   │   ├── Motor.h
│   │   ├── main.cpp
│   │   ├── RentalKendaraan.h
│   │   └── Kendaraan.h
│   └── DOKUMENTASI
│     
├── FOLDER PYTHON
│   ├── PYTHON
│   │   ├── mesin.py
│   │   ├── mobil.py
│   │   ├── motor.py
│   │   ├── main.py
│   │   ├── rental_kendaraan.py
│   │   └── kendaraan.py
│   └── DOKUMENTASI
│ 
├── FOLDER JAVA
│   ├── JAVA
│   │   ├── Mesin.java
│   │   ├── Mobil.java
│   │   ├── Motor.java
│   │   ├── Main.java
│   │   ├── RentalKendaraan.java
│   │   └── Kendaraan.java
│   └── DOKUMENTASI
│ 
└── README.md


##PENJELASAN DESAIN PROGRAM

Program ini adalah simulasi Rental Kendaraan yang mengelola data Mobil dan Motor.

1. Hierarchical Inheritance
Satu parent (Kendaraan) diturunkan ke dua child yang sejajar, yaitu Mobil dan Motor. Keduanya mewarisi atribut umum (kode, merek, hargaPerHari, mesin) lalu menambah atribut khusus masing-masing. Keduanya tidak saling mewarisi satu sama lain, sehingga ini murni hierarchical.
- Mobil is-a Kendaraan, Motor is-a Kendaraan.
- Kendaraan` dibuat abstract (tidak bisa dibuat objeknya langsung) karena "kendaraan" itu terlalu umum, yang nyata adalah mobil atau motor.
- Polimorfisme: hitungBiaya(), getJenis(), dan getDetail() di-override. Saat RentalKendaraan memanggil k.hitungBiaya(hari) pada elemen list bertipe Kendaraan, perhitungan otomatis menyesuaikan jenis aslinya (mobil: + asuransi 10%, motor: + sewa helm).

2. Composition
Ada dua relasi composition (hubungan "has-a" yang kuat, part tidak hidup tanpa whole):
- Kendaraan ->  Mesin: objek Mesin dibuat di dalam constructor Kendaraan, bukan dikirim dari luar. Jika kendaraan dihapus, mesinnya ikut hilang.
- RentalKendaraan -> Kendaraan: rental memiliki kumpulan kendaraan. Di C++ memakai vector<unique_ptr<Kendaraan>> (rental yang memiliki/menghapus objeknya), di Java ArrayList<Kendaraan>, di Python list.

3. Array of Object
RentalKendaraan menyimpan banyak kendaraan dalam satu koleksi (vector / ArrayList / list) yang bisa berisi campuran objek Mobil dan Motor sekaligus karena keduanya bertipe Kendaraan.

4. Penambahan data
Data awal berjumlah 3 (hardcode di main), lalu ditambah 3 data baru secara statis lewat tambahKendaraan(). Ada juga 1 percobaan menambah kode duplikat (MB001) untuk membuktikan validasi kode unik bekerja (hasilnya gagal).

5. Alasan desain rasional
Mobil dan motor memang punya sifat sama (kode, merek, harga, mesin) tetapi aturan biaya dan atribut khusus berbeda, sehingga cocok memakai inheritance + polimorfisme. Mesin adalah bagian yang tidak berdiri sendiri pada kendaraan, sehingga cocok memakai composition.


##PENJELASAN ALUR (C++, Python, dan Java)

Program dijalankan lewat CMD/Terminal dan tidak memerlukan input (penambahan data bersifat statis).

1. Jalankan program
   - Python : python main.py
   - Java   : javac *.java lalu java Main
   - C++    : g++ main.cpp -o main lalu ./main
2. Program membuat objek RentalKendaraan dan mengisi 3 data awal (2 Mobil + 1 Motor).
3. Program mencetak ">>> DATA SEBELUM DITAMBAHKAN": tabel berisi No, Kode, Jenis, Merek, Mesin, Harga/Hari, Detail, Biaya sewa 3 hari, serta total kendaraan dan total potensi pendapatan.
4. Program menambahkan 3 data baru (1 Mobil + 2 Motor) dan 1 percobaan kode duplikat. Status berhasil/gagal dicetak per data.
5. Program mencetak ">>> DATA SESUDAH DITAMBAHKAN": tabel lengkap berisi 6 data.
6. Program selesai.

Output:
>>> DATA SEBELUM DITAMBAHKAN
========================================================================================================================================
DAFTAR KENDARAAN - Rental Nusantara (simulasi sewa 3 hari)
========================================================================================================================================
No  Kode    Jenis   Merek                 Mesin                             Harga/Hari    Detail                  Biaya 3 Hari
----------------------------------------------------------------------------------------------------------------------------------------
1   MB001   Mobil   Toyota Avanza         Inline-4 1500cc (Bensin)          Rp350.000     5 pintu, 7 penumpang    Rp1.155.000
2   MT001   Motor   Honda Vario           Single 125cc (Bensin)             Rp80.000      Matic, 2 helm           Rp270.000
3   MB002   Mobil   Honda Brio            Inline-3 1200cc (Bensin)          Rp280.000     5 pintu, 5 penumpang    Rp924.000
----------------------------------------------------------------------------------------------------------------------------------------
Total kendaraan: 3 | Total potensi pendapatan: Rp2.349.000
========================================================================================================================================

>>> MENAMBAHKAN DATA BARU...
Tambah MB003 : berhasil
Tambah MT002 : berhasil
Tambah MT003 : berhasil
Tambah MB001 : gagal (kode sudah dipakai)

>>> DATA SESUDAH DITAMBAHKAN
========================================================================================================================================
DAFTAR KENDARAAN - Rental Nusantara (simulasi sewa 3 hari)
========================================================================================================================================
No  Kode    Jenis   Merek                 Mesin                             Harga/Hari    Detail                  Biaya 3 Hari
----------------------------------------------------------------------------------------------------------------------------------------
1   MB001   Mobil   Toyota Avanza         Inline-4 1500cc (Bensin)          Rp350.000     5 pintu, 7 penumpang    Rp1.155.000
2   MT001   Motor   Honda Vario           Single 125cc (Bensin)             Rp80.000      Matic, 2 helm           Rp270.000
3   MB002   Mobil   Honda Brio            Inline-3 1200cc (Bensin)          Rp280.000     5 pintu, 5 penumpang    Rp924.000
4   MB003   Mobil   Toyota Innova Zenix   Inline-4 Hybrid 1987cc (Hybrid)   Rp600.000     5 pintu, 7 penumpang    Rp1.980.000
5   MT002   Motor   Kawasaki Ninja        Parallel-Twin 250cc (Bensin)      Rp150.000     Sport, 1 helm           Rp465.000
6   MT003   Motor   Yamaha NMAX           Single 155cc (Bensin)             Rp100.000     Matic, 2 helm           Rp330.000
----------------------------------------------------------------------------------------------------------------------------------------
Total kendaraan: 6 | Total potensi pendapatan: Rp5.124.000
========================================================================================================================================

#DOKUMENTASI

#CPP
![alt text](<FOLDER CPP/FOLDER DOKUMENTASI/Screenshot 2026-10-03 184900.png>)

#JAVA
![alt text](<FOLDER JAVA/FOLDER DOKUMENTASI/Screenshot 2026-10-03 184957.png>)

#Python
![alt text](<FOLDER PYTHON/FOLDER DOKUMENTASI/Screenshot 2026-10-04 071154.png>)
