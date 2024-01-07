import java.util.HashMap;
import java.util.Map;

class Operator {
    private String username;
    private String password;

    public Operator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class AuthService {
    private Map<String, Operator> userDatabase;
    
    public AuthService() {
        userDatabase = new HashMap<>();
        // Tambahkan beberapa pengguna contoh
        userDatabase.put("Dzikri", new Operator("Dzikri", "240204"));
        userDatabase.put("Fakhry", new Operator("Fakhry", "242424"));
    }

    public boolean authenticate(String username, String password) {

        Operator user = userDatabase.get(username);
        return user != null && user.getPassword().equals(password);
    }
}


