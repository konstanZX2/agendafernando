import javax.swing.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Agenda {
    private List<Contact> contacts = new LinkedList<>();
    private IContactsProvider provider;

    public Agenda(IContactsProvider provider) throws ExcepcionPropia {
        this.provider = provider;
        refresh();
    }

    private void refresh() throws ExcepcionPropia {
        contacts = provider.loadContacts();
        contacts.sort(Comparator.comparing(contact -> contact.getId()));
    }

    public void add(Contact contact) throws ExcepcionPropia {
        provider.add(contact);
        refresh();
    }

    public void remove(Contact contact) throws ExcepcionPropia {
        provider.remove(contact);
        refresh();
    }

    public void update(Contact contact) throws ExcepcionPropia {
        provider.update(contact);
        refresh();
    }

    public Contact retrieve(int index) {
        return contacts.get(index);
    }

    public List<Contact> filter(String filter) {
        return contacts.stream().filter(c -> c.getName().contains(filter) || c.getAddress().contains(filter)
                || c.getEmail().contains(filter) || c.getPhoneNumber().contains(filter)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String agendaStr = "";
        for (Contact contact : contacts)
            agendaStr += contacts.indexOf(contact) + "\n" + contact + "\n\n";
        return agendaStr + "\n";
    }
}
