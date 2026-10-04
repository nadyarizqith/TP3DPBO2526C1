'''
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
'''

from abc import ABC, abstractmethod
from mesin import Mesin


def format_rupiah(n):
    return "Rp" + f"{n:,}".replace(",", ".")


class Kendaraan(ABC):
    """Base class (abstract) - Hierarchical Inheritance: Mobil & Motor."""

    def __init__(self, kode, merek, harga_per_hari, tipe_mesin, cc, bahan_bakar):
        self.__kode = kode
        self.__merek = merek
        self.__harga_per_hari = harga_per_hari
        self.__mesin = Mesin(tipe_mesin, cc, bahan_bakar)  # COMPOSITION

    # Getter
    def get_kode(self):
        return self.__kode

    def get_merek(self):
        return self.__merek

    def get_harga_per_hari(self):
        return self.__harga_per_hari

    def get_mesin(self):
        return self.__mesin

    # Setter
    def set_kode(self, kode):
        self.__kode = kode

    def set_merek(self, merek):
        self.__merek = merek

    def set_harga_per_hari(self, harga_per_hari):
        self.__harga_per_hari = harga_per_hari

    # Mesin tetap dimiliki Kendaraan (composition): dibuat ulang di dalam, bukan dari luar
    def set_mesin(self, tipe_mesin, cc, bahan_bakar):
        self.__mesin = Mesin(tipe_mesin, cc, bahan_bakar)

    @abstractmethod
    def get_jenis(self):
        pass

    @abstractmethod
    def get_detail(self):
        pass

    def hitung_biaya(self, hari):
        return self.__harga_per_hari * hari
