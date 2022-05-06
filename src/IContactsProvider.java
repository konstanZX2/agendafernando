import java.util.List;

public interface IContactsProvider {
    List<Contact> loadContacts() throws ExcepcionPropia;
    void add(Contact contact) throws ExcepcionPropia;
    void remove(Contact contact) throws ExcepcionPropia;
    void update(Contact contact) throws ExcepcionPropia;
}
