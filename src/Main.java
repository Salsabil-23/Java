//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SocieteArrayList list = new SocieteArrayList();
        Employe e1=new Employe(1,"hafsi","salsabil","informatique",2);
        Employe e2=new Employe(2,"mou7li","melek","informatique",1);
        Employe e3=new Employe(3,"hafsi","folla","meklaaa",3);
        Employe e4=new Employe(4,"haf","mayousha","pip",4);
        list.ajouterEmploye(e1);
        list.ajouterEmploye(e2);
        list.ajouterEmploye(e3);
        list.ajouterEmploye(e4);
        System.out.println("Liste des employes");
        list.displayEmploye();
        System.out.println("Existance du nom:");
        System.out.println(list.rechercherEmploye("hafsi"));
        System.out.println("Existance d'un employe:");
        System.out.println(list.rechercherEmploye(e4));
        System.out.println("Liste des employes");
        list.displayEmploye();
        list.trierEmployeParId();
        System.out.println("Liste des employes apres tri par ID");
        list.displayEmploye();
        list.trierEmployeParNomDepartementEtGrade();
        System.out.println("Liste des employes apres tri par departement et grade");
        list.displayEmploye();
        list.supprimerEmploye(e4);
        System.out.println("Liste des employes apres suppression");
        list.displayEmploye();
        }
}
