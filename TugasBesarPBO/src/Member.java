public class Member {
    private Integer id;
    private String nama;
    private String password;
    private String email; // Stok baru ditambahkan
    private Integer waktu_tersedia;

    public Member(Integer id, String nama, String password, String email, Integer waktu_tersedia) {
        this.id = id;
        this.nama = nama;
        this.password = password;
        this.email = email;
        this.waktu_tersedia = waktu_tersedia;
    }

    // Getters
    public Integer getId() { 
        return id; 
    }
    public String getNama() { 
        return nama; 
    }
    public String getPassword() { 
        return password; 
    }
    public String getEmail() { 
        return email; 
    }
    public Integer getWaktu_tersedia(){
        return waktu_tersedia;
    }
}
