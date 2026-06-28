package bagian2.bacatulis;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LatihanMandiri2 {
    public static void main(String[] args) {
        // Append 2 nama hari baru
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt", true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");
            System.out.println("2 nama hari baru ditambahkan!");
        } catch (IOException e) {
            System.out.println("Gagal menambah: " + e.getMessage());
        }

        // Tampilkan seluruh isi
        System.out.println("== Seluruh isi hari.txt ==");
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
    }
}