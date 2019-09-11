# film-reference
Reference and recommend films, get recommendations by other people

This is a project that was done through a MOOC course (Object-Oriented programming with Java, part II) by University of Helsinki. 
This specific project (exercise 46.) was a project during the final week 12 ( https://materiaalit.github.io/2013-oo-programming/part2/week-12/ ).

As it is a part of the course, it is validated through TMC which runs the tests online, so my project had to be modified in some parts to accommodate the tests so that I would points for it.

This is how the project should work:

Create a program to recommend films.The program is able to recommend films both according to people's common appraisal and according to the ratings given by a specific person.
If people have added their own preferences to the reference service, we know something about their film tastes. Extend the functionality of our reference to create a personal recommendation if the person has evaluated films. The functionality implemented in the previous part has to be preserved: if a person hasn't evaluated any film, we recommend them a film according to film ratings.

Personal recommendations are based on the similarity between the person ratings and other people's ratings. Let's reason about it with the help of the following table; in the first line on the top there are films, and the people who have rated are on the left. The brackets describe the ratings given.

Films already watched are not recommended.

