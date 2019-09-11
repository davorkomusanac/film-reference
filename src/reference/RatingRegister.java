/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import reference.domain.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Davor
 */
public class RatingRegister {

    private Map<Film, List<Rating>> allFilmsRatings;
    private Map<Person, Map<Film, Rating>> personRatings;

    public RatingRegister() {
        allFilmsRatings = new HashMap<Film, List<Rating>>();
        personRatings = new HashMap<Person, Map<Film, Rating>>();
    }

    public void addRating(Film film, Rating rating) {
        if (!this.allFilmsRatings.keySet().contains(film)) {
            this.allFilmsRatings.put(film, new ArrayList<Rating>());
        }
        this.allFilmsRatings.get(film).add(rating);
    }

    public List<Rating> getRatings(Film film) {
        if (this.allFilmsRatings.keySet().contains(film)) {
            return this.allFilmsRatings.get(film);
        } else {
            return null;
        }
    }

    public Map<Film, List<Rating>> filmRatings() {
        return this.allFilmsRatings;
    }

    public void addRating(Person person, Film film, Rating rating) {
        if (!this.personRatings.containsKey(person)) {
            this.personRatings.put(person, new HashMap<Film, Rating>());
        }
        for (Person ratingPerson : this.personRatings.keySet()) {
            if (ratingPerson.equals(person)) {
                if (!this.personRatings.get(person).containsKey(film)) {
                    this.personRatings.get(ratingPerson).put(film, rating);                    
                    this.addRating(film, rating);
                }
            }
        }
    }

    public Rating getRating(Person person, Film film) {
        if (this.personRatings.containsKey(person) && this.personRatings.get(person).containsKey(film)) {
            return this.personRatings.get(person).get(film);
        } else {
            return Rating.NOT_WATCHED;
        }
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (this.personRatings.containsKey(person)) {
            return this.personRatings.get(person);
        }
        Map<Film, Rating> emptyMap = new HashMap<Film, Rating>();
        return emptyMap;
    }

    public List<Person> reviewers() {
        List<Person> reviewers = new ArrayList<Person>();
        for (Person person : this.personRatings.keySet()) {
            reviewers.add(person);
        }
        return reviewers;
    }
}
