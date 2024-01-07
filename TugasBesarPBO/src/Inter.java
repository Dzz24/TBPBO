import java.sql.SQLException;

public interface Inter {
    void addMember (Member member) throws SQLException;
    void updateJam (Integer waktu_tersedia, String nama) throws SQLException;
    void deleteMember (Integer id) throws SQLException;
    void changePassword (String password, String nama) throws SQLException;
}