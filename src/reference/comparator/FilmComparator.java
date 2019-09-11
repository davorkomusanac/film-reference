/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import reference.domain.*;
import java.util.Comparator;
import java.util.Map;
import java.util.List;

/**
 *
 * @author Davor
 */
public class FilmComparator implements Comparator<Film> {

    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

     private double calculateAverageRating(Film film) {
        double sumRating = 0;
        for (Rating rating : this.ratings.get(film)) {
            sumRating += rating.getValue();
        }
        double averageRating = sumRating / this.ratings.get(film).size();
        return averageRating;
    }

    @Override
    public int compare(Film film1, Film film2) {
        if (this.calculateAverageRating(film1)==this.calculateAverageRating(film2)) {
            return 0;
        } 
        else if (this.calculateAverageRating(film1) > this.calculateAverageRating(film2)) {
            return -1;
        } else {
            return 1;
        }
        
    }

}
