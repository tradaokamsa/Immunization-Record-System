public class Person {
    private static Person[] personArray = new Person[100]; 
    private static int personCount = 0;

    private String name;
    private int age;
    private String injectDate;
    private String injectName;
    private String injectPlace;
    private boolean afterInject;

    private Vaccine vaccineSystem;

    public Person(Vaccine vaccineSystem) {
        this.vaccineSystem = vaccineSystem;
    }

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getInjectDate(){
        return this.injectDate;
    }
    public String getInjectName(){
        return this.injectName;
    }
    public String getInjectPlace(){
        return this.injectPlace;
    }
    public Boolean getAfterInject(){
        return this.afterInject;
    }

    public void set(String name, int age){
        this.name = name;
        this.age = age;
        this.injectDate = null;
        this.injectName = null;
        this.injectPlace = null;
        this.afterInject = false;
    }

    public void storePerson(String name, int age){
        Person person = new Person(vaccineSystem);
        person.set(name, age);
        personArray[personCount] = person;
        personCount ++;
    }

    public Person[] getAllPersons(){
        return personArray;
    }
    public int getPersonCount(){
        return personCount;
    }

    public void inject(String name, int age, String injectDate, String injectName, String injectPlace, Boolean afterInject){
        boolean found = false;
        for (int i=0; i<=personCount; i++) {
            Person person = personArray[i];
            if (person != null && person.getName().equals(name) && person.getAge() == age) {
                found = true;
                boolean removed = this.vaccineSystem.removeVaccine(injectDate, injectName, injectPlace);
                if (removed) {
                    person.injectDate = injectDate;
                    person.injectName = injectName;
                    person.injectPlace = injectPlace;
                    person.afterInject = afterInject;
    
                    System.out.println("Record updated.");
                    System.out.println("Vaccine removed successfully. \n");
                } else {
                    System.out.println("Vaccine record not found.");
                    System.out.println("Try again. \n");
                }
            }
        }
        if(!found)
            System.out.println("Record not found. Cannot update. \n");
    }
}
