public class Paket {
    private Integer id_paket;
    private String nama_paket;
    private String waktu;
    private Integer harga;
    
    Paket (Integer id_paket, String nama_paket, String waktu, Integer harga ){
        this.id_paket = id_paket;
        this.nama_paket = nama_paket;
        this.waktu = waktu;
        this.harga = harga;
    }
// Getter 
    public Integer getIdPaket(){
        return id_paket;
    }
    public String getNamaPaket(){
        return nama_paket;
    }
    public String getWaktu(){
        return waktu;
    }
    public Integer getHarga(){
        return harga;
    }
}
