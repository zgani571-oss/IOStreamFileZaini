package bagian2.bacatulis;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LatihanMandiri1 {
    public static void main(String[] args) {
        // Menulis 5 nama hari ke hari.txt
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};

        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt"))) {
            for (String h : hari) {
                penulis.println(h);
            }
            System.out.println("5 nama hari berhasil ditulis ke hari.txt");
        } catch (IOException e) {
            System.out.println("Gagal menulis: " + e.getMessage());
        }

        // Membaca kembali isi hari.txt
        System.out.println("== Isi hari.txt ==");
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