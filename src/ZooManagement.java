import java.util.Scanner;
public class ZooManagement {

    public static void main(String[] args) {
        int nbrCages, animalAge, nbAnimals,choix;
        boolean animalMammal;
        String zooName, animalFamily, animalName, city, animalName2, animalName3;



        Zoo myZoo = new Zoo("belvedere","tunis",3);
        Animal a1=new Animal("cat","lion",4,true);
        Animal a2=new Animal("dog","wolf",6,true);
        Animal a3=new Animal("fish","jellyfish",1,false);
        Animal a4=new Animal("dog","dogg",-2,false);

        try {
            myZoo.addAnimal(a1);
            System.out.println("Nombre d'animaux : " + myZoo.nbAnimals());
            myZoo.addAnimal(a2);
            System.out.println("Nombre d'animaux : " + myZoo.nbAnimals());
            myZoo.addAnimal(a3);
            System.out.println("Nombre d'animaux : " + myZoo.nbAnimals());
            myZoo.addAnimal(a4); // Ce dernier ajout doit déclencher ZooFullException

        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        Terrestrial t=new Terrestrial();
        System.out.println("t eats: ");
        t.eatPlantAndMeet(Food.MEAT);

        Dolphin d=new Dolphin();
        System.out.println("d eats: ");
        d.eatMeat(Food.MEAT);

        Penguin p=new Penguin();
        System.out.println("p eats: ");
        p.eatMeat(Food.MEAT);
        Aquatic a= new Aquatic() {
            @Override
            public void swim() {
                System.out.println("Aquatic swimming");
            }

            @Override
            public void eatMeat(Object meat) {
                System.out.println("Aquatic eat Meat");
            }
        };
        System.out.println("a eats: ");
        d.eatMeat(Food.PLANT);

        Aquatic aq=new Penguin("pip","houta",5,true,"ocean1",200f);
        Aquatic aquatic=new Dolphin("fish","dolphin",3,true,"ocean",50f);
        Aquatic aquatic1=new Penguin("houta","houta",5,false,"ocean1",100f);
        Terrestrial terrestrial=new Terrestrial("dog","wolf",5,true,4);
        Dolphin dolphin=new Dolphin("big fish","dolphin",6,true,"pacific ocean",4);
        Penguin penguin=new Penguin("birds","penquin",10,true,"north pole",40);

        System.out.println(aq.equals(aquatic));

        System.out.println(aquatic.toString());
        System.out.println(aquatic1.toString());
        System.out.println(terrestrial.toString());
        System.out.println(dolphin.toString());
        System.out.println(penguin.toString());

        myZoo.addAquaticAnimal(aquatic);
        myZoo.addAquaticAnimal(aquatic1);
        myZoo.addAquaticAnimal(aq);
        System.out.println("Swim des aquatiques:");
        for (int i=0;i < myZoo.aquaticAnimals.length;i++){
            if(myZoo.aquaticAnimals[i]!=null) {
                myZoo.aquaticAnimals[i].swim();
            }
        }
        myZoo.displayNumberOfAquaticsByType();
        System.out.println("Max Penguin Swimming Depth: "+myZoo.maxPenguinSwimmingDepth());

        /*aquatic.swim();
        dolphin.swim();
        penguin.swim();*/

        /*System.out.print("Entrez les informations du zoo: \n");
        do {
            Scanner reader5 = new Scanner(System.in);
            System.out.print("Entrez le nom du zoo : \n");
            zooName = reader5.nextLine();
        }while (zooName.equals(""));
        Scanner reader6 = new Scanner(System.in);
        System.out.print("Entrez le nom de la ville : \n");
        city = reader6.nextLine();
        do {
            Scanner reader7 = new Scanner(System.in);
            System.out.print("Entrez le nombre de cages (entre 1 et 25) : \n");
            nbrCages = reader7.nextInt();
        }while (nbrCages <=0 || nbrCages > 25);
        Zoo myZoo = new Zoo(zooName,city,nbrCages);
        System.out.println(myZoo.toString());


        do {
            System.out.println("Welcome to the Zoo Management!");
            System.out.println("1. Ajouter un animal au zoo");
            System.out.println("2. Chercher un animal dans le zoo");
            System.out.println("3. Supprimer un animal du zoo");
            System.out.println("4. Afficher les animaux du zoo ");
            System.out.println("0. Quitter");
            do {
                Scanner sc = new Scanner(System.in);
                System.out.println("Entrez votre choix: ");
                choix = sc.nextInt();
            }while (choix < 0 || choix > 4);
            switch (choix) {
                case 1:
                    System.out.println("Entrez les informations de l'animal: ");
                    Scanner reader1 = new Scanner(System.in);
                    System.out.println("Entrez la famille de l'animal: ");
                    animalFamily = reader1.nextLine();
                    Scanner reader2 = new Scanner(System.in);
                    System.out.println("Entrez le nom de l'animal: ");
                    animalName = reader2.nextLine();
                    do {
                        Scanner reader3 = new Scanner(System.in);
                        System.out.println("Entrez l'age de l'animal: ");
                        animalAge = reader3.nextInt();
                    }while (animalAge <0);
                    Scanner reader4 = new Scanner(System.in);
                    System.out.println("Est ce que cet animal est mammal?(mammal: true, non mammal: false): ");
                    animalMammal = reader4.nextBoolean();
                    Animal animal = new Animal(animalFamily,animalName,animalAge,animalMammal);
                    System.out.println(myZoo.addAnimal(animal));

                    break;
                    case 2:
                        Scanner animName = new Scanner(System.in);
                        System.out.print("Entrez le nom de l'animal à chercher: \n");
                        animalName2 = animName.nextLine();
                        Animal anim = new Animal(animalName2);
                        System.out.println(myZoo.searchAnimal(anim));
                        break;
                    case 3:
                        Scanner animNams = new Scanner(System.in);
                        System.out.print("Entrez le nom de l'animal à supprimer: \n");
                        animalName3 = animNams.nextLine();
                        Animal anim1 = new Animal(animalName3);
                        System.out.println(myZoo.removeAnimal(anim1));
                        break;
                    case 4:
                        myZoo.displayZoo();

                        break;


            }
        }while(choix != 0);*/

    }


}










