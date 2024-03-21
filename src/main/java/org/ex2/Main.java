package org.ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

        List<Employe> employes=new ArrayList<>();

//1. Utiliser mapToDouble et sum pour calculer la somme totale des salaires de tous les employés.

        employes.add(new Employe("badr hari","boxing",80000));
        employes.add(new Employe("labron james","basketball",100000));

        employes.add(new Employe("cristiano ronaldo","football",70000));
        double somme= employes.stream().mapToDouble(employe->employe.getSalaire()).sum();
        System.out.println(somme);

//2. Utiliser sorted pour trier la liste des employés par ordre alphabétique du nom.

        employes.stream().sorted((emp1,emp2)->emp1.getNom().compareTo(emp2.getNom())).forEach(System.out::println);

//3. Utiliser min pour trouver l'employé avec le salaire le plus bas.
        Employe minSalaire=  employes.stream().min(Comparator.comparing(Employe::getSalaire)).orElseThrow(NoSuchElementException::new);
        System.out.println("l employe avec le min salaire : "+minSalaire);

//4. Utiliser filter pour obtenir la liste des employés ayant un salaire supérieur à une valeur donnée.

        System.out.println("la liste des employés ayant un salaire supérieur à une valeur donnée. 70000");
        employes.stream().filter(emp->emp.getSalaire()>70000).forEach(System.out::println);

//5. Utilisez reduce pour trouver l'employé avec le salaire le plus élevé dans l'ensemble de l'entreprise.
    Employe empPlusGrandSalaire=    employes.stream().reduce(employes.get(0),(result,currElement)-> {
            if (currElement.getSalaire()>result.getSalaire())
                result=currElement;
            return result;
        });
    System.out.println("employe avec le plus grand salaire : "+empPlusGrandSalaire);

//    6. Utilisez reduce pour concaténer les noms de tous les employés

     String noms=   employes.stream().reduce("",(result,currEmploye)-> result+" "+currEmploye.getNom(),String::join);
     System.out.println(noms);

    }
}
