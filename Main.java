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
        parent.saveChildData("Laura", 30, "Alex", 19, 90, 1.7);
        parent.saveChildData("Anthony", 33, "Jake", 13, 43, 1.7);
        parent.injectChild("Boh", "Laura", "2024-05-16", "Vaccine A", "Clinic A", true);
        parent.injectChild("Alex", "Laura", "2024-05-20", "Vaccine A", "Clinic A", true);
        parent.injectChild("Jake", "Anthony", "2024-05-16", "Vaccine A", "Clinic A", true);

        Admin admin = new Admin(person, vaccine, parent);
        admin.checkRemain();
        admin.printUser();
        admin.notInject();
        admin.printParent();
    }
}