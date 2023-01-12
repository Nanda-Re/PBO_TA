package entity;

public class entity_mobil {
    String nama_mobil, jenis;
    int harga;
    public entity_mobil (String nama_mobil, String jenis, int harga)
    {
        this.harga=harga;
        this.nama_mobil=nama_mobil;
        this.jenis=jenis;
    }

    public String getNama_mobil() {
        return nama_mobil;
    }

    public String getJenis() {
        return jenis;
    }

    public int getHarga() {
        return harga;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setNama_mobil(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

}
