import java.util.List;

public interface IContactsProvider {
    List<Contact> loadContacts();
    void add(Contact contact);
    void remove(Contact contact);
    void update(Contact contact);
}
