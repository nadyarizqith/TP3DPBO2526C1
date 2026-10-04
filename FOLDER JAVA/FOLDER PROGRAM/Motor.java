/*
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
*/

public class Motor extends Kendaraan {
    private String jenisMotor;
    private int jumlahHelm;

    public Motor(String kode, String merek, long harga, String tipeMesin, int cc, String bahanBakar, String jenisMotor, int jumlahHelm) {
        super(kode, merek, harga, tipeMesin, cc, bahanBakar);
        this.jenisMotor = jenisMotor;
        this.jumlahHelm = jumlahHelm;
    }

    // Getter
    public String getJenisMotor() { 
        return jenisMotor; 
    }
    public int getJumlahHelm() { 
        return jumlahHelm; 
    }

    // Setter
    public void setJenisMotor(String jenisMotor) { 
        this.jenisMotor = jenisMotor; 
    }
    public void setJumlahHelm(int jumlahHelm) { 
        this.jumlahHelm = jumlahHelm; 
    }

    @Override
    public String getJenis() { 
        return "Motor"; 
    }

    @Override
    public String getDetail() { 
        return jenisMotor + ", " + jumlahHelm + " helm"; 
    }

    // Motor: biaya sewa + sewa helm Rp5.000/helm/hari
    @Override
    public long hitungBiaya(int hari) {
        return super.hitungBiaya(hari) + (long) jumlahHelm * 5000 * hari;
    }
}
