import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class PostgreSQLProvider implements IContactsProvider{

    Connection con =null;
    public PostgreSQLProvider(){
        String url = "jdbc:postgresql://89.36.214.106:5432/geo";
        String usuari = "geo";
        String password = "geo";
        try {

            con = DriverManager.getConnection(url, usuari, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> loadContacts() {
        return null;
    }

    @Override
    public void add(Contact contact) {

    }

    @Override
    public void remove(Contact contact) {

    }

    @Override
    public void update(Contact contact) {

    }
}
