import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ExcepcionPropia {
//        Contact contact = new Contact("Pepe", "123456789", "C/Bonita", "pepe@gmail.com");
//        System.out.println(contact);

        try{Agenda agenda = new Agenda(new FileContactsProvider());
            Agenda agenda1 = new Agenda(new JSerializableON_contactProvider());
        agenda1.add(new Contact(4,"a","b","c","d"));
        Contact contact = agenda.retrieve(4);
        //agenda.remove(contact);
        contact.setName("tupac");
        agenda.update(contact);
        System.out.println(agenda1);}catch(ExcepcionPropia excepcionPropia){
            System.out.println("El archivo o no existe o has puesto mal la ruta/nombre");
        }

//        Contact contact = agenda.retrieve(0);
//        contact.setName("Juan Antonio");
//        agenda.update(contact);

    }

}
