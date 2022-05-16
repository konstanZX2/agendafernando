import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class JSerializableON_contactProvider implements IContactsProvider {

    final Gson gson = new Gson();
    public List<Contact> loadContacts() throws ExcepcionPropia {
        List<Contact> contacts = new LinkedList<>();


        Type tipoListaContactos = new TypeToken<List<Contact>>() {}.getType();
        List<Contact> contacts1= null;
        try (FileReader fileReader = new FileReader("resources/ContactsSerializedJSON.json")) {
            contacts1 = gson.fromJson(fileReader, tipoListaContactos);
            if (contacts1==null){
                contacts1=new LinkedList<>();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return contacts1;

    }


    public void saveContacts(List<Contact> contacts) {

        try (FileWriter fileWriter = new FileWriter("resources/ContactsSerializedJSON.json")) {

                fileWriter.write(gson.toJson(contacts));


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

