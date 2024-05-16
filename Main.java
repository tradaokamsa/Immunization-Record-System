public class Main {
    public static void main(String[] args){
        Vaccine vaccineSystem = new Vaccine();
        vaccineSystem.storeVaccine("2024-05-16","Vaccine A","Clinic A",1,100);
        vaccineSystem.storeVaccine("2023-09-11","Vaccine B","Clinic B",2,100);
        vaccineSystem.storeVaccine("2024-03-20","Vaccine C","Clinic C",3,100);
        
        Person person = new Person(vaccineSystem);
        person.storePerson("John", 5);
        person.storePerson("Harry", 25);

        person.inject("Duke", 6, "2024-05-16", "Vaccine A", "Clinic A", true);
        
        person.inject("Harry", 25, "2024-05-16", "Vaccine B", "Clinic A", true);
        person.inject("Harry", 25, "2024-05-16", "Vaccine A", "Clinic A", false);
        
        Admin admin = new Admin(person, vaccineSystem);
        admin.checkRemain();
        admin.notInject();
    }
}