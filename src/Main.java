public class Main {
    public static void main(String[] args) {
//        Contact contact = new Contact("Pepe", "123456789", "C/Bonita", "pepe@gmail.com");
//        System.out.println(contact);

        Agenda agenda = new Agenda(new FileContactProvider());
        System.out.println(agenda);

        Contact contact = agenda.retrieve(0);
        contact.setName("Juan Antonio");
        agenda.update(contact);

        System.out.println(agenda);
    }

}
