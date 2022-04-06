import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileContactsProvider implements IContactsProvider {

    public List<Contact> loadContacts() {
        List<Contact> contacts = new LinkedList<>();
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader("resources/contacts.txt"));
            String linea = bufferedReader.readLine();
            while (linea != null) {
                String[] partes = linea.split(";");
                Contact contact = new Contact(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4]);
                contacts.add(contact);
                linea = bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (IOException exception) {
            System.out.println("IO Exception");

        } finally {
            System.out.println("idk, pls die");
        }
        return contacts;
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

