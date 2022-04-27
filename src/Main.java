public class Main {
    public static void main(String[] args) {
//        Contact contact = new Contact("Pepe", "123456789", "C/Bonita", "pepe@gmail.com");
//        System.out.println(contact);

        Agenda agenda = new Agenda(new FileContactsProvider());
        agenda.add(new Contact(4,"a","b","c","d"));
        Contact contact = agenda.retrieve(4);
        //agenda.remove(contact);
        contact.setName("tupac");
        agenda.update(contact);
        System.out.println(agenda);

//        Contact contact = agenda.retrieve(0);
//        contact.setName("Juan Antonio");
//        agenda.update(contact);

    }

}
