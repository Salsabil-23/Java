public class Terrestrial extends Animal {
    protected int nbrLegs;
    public Terrestrial() {
        super();
        this.nbrLegs = 0;
    }
    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }
    @Override
    public String toString() {
        return super.toString() +" , Number of legs: " + nbrLegs;
    }
}