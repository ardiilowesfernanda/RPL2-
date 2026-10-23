package com.tambalbanservice.tambalbanservicesihombing;

public class TambalBanServiceSihombing {
    public static void main(String[] args) {
        System.out.println("=== SISTEM INFORMASI TAMBAL BAN SERVICE SIHOMBING ===\n");

        // Simulasi Transaksi 1: Ganti Ban untuk Mobil (Menggunakan Inheritance & Overriding)
        LayananTambalBan transaksi1 = new LayananTambalBan(
            "TRX0001", 
            "Ardi Lowes", 
            "2026-10-23", 
            "2. Ganti Ban", 
            "Mobil", 
            150000, 
            2
        );
        transaksi1.tampilkanInfo();

        System.out.println("\n--------------------------------------------------\n");

        // Uji Enkapsulasi: Mengupdate nama pelanggan menggunakan Setter & Getter
        transaksi1.setNamaPelanggan("Ardi Lowes (Member VIP)");
        System.out.println("Update Nama Pelanggan (Getter): " + transaksi1.getNamaPelanggan());

        System.out.println("\n--------------------------------------------------\n");

        // Simulasi Transaksi 2: Ganti Oli untuk Motor (Uji Overloading pada kelas Transaksi)
        Transaksi transaksiUmum = new Transaksi("TRX0002", "Ronaldo", "2026-10-23");
        System.out.println("=== PENGUJIAN OVERLOADING TRANSAKSI LAINNYA ===");
        System.out.println("Layanan           : 3. Ganti Oli (Motor)");
        System.out.println("Biaya Normal      : " + transaksiUmum.formatRupiah(transaksiUmum.hitungBiaya(50000)));
        System.out.println("Biaya + Diskon    : " + transaksiUmum.formatRupiah(transaksiUmum.hitungBiaya(50000, 5000)));
        System.out.println("Biaya Diskon+Admin: " + transaksiUmum.formatRupiah(transaksiUmum.hitungBiaya(50000, 5000, 2000)));
    }
}