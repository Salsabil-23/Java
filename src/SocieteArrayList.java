import java.util.*;

public class SocieteArrayList implements IGestion{
    List<Employe>Employeliste=new ArrayList<Employe>();

    @Override
    public void ajouterEmploye(Object o) {
        Employeliste.add((Employe)o);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for(Employe employe:Employeliste){
            if(employe.getNom().equals(nom))
                return true;
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Object o) {
        return Employeliste.contains(o);
    }

    @Override
    public void supprimerEmploye(Object o) {
        Employeliste.remove(o);
    }

    @Override
    public void displayEmploye() {
        int i=1;
        for(Employe employe:Employeliste){
            System.out.println("Employe n° "+i);
            System.out.println(employe.toString());
            i++;
        }
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(Employeliste);
    }

    @Override
    public void trierEmployeParNomDepartementEtGrade() {
        Comparator<Employe> depComparator = new Comparator<Employe>() {
            @Override
            public int compare(Employe o1, Employe o2) {
                return o1.getDepartement().compareTo(o2.getDepartement());
            }
        };
        Comparator<Employe> gradeComparator = new Comparator<Employe>() {
            @Override
            public int compare(Employe o1, Employe o2) {
                return o1.getGrade() - o2.getGrade();
            }
        };
        Collections.sort(Employeliste, depComparator.thenComparing(gradeComparator));
    }
}
