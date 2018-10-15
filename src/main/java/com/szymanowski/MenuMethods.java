package com.szymanowski;

import java.util.Scanner;

public class MenuMethods {


    public void showTitles(Movie[] myObjects) {
        for (int i = 0; i < myObjects.length; i++) {
            System.out.println(myObjects[i].getTitle());
        }
    }

    public void showGenres(Movie[] myObjects) {
        for(int i = 0; i<myObjects.length;i++) {
        System.out.println(myObjects[i].getTitle() + " - " + myObjects[i].getGenre());
        }
    }

    public void showActors(Movie[] myObjects) {
        for (int i = 0; i < myObjects.length; i++) {
            Actor[] actors = myObjects[i].getActors();
            System.out.println(myObjects[i].getTitle() + ": ");
            for (int j = 0; j < actors.length; j++) {
                System.out.print(actors[j].getName()+" "+actors[j].getSurname() + ", ");
            }
            System.out.println();
        }
    }

    public void showActorMovies(Movie[] myObjects, Scanner scanner) {
        System.out.println("Podaj nazwisko aktora w celu uzyskania jego filmografii");
        String givenActor = scanner.nextLine();
        for (int i = 0; i < myObjects.length; i++) {
            Actor[] actors = myObjects[i].getActors();
            for (int j = 0; j < actors.length; j++) {
                String comparableActorName = actors[j].getName();
                String comparableActorSurname = actors[j].getSurname();
                String comparableActor = comparableActorName + " " + comparableActorSurname;
                if (givenActor.equals(comparableActor)) {
                    System.out.println(myObjects[i].getTitle());
                }
            }
        }
    }

    public void showMoviesByGenre(Movie[] myObjects, Scanner scanner) {
        System.out.println("Podaj gatunek w celu uzyskania listy filmów");
        String givenGenre = scanner.nextLine();
        for (int i = 0; i < myObjects.length; i++) {
            String comparableGenre = myObjects[i].getGenre();
            if (givenGenre.equals(comparableGenre)) {
                System.out.println(myObjects[i].getTitle());
            }
        }
    }

    public void showMoviesByDate(Movie[] myObjects, Scanner scanner) {
        System.out.println("Podaj zakres roku produkcji filmu w formacie yyyy-yyyy, np 1990-2005");
        String givenRange = scanner.nextLine();
        String firstYear = givenRange.substring(0, 4);
        String secondYear = givenRange.substring(5, 9);
        int year1 = Integer.valueOf(firstYear);
        int year2 = Integer.valueOf(secondYear);
        for (int i = 0; i < myObjects.length; i++) {
            int comparableYear = myObjects[i].getReleaseDate();
            if (comparableYear >= year1 && comparableYear <= year2) {
                System.out.println(myObjects[i].getTitle());
            }
        }
    }


    public void greetingMethod() {

        String greeting = "Zdecyduj co chcesz zrobić według następującego MENU" + '\n' +
                "0. Wyświetl filmy" + '\n' +
                "1. Wyświetl gatunki filmów" + '\n' +
                "2. Wyświetl aktorów" + '\n' +
                "3. Wyświetl filmografie aktora" + '\n' +
                "4. Wyświetl filmy po gatunku" + '\n' +
                "5. Wyświetl filmy według daty powstania";
        System.out.println(greeting);
    }

    public void switchMethod(int choice, Movie[] myObjects, Scanner scanner){
        switch (EnumMethods.values()[choice]) {
            case SHOWTITLES:
                showTitles(myObjects);
                break;
            case SHOWGENRES:
                showGenres(myObjects);
                break;
            case SHOWACTORS:
                showActors(myObjects);
                break;
            case SHOWACTORMOVIES:
                showActorMovies(myObjects, scanner);
                break;
            case SHOWMOVIESBYGENRE:
                showMoviesByGenre(myObjects, scanner);
                break;
            case SHOWMOVIESBYDATE:
                showMoviesByDate(myObjects, scanner);
                break;
            default:
                System.out.println("Niepoprawna wartość menu");
                break;
        }
    }


}
