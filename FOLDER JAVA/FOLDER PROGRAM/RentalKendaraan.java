/*
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
*/

import java.util.ArrayList;

public class RentalKendaraan {
    private String namaRental;
    private ArrayList<Kendaraan> daftar = new ArrayList<>();  // ARRAY OF OBJECT + COMPOSITION

    public RentalKendaraan(String namaRental) {
        this.namaRental = namaRental;
    }

    // Getter & Setter
    public String getNamaRental() { return namaRental; }
    public void setNamaRental(String namaRental) { this.namaRental = namaRental; }

    public boolean tambahKendaraan(Kendaraan k) {
        for (Kendaraan item : daftar) {
            if (item.getKode().equals(k.getKode())) return false;  // kode harus unik
        }
        daftar.add(k);
        return true;
    }

    // Mencari kendaraan berdasarkan kode (null jika tidak ada)
    public Kendaraan cariKendaraan(String kode) {
        for (Kendaraan item : daftar) {
            if (item.getKode().equals(kode)) return item;
        }
        return null;
    }

    public int jumlah() { return daftar.size(); }

    public void tampilkanSemua(int hari) {
        String garis = "=".repeat(136);
        System.out.println(garis);
        System.out.println("DAFTAR KENDARAAN - " + namaRental + " (simulasi sewa " + hari + " hari)");
        System.out.println(garis);
        System.out.printf("%-4s%-8s%-8s%-22s%-34s%-14s%-24s%s%n",
                "No", "Kode", "Jenis", "Merek", "Mesin", "Harga/Hari", "Detail", "Biaya " + hari + " Hari");
        System.out.println("-".repeat(136));
        int no = 1;
        long total = 0;
        for (Kendaraan k : daftar) {
            long biaya = k.hitungBiaya(hari);
            total += biaya;
            System.out.printf("%-4d%-8s%-8s%-22s%-34s%-14s%-24s%s%n",
                    no++, k.getKode(), k.getJenis(), k.getMerek(), k.getMesin().info(),
                    Kendaraan.formatRupiah(k.getHargaPerHari()), k.getDetail(),
                    Kendaraan.formatRupiah(biaya));
        }
        System.out.println("-".repeat(136));
        System.out.println("Total kendaraan: " + daftar.size() + " | Total potensi pendapatan: "
                + Kendaraan.formatRupiah(total));
        System.out.println(garis + "\n");
    }
}
