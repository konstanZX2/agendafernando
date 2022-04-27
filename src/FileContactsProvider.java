import java.io.*;
import java.util.*;

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

        try {
            printWriter = new PrintWriter(new FileWriter("resources/contacts.txt"));
            for (Contact contact: contacts)
                printWriter.println(contactsToString(contact));
            printWriter.close();

        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    private String contactsToString(Contact contact){
        return String.join(";", String.valueOf(contact.getId()), contact.getName(), contact.getPhoneNumber(), contact.getAddress(), contact.getEmail());
    }

    @Override
    public void add(Contact contact) {
        List<Contact> contacts = loadContacts();
        contacts.add(contact);
        saveContacts(contacts);
    }

    @Override
    public void remove(Contact contact) {
        List<Contact> contacts = loadContacts();
        contacts.remove(contact);
        saveContacts(contacts);
    }

    @Override
    public void update(Contact contact) {
        List<Contact> contacts = loadContacts();
        contacts.remove(contact);
        contacts.add(contact);
        saveContacts(contacts);
    }
}

