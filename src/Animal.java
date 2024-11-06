public class Animal {
    protected String family;
    protected String name;
    protected int age;
    protected boolean isMammal;
    public String getFamily() {
        return this.family;
    }
    public void setFamily(String family) {
        this.family = family;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        if (age < 0){
            System.out.println("l'age ne peut pas etre negatif.\n");
        }
        else {
            this.age = age;
        }
    }
    public boolean isMammal() {
        return this.isMammal;
    }
    public void setMammal(boolean isMammal) {
        this.isMammal = isMammal;
    }

    public Animal(){
        this.family = "";
        this.name="";
        this.age = 0;
        this.isMammal = false;
    }

    public Animal(String family, String name, int age, boolean isMammal) {
        this.setFamily(family) ;
        this.setName(name);
        this.setAge(age);
        this.setMammal(isMammal);
    }
    public Animal(String name) {
        this.family = "";
        this.setName(name);
        this.age = 0;
        this.isMammal = false;
    }
    @Override
    public String toString() {
        return "Animal Name: " + name + ", Family: " + family + ", Age: " + age + ", Mammal: " + isMammal;
    }
}