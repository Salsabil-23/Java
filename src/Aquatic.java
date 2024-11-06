public abstract class Aquatic extends Animal {
    protected String habitat;
    public Aquatic() {
        super();
        this.habitat = "";
    }
    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }
    @Override
    public String toString() {
        return super.toString() +" , Habitat: " + habitat;
    }
    public abstract void swim();
    @Override
    public boolean equals(Object o) {
        if (null == o) return false;
        if(o instanceof Aquatic aquatic) {
            return super.getName().equals(aquatic.getName()) && super.getAge()==aquatic.age && this.habitat.equals(aquatic.habitat);
        }
        return false;
    }
}
