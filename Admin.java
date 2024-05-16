public class Admin {
    private Person personSystem;
    private Vaccine vaccineSystem;

    public Admin(Person personSystem, Vaccine vaccineSystem){
        this.personSystem = personSystem;
        this.vaccineSystem = vaccineSystem;
    }

    public void checkRemain(){
        Vaccine[] dataVaccine = vaccineSystem.getAllVaccines();
        for(int i=0; i<dataVaccine.length; i++){
            Vaccine vaccine = dataVaccine[i];
            if(vaccine != null){
                System.out.println("Vaccine number " + i);
                System.out.println("Vaccine date: " + vaccine.getDate());
                System.out.println("Vaccine name: " + vaccine.getName());
                System.out.println("Vaccine place: " + vaccine.getPlace());
                System.out.println("Vaccine Id: " + vaccine.getId());
                System.out.println("Vaccine quantity: " + vaccine.getQuantity());
                System.out.println("\n");
            }
        }
    }

    public void notInject(){
        int remaining = 0;
        Person[] dataPerson = personSystem.getAllPersons();
        for(int i=0; i<dataPerson.length; i++){
            Person person = dataPerson[i];
            if(person != null)
                if(person.getInjectDate() == null)
                    remaining += 1;
        }
        System.out.println("Number of not injected people: " + remaining + "\n");
    }
}
