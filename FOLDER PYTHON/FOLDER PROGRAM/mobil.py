'''
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
'''

from kendaraan import Kendaraan


class Mobil(Kendaraan):
    def __init__(self, kode, merek, harga, tipe_mesin, cc, bahan_bakar,
                 jumlah_pintu, kapasitas):
        super().__init__(kode, merek, harga, tipe_mesin, cc, bahan_bakar)
        self.__jumlah_pintu = jumlah_pintu
        self.__kapasitas = kapasitas

    # Getter
    def get_jumlah_pintu(self):
        return self.__jumlah_pintu

    def get_kapasitas(self):
        return self.__kapasitas

    # Setter
    def set_jumlah_pintu(self, jumlah_pintu):
        self.__jumlah_pintu = jumlah_pintu

    def set_kapasitas(self, kapasitas):
        self.__kapasitas = kapasitas

    def get_jenis(self):
        return "Mobil"

    def get_detail(self):
        return f"{self.__jumlah_pintu} pintu, {self.__kapasitas} penumpang"

    # Mobil: biaya sewa + asuransi 10%
    def hitung_biaya(self, hari):
        dasar = super().hitung_biaya(hari)
        return dasar + dasar // 10
