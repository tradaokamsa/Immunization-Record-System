public class Main {
    public static void main(String[] args){
        Vaccine vaccine = new Vaccine();
        vaccine.storeVaccine("2024-05-16","Vaccine A","Clinic A",1,100);
        vaccine.storeVaccine("2023-09-11","Vaccine B","Clinic B",2,100);
        vaccine.storeVaccine("2024-03-20","Vaccine C","Clinic C",3,100);
        
        Person person = new Person(vaccine);
        person.storePerson("John", 5);
        person.storePerson("Harry", 25);

        person.inject("Duke", 6, "2024-05-16", "Vaccine A", "Clinic A", true);
        
        person.inject("Harry", 25, "2024-05-16", "Vaccine B", "Clinic A", true);
        person.inject("Harry", 25, "2024-05-16", "Vaccine A", "Clinic A", false);
        
        Parent parent = new Parent(vaccine, person.getName(), person.getAge());
        parent.updateInfo("Laura", 30);
        parent.updateInfo("Elliot", 32);
        parent.saveChildData("Laura", 30, "Alex", 1, 23, 1.7);
        parent.injectChild("Alex", "2024-05-16", "Vaccine A", "Clinic A", true);

        Admin admin = new Admin(person, vaccine, parent);
        admin.checkRemain();
        admin.notInject();
        admin.printUser();
        admin.printParent();
    }
}