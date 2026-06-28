package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gudang {
    // ArrayList yang menampung objek bertipe Barang
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private String namaBerkas;

    // Constructor
    public Gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambah barang ke daftar
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    // Menampilkan semua barang
    public void tampilkanSemua() {
        System.out.println("== Daftar Barang ==");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang b = daftarBarang.get(i);
            System.out.println((i + 1) + ". " + b.info());
        }
        System.out.println("Total barang: " + daftarBarang.size());
    }

    // Menyimpan seluruh barang ke berkas
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                penulis.println(b.keBaris());
            }
            System.out.println("Data barang disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    // Memuat kembali barang dari berkas
    public void muatDariBerkas() {
        daftarBarang.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]);
                    int stok = Integer.parseInt(bagian[2]);
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("Data barang dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    // Menghitung total nilai persediaan (harga x stok)
    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok();
        }
        return total;
    }
}