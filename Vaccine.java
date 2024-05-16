public class Vaccine {
    private static Vaccine[] vaccineArray = new Vaccine[100]; 
    private static int vaccineCount = 0;

    private String date;
    private String name;
    private String place;
    private int id;
    private int quantity;

    public String getDate(){
        return this.date;
    }
    public String getName(){
        return this.name;
    }
    public String getPlace(){
        return this.place;
    }
    public int getId(){
        return this.id;
    }
    public int getQuantity(){
        return this.quantity;
    }

    public void set(String date, String name, String place, int id, int quantity){
        this.date = date;
        this.name = name;
        this.place = place;
        this.id = id;
        this.quantity = quantity;
    }

    public void storeVaccine(String date, String name, String place, int id, int quantity){
        Vaccine vaccine = new Vaccine();
        vaccine.set(date, name, place, id, quantity);
        vaccineArray[vaccineCount] = vaccine;
        vaccineCount ++;
    }

    public Vaccine[] getAllVaccines() {
        return vaccineArray;
    }

    public boolean removeVaccine(String date, String name, String place){
        for (int i=0; i<vaccineCount; i++){
            Vaccine vaccine = vaccineArray[i];
            if (vaccine != null && vaccine.getQuantity()>0 && vaccine.getName().equals(name) && vaccine.getDate().equals(date) && vaccine.getPlace().equals(place)) {
                vaccine.storeVaccine(date, name, place, vaccine.getId(), vaccine.getQuantity()-1);
                return true;
            }
        }
        return false;
    }

}

