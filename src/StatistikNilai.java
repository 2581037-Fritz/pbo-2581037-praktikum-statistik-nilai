import java.util.ArrayList;
import java.util.Scanner;

public class StatistikNilai {
    // Ketentuan 2: Pembacaan memakai do-while dengan sentinel static final int
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        // Ketentuan 1: Nilai disimpan di ArrayList<Integer>
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        int input;

        do {
            // Nomor pada prompt diambil dari size() + 1
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            input = inputScanner.nextInt();

            if (input == SELESAI) {
                break;
            }

            // Ketentuan 3: Nilai di luar 0-100 ditolak dengan continue dan tidak di-add
            if (input < 0 || input > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue;
            }

            daftar.add(input);
        } while (true);

        System.out.println();

        // Ketentuan 8: Jaga kasus tidak ada nilai sah sama sekali
        if (daftar.isEmpty()) {
            System.out.println("Tidak ada data nilai yang dimasukkan.");
            return;
        }

        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());
    }
}