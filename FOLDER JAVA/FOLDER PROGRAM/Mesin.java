/*
Saya Nadya Rizqitha Salsabila dengan NIM 2500991 mengerjakan soal TP 3
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.
*/

// Class PART pada Composition: Mesin dimiliki oleh Kendaraan
public class Mesin {
    private String tipe;
    private int cc;
    private String bahanBakar;

    public Mesin(String tipe, int cc, String bahanBakar) {
        this.tipe = tipe;
        this.cc = cc;
        this.bahanBakar = bahanBakar;
    }

    // Getter
    public String getTipe() { 
        return tipe; 
    }
    public int getCC() { return cc; }
    public String getBahanBakar() { 
        return bahanBakar; 
    }

    // Setter
    public void setTipe(String tipe) { 
        this.tipe = tipe; 

    }
    public void setCC(int cc) { 
        this.cc = cc; 
    }
    public void setBahanBakar(String bahanBakar) { 
        this.bahanBakar = bahanBakar; 
    }

    public String info() {
        return tipe + " " + cc + "cc (" + bahanBakar + ")";
    }
}
