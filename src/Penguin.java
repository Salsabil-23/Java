public class Penguin extends Aquatic {
    protected float swimmingDepth;
    public Penguin() {
        super();
        this.swimmingDepth = 0;
    }
    public Penguin(String family, String name, int age, boolean isMammal,String habitat, float swimmingDepth) {
        super(family, name, age, isMammal, habitat);
        this.swimmingDepth = swimmingDepth;
    }
    public float getSwimmingDepth() {
        return swimmingDepth;
    }
    public void setSwimmingDepth(float swimmingDepth) {
        this.swimmingDepth = swimmingDepth;
    }
    @Override
    public String toString() {
        return super.toString() +" , Swimming depth: " + swimmingDepth;
    }
    @Override
    public void swim(){
        System.out.println("this penguin is Swimming");
    }

    @Override
    public void eatMeat(Object meat) {

    }
}