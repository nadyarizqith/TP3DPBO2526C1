'''
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
'''

class Mesin:
    """Class PART pada Composition: Mesin dimiliki oleh Kendaraan."""

    def __init__(self, tipe, cc, bahan_bakar):
        self.__tipe = tipe
        self.__cc = cc
        self.__bahan_bakar = bahan_bakar

     # Getter
    def get_tipe(self):
        return self.__tipe

    def get_cc(self):
        return self.__cc

    def get_bahan_bakar(self):
        return self.__bahan_bakar

    # Setter
    def set_tipe(self, tipe):
        self.__tipe = tipe

    def set_cc(self, cc):
        self.__cc = cc

    def set_bahan_bakar(self, bahan_bakar):
        self.__bahan_bakar = bahan_bakar

    def info(self):
        return f"{self.__tipe} {self.__cc}cc ({self.__bahan_bakar})"
