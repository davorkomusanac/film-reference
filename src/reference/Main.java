package reference;

import reference.domain.*;

public class Main {

    public static void main(String[] args) {
        
        // this is an example with random films and reviewers to get a recommendation
        RatingRegister rek = new RatingRegister();
        Film saksiKasi = new Film("Saksikäsi");
        Film eraserhead = new Film("Eraserhead");
        Film haifisch = new Film("Haifisch");
        Film citizenKane = new Film("Citizen Kane");
        Film rocky = new Film("Rocky");
        
        
        Person pekka = new Person("Pekka");
        Person arto = new Person("Arto");
        Person miko = new Person("Michael");
        Person ana = new Person("Anna");
        Person jos = new Person("Joseph");
        
        rek.addRating(pekka, eraserhead, Rating.FINE);
        rek.addRating(pekka, saksiKasi, Rating.FINE);
        rek.addRating(pekka, haifisch, Rating.FINE);
        rek.addRating(pekka, citizenKane, Rating.FINE);
        rek.addRating(pekka, rocky, Rating.FINE);
        
        rek.addRating(arto, haifisch, Rating.GOOD);
        rek.addRating(arto, saksiKasi, Rating.GOOD);
        
        rek.addRating(miko, haifisch, Rating.BAD);
        rek.addRating(miko, eraserhead, Rating.GOOD);
        
        rek.addRating(ana, haifisch, Rating.FINE);
        rek.addRating(ana, saksiKasi, Rating.NEUTRAL);
        
        rek.addRating(jos, saksiKasi, Rating.GOOD);
        
        Reference reference = new Reference(rek);
        System.out.println(reference.recommendFilm(arto));

    }
}
