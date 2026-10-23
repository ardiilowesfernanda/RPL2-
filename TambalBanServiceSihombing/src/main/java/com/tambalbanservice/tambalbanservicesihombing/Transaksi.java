package com.tambalbanservice.tambalbanservicesihombing;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Transaksi {
    protected String kodeTransaksi;
    protected String namaPelanggan;
    protected String tanggal;

    // Constructor
    public Transaksi(String kodeTransaksi, String namaPelanggan, String tanggal) {
        this.kodeTransaksi = kodeTransaksi;
        this.namaPelanggan = namaPelanggan;
        this.tanggal = tanggal;
    }

    // Getter dan Setter (Enkapsulasi)
    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    // Format Rupiah
    public String formatRupiah(double nominal) {
        DecimalFormat kursIndo = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols(new Locale("id", "ID"));
        formatRp.setCurrencySymbol("Rp ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndo.setDecimalFormatSymbols(formatRp);
        kursIndo.setMaximumFractionDigits(0);
        return kursIndo.format(nominal);
    }

    // OVERLOADING 1: Menghitung biaya dasar
    public double hitungBiaya(double hargaDasar) {
        return hargaDasar;
    }

    // OVERLOADING 2: Menghitung biaya dengan diskon
    public double hitungBiaya(double hargaDasar, double diskon) {
        return hargaDasar - diskon;
    }

    // OVERLOADING 3: Menghitung biaya dengan diskon dan biaya admin
    public double hitungBiaya(double hargaDasar, double diskon, double biayaAdmin) {
        return (hargaDasar - diskon) + biayaAdmin;
    }

    public void tampilkanInfo() {
        System.out.println("Kode Transaksi : " + kodeTransaksi);
        System.out.println("Pelanggan      : " + namaPelanggan);
        System.out.println("Tanggal        : " + tanggal);
    }
}