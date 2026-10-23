package com.tambalbanservice.tambalbanservicesihombing;

public class LayananTambalBan extends Transaksi {
    private String jenisLayanan;      // 1. Tambal Ban, 2. Ganti Ban, 3. Ganti Oli
    private String kategoriKendaraan; // "Mobil" atau "Motor"
    private double tarifDasar;
    private int jumlah;               // Jumlah unit/pcs

    public LayananTambalBan(String kodeTransaksi, String namaPelanggan, String tanggal, String jenisLayanan, String kategoriKendaraan, double tarifDasar, int jumlah) {
        super(kodeTransaksi, namaPelanggan, tanggal);
        this.jenisLayanan = jenisLayanan;
        this.kategoriKendaraan = kategoriKendaraan;
        this.tarifDasar = tarifDasar;
        this.jumlah = jumlah;
    }

    public String getJenisLayanan() {
        return jenisLayanan;
    }

    public void setJenisLayanan(String jenisLayanan) {
        this.jenisLayanan = jenisLayanan;
    }

    public String getKategoriKendaraan() {
        return kategoriKendaraan;
    }

    public void setKategoriKendaraan(String kategoriKendaraan) {
        this.kategoriKendaraan = kategoriKendaraan;
    }

    public double getTarifDasar() {
        return tarifDasar;
    }

    public void setTarifDasar(double tarifDasar) {
        this.tarifDasar = tarifDasar;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    // Logika penyesuaian harga otomatis berdasarkan kategori kendaraan (Mobil lebih mahal dari Motor)
    public double hitungTotalBiaya() {
        double penyesuaian = kategoriKendaraan.equalsIgnoreCase("Mobil") ? 25000 : 10000;
        return (tarifDasar + penyesuaian) * jumlah;
    }

    // OVERRIDING: Mengubah perilaku hitungBiaya dengan menyertakan potongan diskon
    @Override
    public double hitungBiaya(double hargaDasar, double diskon) {
        double penyesuaian = kategoriKendaraan.equalsIgnoreCase("Mobil") ? 25000 : 10000;
        return ((hargaDasar + penyesuaian) * jumlah) - diskon;
    }

    // OVERRIDING: Menampilkan format resi seperti gaya struk/laporan kasir
    @Override
    public void tampilkanInfo() {
        System.out.println("=== RESI TAMBAL BAN SERVICE SIHOMBING ===");
        System.out.println("Kode Transaksi    : " + kodeTransaksi);
        System.out.println("Pelanggan         : " + namaPelanggan);
        System.out.println("Layanan Service   : " + jenisLayanan + " (" + kategoriKendaraan + ")");
        System.out.println("Jumlah Unit       : " + jumlah);
        System.out.println("Tarif Dasar       : " + formatRupiah(tarifDasar) + " /unit");
        System.out.println("Total Biaya       : " + formatRupiah(hitungTotalBiaya()));
        System.out.println("Tanggal Masuk     : " + tanggal);
        System.out.println("Status Pembayaran : LUNAS");
    }
}