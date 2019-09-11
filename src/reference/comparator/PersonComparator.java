/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import reference.domain.*;
import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author Davor
 */
public class PersonComparator implements Comparator<Person> {

    private Map<Person, Integer> peopleIdentities;

    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
    }

    @Override
    public int compare(Person person1, Person person2) {
        if (this.peopleIdentities.containsKey(person1) && this.peopleIdentities.containsKey(person2)) {
            return this.peopleIdentities.get(person2) - this.peopleIdentities.get(person1);
        }
        return 0;
    }

}
