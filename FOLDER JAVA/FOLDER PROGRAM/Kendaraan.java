/*
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
*/

import java.util.Locale;

// Base class (abstract) - Hierarchical Inheritance: Mobil & Motor
public abstract class Kendaraan {
    private String kode;
    private String merek;
    private long hargaPerHari;
    private Mesin mesin;   // COMPOSITION: Mesin dibuat & dimiliki Kendaraan

    public Kendaraan(String kode, String merek, long hargaPerHari,
                     String tipeMesin, int cc, String bahanBakar) {
        this.kode = kode;
        this.merek = merek;
        this.hargaPerHari = hargaPerHari;
        this.mesin = new Mesin(tipeMesin, cc, bahanBakar);
    }

    public static String formatRupiah(long n) {
        return "Rp" + String.format(Locale.US, "%,d", n).replace(',', '.');
    }

    // Getter
    public String getKode() { return kode; }
    public String getMerek() { return merek; }
    public long getHargaPerHari() { return hargaPerHari; }
    public Mesin getMesin() { return mesin; }

    // Setter
    public void setKode(String kode) { this.kode = kode; }
    public void setMerek(String merek) { this.merek = merek; }
    public void setHargaPerHari(long hargaPerHari) { this.hargaPerHari = hargaPerHari; }
    // Mesin tetap dimiliki Kendaraan (composition): dibuat ulang di dalam, bukan dari luar
    public void setMesin(String tipeMesin, int cc, String bahanBakar) {
        this.mesin = new Mesin(tipeMesin, cc, bahanBakar);
    }

    public abstract String getJenis();
    public abstract String getDetail();

    public long hitungBiaya(int hari) {
        return hargaPerHari * hari;
    }
}
