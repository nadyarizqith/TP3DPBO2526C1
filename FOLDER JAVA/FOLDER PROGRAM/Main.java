/*
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
*/

public class Main {
    static String status(boolean ok, String gagal) { return ok ? "berhasil" : gagal; }

    public static void main(String[] args) {
        RentalKendaraan rental = new RentalKendaraan("Rental Nusantara");
        final int HARI = 3;

        // Data awal (hardcode)
        rental.tambahKendaraan(new Mobil("MB001", "Toyota Avanza", 350000, "Inline-4", 1500, "Bensin", 5, 7));
        rental.tambahKendaraan(new Motor("MT001", "Honda Vario", 80000, "Single", 125, "Bensin", "Matic", 2));
        rental.tambahKendaraan(new Mobil("MB002", "Honda Brio", 280000, "Inline-3", 1200, "Bensin", 5, 5));

        System.out.println(">>> DATA SEBELUM DITAMBAHKAN");
        rental.tampilkanSemua(HARI);

        // Penambahan data (statis)
        System.out.println(">>> MENAMBAHKAN DATA BARU...");
        boolean ok1 = rental.tambahKendaraan(new Mobil("MB003", "Toyota Innova Zenix", 600000, "Inline-4 Hybrid", 1987, "Hybrid", 5, 7));
        boolean ok2 = rental.tambahKendaraan(new Motor("MT002", "Kawasaki Ninja", 150000, "Parallel-Twin", 250, "Bensin", "Sport", 1));
        boolean ok3 = rental.tambahKendaraan(new Motor("MT003", "Yamaha NMAX", 100000, "Single", 155, "Bensin", "Matic", 2));
        boolean ok4 = rental.tambahKendaraan(new Mobil("MB001", "Duplikat Test", 100000, "X", 1000, "Bensin", 4, 4)); // kode duplikat
        System.out.println("Tambah MB003 : " + status(ok1, "gagal"));
        System.out.println("Tambah MT002 : " + status(ok2, "gagal"));
        System.out.println("Tambah MT003 : " + status(ok3, "gagal"));
        System.out.println("Tambah MB001 : " + status(ok4, "gagal (kode sudah dipakai)"));
        System.out.println();

        System.out.println(">>> DATA SESUDAH DITAMBAHKAN");
        rental.tampilkanSemua(HARI);
    }
}
