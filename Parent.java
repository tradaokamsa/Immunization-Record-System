public class Parent extends Person {
    private static Parent[] parentArray = new Parent[100];
    private static int parentCount = 0;

    private String child;
    private Vaccine vaccineSystem;
    private Child childSystem;

    public Parent(Vaccine vaccineSystem, String name, int age) {
        super(vaccineSystem);
        this.vaccineSystem = vaccineSystem;
        this.childSystem = new Child(vaccineSystem);  
        this.set(name, age);  
    }

    public String getChild() {
        return this.child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public void storeParent(String name, int age, String child) {
        Parent parent = new Parent(vaccineSystem, name, age);
        parent.setChild(child);
        parentArray[parentCount] = parent;
        parentCount++;
    }

    public Parent[] getAllParents() {
        return parentArray;
    }

    public void updateInfo(String name, int age) {
        Person person = new Person(vaccineSystem);
        person.storePerson(name, age);
        System.out.println("Add information successfully. \n");
    }

    public void saveChildData(String parentName, int parentAge, String childName, int childAge, double childWeight, double childHeight) {
        storeParent(parentName, parentAge, childName);

        Person person = new Person(vaccineSystem);
        person.storePerson(childName, childAge);

        Child child = new Child(vaccineSystem);
        child.storeChild(childWeight, childHeight, parentName);

        System.out.println("Successfully add child's information. \n");
    }

    public boolean findChild(String childName) {
        for (int i = 0; i <= parentCount; i++) {  
            if (parentArray[i] != null && parentArray[i].getChild().equals(childName)) {
                return true;
            }
        }
        return false;
    }

    public void injectChild(String childName, String injectDate, String injectName, String injectPlace, Boolean afterInject) {
        if (findChild(childName)) {
            Child[] dataChild = childSystem.getAllChilds();
            for (int i = 0; i < childSystem.getChildCount(); i++) {
                Child child = dataChild[i];
                if (child != null && child.getGuardian().equals(this.getName())) {
                    if (child.findBMI().equals("Overweight")) {
                        System.out.println("Cannot inject this child.");
                    } else {
                        child.inject(childName, child.getAge(), injectDate, injectName, injectPlace, afterInject);
                    }
                }
            }
        } else {
            System.out.println("Cannot find this child. \n");
        }
    }
}
