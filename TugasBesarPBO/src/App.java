import java.sql.SQLException;
import java.util.Scanner;

public class App  {
        static Scanner input = new Scanner(System.in);
        private static final Run dbHelper = new Run();
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("======= Login =======");
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (authService.authenticate(username, password)) {
            System.out.println("Login Berhasil --- Welcome, " + username + "!");
        } else {
            System.out.println("Login Gagal --- Password atau username salah");
        }
        showmenu();
        scanner.close();
    }
    private static void showmenu(){
        Integer option;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Buat Member");
            System.out.println("2. Tambah Jam");
            System.out.println("3. Pilih Paket");
            System.out.println("4. Hapus List Member");
            System.out.println("5. Ganti Password Member");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            option = input.nextInt();
            input.nextLine();

            switch (option){
                case 1:
                // Fungsi untuk menambahkan member baru 
                    addMember(); 
                    break;
                case 2:
                // Fungsi untuk menambahkan waktu_tersedia
                    updateJam();
                    break;
                case 3:
                    addPaket();
                    break;
                case 4:
                    deleteMember();
                    break;
                case 5:
                    changePassword();
                    break;
                case 6:
                    System.out.println("===== System Telah Berhenti =====");
                    break;
                default:
                    System.out.println("Opsi Tidak ada, Pilih 1-6");
    }
}
            while(option != 6);
    }
    private static void addMember(){
        System.out.println("Masukkan Informasi Pelanggan");
        System.out.print("Username : ");
        String nama = input.nextLine();
        System.out.print("Password : ");
        String password = input.nextLine();
        System.out.print("email : ");
        String email = input.nextLine();

        Member member = new Member(0, nama, password, email, 0);

        try {
            dbHelper.addMember(member);
            System.out.println("Member baru telah ditambahkan.");
        } 
        catch (SQLException e) {
            System.out.println("Gagal menambahkan member : " + e.getMessage());
        }
    }
    private static void updateJam(){

        System.out.print("Masukkan username pelanggan: ");
        String nama = input.nextLine();

        Integer waktu_tersedia;

        System.out.print("Masukkan jumlah waktu tambahan : ");
        if (input.hasNextInt()) {
            waktu_tersedia = input.nextInt();
        } 
        else {
            System.out.println("Input tidak valid, Masukkan angka.");
            return;
        }

        try {
            dbHelper.updateJam(waktu_tersedia, nama);
            System.out.println("Data berhasil diperbarui.");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
         }
    private static void addPaket(){
        try {
            dbHelper.struk();
        } catch (SQLException e) {
            System.out.println("Gagal menampilkan : " + e.getMessage());
        }
    }
    
    
    private static void deleteMember(){
        System.out.print("Masukkan ID member yang ingin dihapus: ");
        Integer id = input.nextInt();
        input.nextLine(); // Consume newline

        try {
            dbHelper.deleteMember(id);
            System.out.println("Member Terhapus.");
        } catch (SQLException e) {
            System.out.println("Gagal menghapus data member : " + e.getMessage());
        }
    }
    private static void changePassword(){
        System.out.print("Masukkan username pelanggan: ");

        String nama;
        String password;
        
        nama = input.nextLine();
        
        System.out.print("Masukkan password baru : ");
        if (input.hasNextLine()) {
            password = input.nextLine();
        } 
        else {
            System.out.println("Input tidak valid");
            return;
        }
        
        try {
            dbHelper.changePassword(password, nama);
            System.out.println("Data berhasil diperbarui.");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

