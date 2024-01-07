import java.sql.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Run extends Database implements Inter{
   private Connection connection;
   public ResultSet rs;
   
    public Run() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, USER, PASS);  
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addMember(Member member) throws SQLException {
        
        String query = "INSERT INTO data_pelanggan (nama, password, email, waktu_tersedia) VALUES (?, ?, ?, 0)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, member.getNama());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getEmail());
            pstmt.executeUpdate();
        }
        }
        public void updateJam(Integer waktu_tersedia, String nama) throws SQLException {
            String query = "UPDATE data_pelanggan SET waktu_tersedia = waktu_tersedia + ? WHERE nama = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, waktu_tersedia);
                pstmt.setString(2, nama);
                pstmt.executeUpdate();
            }

        }
        public void addPaket() throws SQLException {
            String query = "SELECT * FROM paketwarnet;";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                Integer id = result.getInt("id_paket");
                String nama = result.getString("nama_paket");
                String waktu = result.getString("waktu");
                Integer harga = result.getInt("harga");

        System.out.println("ID:" +  id);
        System.out.println("Nama Paket:" +  nama);
        System.out.println("Masa Berlaku:" +  waktu);
        System.out.println("Harga:" +  harga);
    }
    statement.close();
    result.close();
}


        public void deleteMember(Integer id) throws SQLException {
            String query = "DELETE FROM data_pelanggan WHERE id = ?;";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
    }
}       public void changePassword(String password, String nama) throws SQLException {
            String query = "UPDATE data_pelanggan SET password = ? WHERE nama = ?;";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, password);
                pstmt.setString(2, nama);
                pstmt.executeUpdate();
            }  
        }
        public void struk () throws SQLException{
            Scanner input = new Scanner(System.in);
            addPaket();
            System.out.println("Masukkan Id paket :");
            Integer id = input.nextInt();

            try {
                PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM paketwarnet WHERE id_paket = ?");
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();

            while (rs.next()) {
                    Integer id_paket = rs.getInt("id_paket");
                    String nama = rs.getString("nama_paket");
                    String waktu = rs.getString("waktu");
                    Integer harga = rs.getInt("harga");
                    Date hariOrder = new Date();
                    SimpleDateFormat tanggal = new SimpleDateFormat("E dd/MM/yyyy");
                    SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss zzzz");

                    System.out.println("======== Struk Pembelian ========");
                    System.out.println("---------------------------------");
                    System.out.println("Tanggal :" + tanggal.format(hariOrder));
                    System.out.println("Waktu :" + time.format(hariOrder));
                    System.out.println("+++++++++++++++++++++++++++++++++++");
                    System.out.println("ID Paket :" + id_paket);
                    System.out.println("Nama Paket :" + nama);
                    System.out.println("Masa Berlaku :" + waktu);
                    System.out.println("Harga :" + harga);
                    System.out.println("===================================");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
