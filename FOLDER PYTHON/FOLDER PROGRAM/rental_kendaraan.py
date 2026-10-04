'''
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
'''

from kendaraan import format_rupiah


class RentalKendaraan:
    def __init__(self, nama_rental):
        self.__nama_rental = nama_rental
        self.__daftar = []  # ARRAY OF OBJECT + COMPOSITION (rental memiliki kendaraan)

    # Getter & Setter
    def get_nama_rental(self):
        return self.__nama_rental

    def set_nama_rental(self, nama_rental):
        self.__nama_rental = nama_rental

    def tambah_kendaraan(self, k):
        for item in self.__daftar:
            if item.get_kode() == k.get_kode():
                return False  # kode harus unik
        self.__daftar.append(k)
        return True

    # Mencari kendaraan berdasarkan kode (None jika tidak ada)
    def cari_kendaraan(self, kode):
        for item in self.__daftar:
            if item.get_kode() == kode:
                return item
        return None

    def jumlah(self):
        return len(self.__daftar)

    def tampilkan_semua(self, hari):
        garis = "=" * 136
        print(garis)
        print(f"DAFTAR KENDARAAN - {self.__nama_rental} (simulasi sewa {hari} hari)")
        print(garis)
        print("No".ljust(4) + "Kode".ljust(8) + "Jenis".ljust(8) + "Merek".ljust(22)
              + "Mesin".ljust(34) + "Harga/Hari".ljust(14) + "Detail".ljust(24)
              + f"Biaya {hari} Hari")
        print("-" * 136)
        total = 0
        for no, k in enumerate(self.__daftar, start=1):
            biaya = k.hitung_biaya(hari)
            total += biaya
            print(str(no).ljust(4) + k.get_kode().ljust(8) + k.get_jenis().ljust(8)
                  + k.get_merek().ljust(22) + k.get_mesin().info().ljust(34)
                  + format_rupiah(k.get_harga_per_hari()).ljust(14)
                  + k.get_detail().ljust(24) + format_rupiah(biaya))
        print("-" * 136)
        print(f"Total kendaraan: {len(self.__daftar)} | Total potensi pendapatan: {format_rupiah(total)}")
        print(garis + "\n")
