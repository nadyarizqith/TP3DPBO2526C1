'''
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
'''

from kendaraan import Kendaraan


class Motor(Kendaraan):
    def __init__(self, kode, merek, harga, tipe_mesin, cc, bahan_bakar,
                 jenis_motor, jumlah_helm):
        super().__init__(kode, merek, harga, tipe_mesin, cc, bahan_bakar)
        self.__jenis_motor = jenis_motor
        self.__jumlah_helm = jumlah_helm

    # Getter
    def get_jenis_motor(self):
        return self.__jenis_motor

    def get_jumlah_helm(self):
        return self.__jumlah_helm

    # Setter
    def set_jenis_motor(self, jenis_motor):
        self.__jenis_motor = jenis_motor

    def set_jumlah_helm(self, jumlah_helm):
        self.__jumlah_helm = jumlah_helm

    def get_jenis(self):
        return "Motor"

    def get_detail(self):
        return f"{self.__jenis_motor}, {self.__jumlah_helm} helm"

    # Motor: biaya sewa + sewa helm Rp5.000/helm/hari
    def hitung_biaya(self, hari):
        return super().hitung_biaya(hari) + self.__jumlah_helm * 5000 * hari
