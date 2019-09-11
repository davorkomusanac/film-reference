/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import reference.domain.*;
import reference.comparator.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Davor
 */
public class Reference {

    private RatingRegister ratingRegister;

    public Reference(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }

    public Film recommendFilm(Person person) {
        List<Film> films = new ArrayList<Film>(ratingRegister.filmRatings().keySet());
        Collections.sort(films, new FilmComparator(ratingRegister.filmRatings()));

        if (this.ratingRegister.getPersonalRatings(person).isEmpty()) {
            return films.get(0);
        }

        if (this.isEveryFilmRated(films, person)) {
            return null;
        }
        Film recommendedFilm = this.calculateSimilarity(person);
        return recommendedFilm;
    }

    private boolean isEveryFilmRated(List<Film> films, Person person) {
        for (Film film : films) {
            if (this.ratingRegister.getRating(person, film).equals(Rating.NOT_WATCHED)) {
                return false;
            }
        }
        return true;
    }

    private Film calculateSimilarity(Person personToRecommend) {
        List<Person> reviewers = this.ratingRegister.reviewers();
        reviewers.remove(personToRecommend);        
        Person mostSimilarPerson = this.mostSimilarPerson(reviewers, personToRecommend);
        Film recommendedFilm = this.filmRecommendationSimilarPerson(personToRecommend, mostSimilarPerson);
        return recommendedFilm;
    }
    
    private Person mostSimilarPerson(List<Person> reviewers, Person personToRecommend) {
        Iterator<Person> iterator = reviewers.iterator();
        Person mostSimilarPerson = reviewers.get(0);
        int biggestSimilarity = 0;

        while (iterator.hasNext()) {
            Person personToCompare = iterator.next();
            int similarity = 0;

            for (Film film : this.ratingRegister.filmRatings().keySet()) {
                if (this.ratingRegister.getPersonalRatings(personToRecommend).containsKey(film) && this.ratingRegister.getPersonalRatings(personToCompare).containsKey(film)) {
                    similarity += this.ratingRegister.getRating(personToRecommend, film).getValue() * this.ratingRegister.getRating(personToCompare, film).getValue();
                }
            }
            if (similarity > biggestSimilarity) {
                biggestSimilarity = similarity;
                mostSimilarPerson = personToCompare;
            }
        }
        return mostSimilarPerson;
    }

    private Film filmRecommendationSimilarPerson(Person personToRecommend, Person similarPerson) {
        List<Film> filmsToRecommend = new ArrayList<Film>();

        for (Film film : this.ratingRegister.filmRatings().keySet()) {
            if (!this.ratingRegister.getPersonalRatings(personToRecommend).containsKey(film) && this.ratingRegister.getPersonalRatings(similarPerson).containsKey(film)) {
                filmsToRecommend.add(film);
            }
        }
        if (filmsToRecommend.isEmpty()) {
            return null;
        }
        Film recommendedFilm = this.highestRatedFilmByAPerson(filmsToRecommend, similarPerson);
        return recommendedFilm;
    }

    private Film highestRatedFilmByAPerson(List<Film> listOfFilms, Person similarPerson) {
        Film recommendedFilm = listOfFilms.get(0);
        for (Film film : listOfFilms) {
            if (this.ratingRegister.getRating(similarPerson, film).getValue() > this.ratingRegister.getRating(similarPerson, recommendedFilm).getValue()) {
                recommendedFilm = film;
            }
        }
        if (this.ratingRegister.getRating(similarPerson, recommendedFilm).getValue() < 2) {
            return null;
        }
        return recommendedFilm;
    }
}
