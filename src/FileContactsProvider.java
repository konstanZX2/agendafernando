import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

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
            System.out.println("hace read / hace excepcion");
        }
        return contacts;
    }


    public void saveContacts(List<Contact>contacts) {
        PrintWriter printWriter;
        contacts.add(new Contact(0, "Pepe", "123456789", "C/Bonita", "pepe@gmail.com"));
        contacts.add(new Contact(1, "Maria", "123456789", "C/Bonita", "pepe@gmail.com"));
        contacts.add(new Contact(2, "Jose", "123456789", "C/Bonita", "pepe@gmail.com"));
        contacts.add(new Contact(3, "Cosmin", "123456789", "C/Bonita", "pepe@gmail.com"));

        try {
            printWriter = new PrintWriter(new FileWriter("resources/contacts.txt"));
            for (Contact contact: contacts)
                printWriter.println(contactStr(contact));
            printWriter.close();

        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    private String contactStr(Contact contact){
        return String.join(";", String.valueOf(contact.getId()), contact.getName(), contact.getPhoneNumber(), contact.getAddress(), contact.getEmail());
    }

    @Override
    public void add(Contact contact) {
saveContacts(new LinkedList<>());
    }

    @Override
    public void remove(Contact contact) {

    }

    @Override
    public void update(Contact contact) {

    }
}

