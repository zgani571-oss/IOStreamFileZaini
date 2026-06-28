// Nama: M. Zaini Gani
// NPM : 2410010013

package tugas;

public class MainTugas {
    public static void main(String[] args) {
        // Array nama kategori (ukuran tetap)
        String[] kategori = {"Elektronik", "Makanan", "Minuman"};

        System.out.println("== Daftar Kategori ==");
        for (String k : kategori) {
            System.out.println("- " + k);
        }
        System.out.println();

        // Membuat objek gudang
        Gudang gudang = new Gudang("barang.txt");

        // Menambah minimal 5 barang
        gudang.tambahBarang(new Barang("Laptop", 8500000.0, 10));
        gudang.tambahBarang(new Barang("Mouse", 150000.0, 50));
        gudang.tambahBarang(new Barang("Keyboard", 250000.0, 30));
        gudang.tambahBarang(new Barang("Monitor", 2500000.0, 15));
        gudang.tambahBarang(new Barang("Headset", 350000.0, 25));

        // Tampilkan semua barang
        gudang.tampilkanSemua();
        System.out.println();

        // Simpan ke berkas
        gudang.simpanKeBerkas();
        System.out.println();

        // Buat objek gudang baru lalu muat dari berkas
        System.out.println("== Memuat data dari berkas ==");
        Gudang gudangBaru = new Gudang("barang.txt");
        gudangBaru.muatDariBerkas();
        gudangBaru.tampilkanSemua();
        System.out.println();

        // Tampilkan total nilai persediaan
        System.out.println("Total nilai persediaan: Rp" + gudangBaru.totalNilai());
    }
}