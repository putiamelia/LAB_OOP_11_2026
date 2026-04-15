public class DompetDigital {

    // PRIVATE = data rahasia
    private String pin;
    private double saldo;

    // PROTECTED = identitas 
    protected String nama;

    // DEFAULT = data internal package
    String idAkun;

    // Constructor
    public DompetDigital(String nama, String idAkun, String pin) {
        this.nama = nama;
        this.idAkun = idAkun;
        this.pin = pin;
        this.saldo = 0;
    }

    // Getter 
    public String getNama() {
        return nama;
    }

    public String getIdAkun() {
        return idAkun;
    }

    public double getSaldo() {
        return saldo;
    }

    // Ubah PIN
    public boolean ubahPin(String pinLama, String pinBaru) {
        if (pin.equals(pinLama)) {
            System.out.println("PIN lama salah!");
            return false;
        }

        if (pinBaru.length() != 6) {
            System.out.println("PIN baru harus 6 digit!");
            return false;
        }

        pin = pinBaru;
        System.out.println("PIN berhasil diubah!");
        logTransaksi("PIN diubah");
        return true;
    }

    // Setor
    public boolean setor(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Nominal tidak valid!");
            logTransaksi("Setor gagal");
            return false;
        }

        saldo += jumlah;
        System.out.println("Setor berhasil!");
        logTransaksi("Setor +" + jumlah);
        return true;
    }

    // Tarik
    public boolean tarik(double jumlah, String inputPin) {
        if (!pin.equals(inputPin)) {
            System.out.println("PIN salah!");
            logTransaksi("Tarik gagal - PIN salah");
            return false;
        }

        if (jumlah <= 0) {
            System.out.println("Nominal tidak valid!");
            return false;
        }

        if (jumlah > saldo) {
            System.out.println("Saldo tidak cukup!");
            logTransaksi("Tarik gagal - saldo kurang");
            return false;
        }

        saldo -= jumlah;
        System.out.println("Tarik berhasil!");
        logTransaksi("Tarik -" + jumlah);
        return true;
    }

    // Info akun
    private void tampilkanInfo() {
        System.out.println("\n===== DATA AKUN =====");
        System.out.println("Nama   : " + nama);
        System.out.println("ID     : " + idAkun);
        System.out.println("Saldo  : Rp " + saldo);
    }

    // Internal method
    private void logTransaksi(String pesan) {
        System.out.println("LOG: " + pesan);
    }

    public void getTampilkanInfo() {
         tampilkanInfo();
    }
}