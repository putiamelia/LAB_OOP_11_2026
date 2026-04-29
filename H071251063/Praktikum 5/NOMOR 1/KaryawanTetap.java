class KaryawanTetap extends karyawan {
    private double gajiPokok;
    private double tunjanganMakan;

    public KaryawanTetap(String nama, String id, double gajiPokok, double tunjanganMakan) {
        super(nama, id);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    public double hitungGaji() {
        return gajiPokok + (tunjanganMakan * jumlahKehadiran);
    }

    public double hitungGaji(double bonusKinerja) {
        return hitungGaji() + bonusKinerja;
    }
}