import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     SISTEM DOMPET DIGITAL");
        System.out.println("=================================");

        // Buat akun
        System.out.print("Masukkan Nama     : ");
        String nama = input.nextLine();

        System.out.print("Masukkan ID Akun  : ");
        String id = input.nextLine();

        System.out.print("Buat PIN (6 digit): ");
        String pin = input.nextLine();

        DompetDigital dompet = new DompetDigital(nama, id, pin);

        int pilih;

        do {
            System.out.println("\n=========== MENU ===========");
            System.out.println("1. Lihat Data Akun");
            System.out.println("2. Setor Uang");
            System.out.println("3. Tarik Uang");
            System.out.println("4. Ubah PIN");
            System.out.println("5. Lihat Saldo");
            System.out.println("0. Keluar");
            System.out.println("============================");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:
                    dompet.getTampilkanInfo();
                    break;

                case 2:
                    System.out.print("Masukkan jumlah setor: Rp ");
                    double setor = input.nextDouble();
                    input.nextLine();
                    dompet.setor(setor);
                    break;

                case 3:
                    System.out.print("Masukkan jumlah tarik: Rp ");
                    double tarik = input.nextDouble();
                    input.nextLine();

                    System.out.print("Masukkan PIN: ");
                    String pinTarik = input.nextLine();

                    dompet.tarik(tarik, pinTarik);
                    break;

                case 4:
                    System.out.print("Masukkan PIN lama : ");
                    String lama = input.nextLine();

                    System.out.print("Masukkan PIN baru : ");
                    String baru = input.nextLine();

                    dompet.ubahPin(lama, baru);
                    break;

                case 5:
                    System.out.println("Saldo Anda: Rp " + dompet.getSaldo());
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia!");
            }

        } while (pilih != 0);

        input.close();
    }
}