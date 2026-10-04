
/*
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
*/

public class Mobil extends Kendaraan {
    private int jumlahPintu;
    private int kapasitas;

    public Mobil(String kode, String merek, long harga, String tipeMesin, int cc, String bahanBakar, int jumlahPintu, int kapasitas) {
        super(kode, merek, harga, tipeMesin, cc, bahanBakar);
        this.jumlahPintu = jumlahPintu;
        this.kapasitas = kapasitas;
    }

     // Getter
    public int getJumlahPintu() {
        return jumlahPintu; 
    }
    public int getKapasitas() {
        return kapasitas; 
    }

    // Setter
    public void setJumlahPintu(int jumlahPintu) { 
        this.jumlahPintu = jumlahPintu; 
    }
    public void setKapasitas(int kapasitas) { 
        this.kapasitas = kapasitas;
    }

    @Override
    public String getJenis() { 
        return "Mobil"; 
    }

    @Override
    public String getDetail() { 
        return jumlahPintu + " pintu, " + kapasitas + " penumpang"; 
    }

    // Mobil: biaya sewa + asuransi 10%
    @Override
    public long hitungBiaya(int hari) {
        long dasar = super.hitungBiaya(hari);
        return dasar + dasar / 10;
    }
}
