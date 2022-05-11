import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class SerializableContactProvider implements IContactsProvider {
    public List<Contact> loadContacts() throws ExcepcionPropia {
        List<Contact> contacts = new LinkedList<>();


        try( ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("resources/ContactsSerialized.obj"))) {
            Contact contact;
            while (true) {
                contact = (Contact) objectInputStream.readObject();
                contacts.add(contact);
            }

        } catch (EOFException endOfFileException) {

        } catch (IOException excepcionPropia) {
            throw new ExcepcionPropia();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return contacts;
    }


    public void saveContacts(List<Contact> contacts) {

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("resources/ContactsSerialized.obj"))) {
            for (Contact contact : contacts)
                objectOutputStream.writeObject(contact);


        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    private String contactsToString(Contact contact) {
        return String.join(";", String.valueOf(contact.getId()), contact.getName(), contact.getPhoneNumber(), contact.getAddress(), contact.getEmail());
    }

    @Override
    public void add(Contact contact) throws ExcepcionPropia {
        List<Contact> contacts = loadContacts();
        contacts.add(contact);
        saveContacts(contacts);
    }

    @Override
    public void remove(Contact contact) throws ExcepcionPropia {
        List<Contact> contacts = loadContacts();
        contacts.remove(contact);
        saveContacts(contacts);
    }

    @Override
    public void update(Contact contact) throws ExcepcionPropia {
        List<Contact> contacts = loadContacts();
        contacts.remove(contact);
        contacts.add(contact);
        saveContacts(contacts);
    }
}
