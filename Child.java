public class Child extends Person{
    private static Child[] childArray = new Child[100];
    private static int childCount = 0;

    private double weight;
    private double height;
    private String guardian;
    private Vaccine vaccineSystem;

    public Child(Vaccine vaccineSystem){
        super(vaccineSystem);
    }

    public double getWeight(){
        return this.weight;
    }
    public double getHeight(){
        return this.height;
    }
    public String getGuardian(){
        return this.guardian;
    }

    public void set(double weight, double height, String guardian){
        this.weight = weight;
        this.height = height;
        this.guardian = guardian;
    }

    public void storeChild(double weight, double height, String guardian){
        Child child = new Child(vaccineSystem);
        child.set(weight, height, guardian);
        childArray[childCount] = child;
        childCount ++;
    }

    public Child[] getAllChilds(){
        return childArray;
    }
    public int getChildCount(){
        return childCount;
    }

    public String findBMI(){
        double cal_bmi = this.weight / (this.height * this.height);
        if (cal_bmi >= 23)
            return "Overweight";
        else
            return "Normal";
    }
}