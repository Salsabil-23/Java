public class Terrestrial extends Animal implements Omnivore{
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

    @Override
    public void eatPlantAndMeet(Object food) {
        System.out.println(food);
    }

    @Override
    public void eatMeat(Object meat) {
        System.out.println(meat);
    }

    @Override
    public void eatPlant(Object plant) {
        System.out.println(plant);
    }
}