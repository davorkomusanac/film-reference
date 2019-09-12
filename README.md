# film-reference
Reference and recommend films, get recommendations by other people

This is a project that was done through a MOOC course (Object-Oriented programming with Java, part II) by University of Helsinki. 
This specific project (exercise 46.) was a project during the final week 12 ( https://materiaalit.github.io/2013-oo-programming/part2/week-12/ ).

As it is a part of the course, it is validated through TMC which runs the tests online, so my project had to be modified in some parts to accommodate the tests so that I would get points for it.

This is how the project should work:

A program to recommend films.The program is able to recommend films both according to people's common appraisal and according to the ratings given by a specific person.
If people have added their own preferences to the reference service, we know something about their film tastes.If a person has evaluated at least one film, it is recommended a film by another person who has the highest similarity value. 

Personal recommendations are based on the similarity between the person ratings and other people's ratings. 

Similarity is calculated the following way: 
For each film that was watched by two people the ratings are multiplied (so if someone gave a rating of 3 and the other person gave a -5, the similarity based on one film is -15) and if there are several films that two people watched then each similarity is added, and the final similarity is the sum total. 

The person then gets a film recommendation from another person who has the highest similarity with him.

If a person hasn't evaluated any film, we recommend them a film according to film ratings.

Films already watched are not recommended.

