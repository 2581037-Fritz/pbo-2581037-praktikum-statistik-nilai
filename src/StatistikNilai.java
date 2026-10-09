import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatistikNilai {
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        int input;

        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            input = inputScanner.nextInt();

            if (input == SELESAI) {
                break;
            }

            if (input < 0 || input > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue;
            }

            daftar.add(input);
        } while (true);

        System.out.println();

        if (daftar.isEmpty()) {
            System.out.println("Tidak ada data nilai yang dimasukkan.");
            return;
        }

        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());

        int total = 0;
        for (int nilai : daftar) {
            total += nilai;
        }
        double rataRata = (double) total / daftar.size();
        System.out.printf("Rata-rata       : %.2f\n", rataRata);

        /*
         * KOMENTAR PENJELASAN (Wajib):
         * Nilai awal tertinggi dan terendah diambil dari elemen pertama (index 0).
         * Alasannya agar perbandingan dimulai dari data riil yang ada di dalam list,
         * bukan dengan angka acak yang bisa menyebabkan kesalahan logika.
         */
        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);
        for (int nilai : daftar) {
            if (nilai > tertinggi) tertinggi = nilai;
            if (nilai < terendah) terendah = nilai;
        }
        System.out.println("Tertinggi       : " + tertinggi);
        System.out.println("Terendah        : " + terendah);

        // --- TAMBAHAN TAHAP 3 ---

        // Ketentuan 5: Jumlah di atas rata-rata dihitung dengan putaran kedua
        /*
         * KOMENTAR PENJELASAN (Wajib):
         * Dihitung dengan putaran kedua karena nilai rata-rata final
         * baru bisa diketahui setelah semua nilai selesai diinput pada putaran pertama.
         */
        int diAtasRata2 = 0;
        for (int nilai : daftar) {
            if (nilai > rataRata) {
                diAtasRata2++;
            }
        }
        System.out.println("Di atas rata2   : " + diAtasRata2 + " orang");

        // Ketentuan 6: Distribusi grade disimpan di array int[]
        int[] jumlahGrade = new int[5]; // Index: 0=A, 1=B, 2=C, 3=D, 4=E
        for (int nilai : daftar) {
            if (nilai >= 90) jumlahGrade[0]++;
            else if (nilai >= 80) jumlahGrade[1]++;
            else if (nilai >= 70) jumlahGrade[2]++;
            else if (nilai >= 60) jumlahGrade[3]++;
            else jumlahGrade[4]++;
        }

        System.out.print("Distribusi      : ");
        char[] namaGrade = {'A', 'B', 'C', 'D', 'E'};
        // Dicetak dengan loop
        for (int i = 0; i < jumlahGrade.length; i++) {
            System.out.print(namaGrade[i] + "=" + jumlahGrade[i] + " ");
        }
        System.out.println();

        // Ketentuan 7: Daftar terurut dibuat dari salinan
        ArrayList<Integer> terurut = new ArrayList<>(daftar);
        Collections.sort(terurut);
        System.out.println("Terurut         : " + terurut);
        System.out.println("Urutan asli     : " + daftar);
    }
}