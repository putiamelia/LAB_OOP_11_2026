abstract class karyawan {
    private String nama;
    private String idKaryawan;
    protected int jumlahKehadiran = 0;

    public karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
    }

    public void absen() {
        jumlahKehadiran++;
    }

    public abstract double hitungGaji();
}