'''
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
'''

from mobil import Mobil
from motor import Motor
from rental_kendaraan import RentalKendaraan


def status(ok, gagal="gagal"):
    return "berhasil" if ok else gagal


rental = RentalKendaraan("Rental Nusantara")
HARI = 3

# Data awal (hardcode)
rental.tambah_kendaraan(Mobil("MB001", "Toyota Avanza", 350000, "Inline-4", 1500, "Bensin", 5, 7))
rental.tambah_kendaraan(Motor("MT001", "Honda Vario", 80000, "Single", 125, "Bensin", "Matic", 2))
rental.tambah_kendaraan(Mobil("MB002", "Honda Brio", 280000, "Inline-3", 1200, "Bensin", 5, 5))

print(">>> DATA SEBELUM DITAMBAHKAN")
rental.tampilkan_semua(HARI)

# Penambahan data (statis)
print(">>> MENAMBAHKAN DATA BARU...")
ok1 = rental.tambah_kendaraan(Mobil("MB003", "Toyota Innova Zenix", 600000, "Inline-4 Hybrid", 1987, "Hybrid", 5, 7))
ok2 = rental.tambah_kendaraan(Motor("MT002", "Kawasaki Ninja", 150000, "Parallel-Twin", 250, "Bensin", "Sport", 1))
ok3 = rental.tambah_kendaraan(Motor("MT003", "Yamaha NMAX", 100000, "Single", 155, "Bensin", "Matic", 2))
ok4 = rental.tambah_kendaraan(Mobil("MB001", "Duplikat Test", 100000, "X", 1000, "Bensin", 4, 4))  # kode duplikat
print("Tambah MB003 :", status(ok1))
print("Tambah MT002 :", status(ok2))
print("Tambah MT003 :", status(ok3))
print("Tambah MB001 :", status(ok4, "gagal (kode sudah dipakai)"))
print()

print(">>> DATA SESUDAH DITAMBAHKAN")
rental.tampilkan_semua(HARI)
