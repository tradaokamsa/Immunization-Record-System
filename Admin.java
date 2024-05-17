public class Admin {
    private Person personSystem;
    private Vaccine vaccineSystem;
    private Parent parentSystem;

    public Admin(Person personSystem, Vaccine vaccineSystem, Parent parentSystem){
        this.personSystem = personSystem;
        this.vaccineSystem = vaccineSystem;
        this.parentSystem = parentSystem;
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

    public void printUser(){
        Person[] dataPerson = personSystem.getAllPersons();
        for(int i=0; i<dataPerson.length; i++){
            Person person = dataPerson[i];
            if(person != null){
                System.out.println("User name: " + person.getName());
                System.out.println("User age: " + person.getAge() + "\n");    
            }
        }
    }

    public void printParent(){
        Parent[] dataParent = parentSystem.getAllParents();
        for(int i=0; i<dataParent.length; i++){
            Parent parent = dataParent[i];
            if(parent != null){
                System.out.println("Parent name: " + parent.getName());
                System.out.println("Parent age: " + parent.getAge());
                System.out.println("Parents' child: " + parent.getChild() + "\n");    
            }
        }
    }
}
