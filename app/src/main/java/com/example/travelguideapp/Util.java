package com.example.travelguideapp;

import java.util.ArrayList;

public class Util {
    private static ArrayList<Country> allCoutries;
    private static ArrayList<Country> wantToVisit;
    private static ArrayList<Country> alreadyVisited;
    private static int id = 0;

    public Util() {
        if (allCoutries == null) {
            allCoutries = new ArrayList<>();
            initCountryList();
        }
        if (wantToVisit == null)
            wantToVisit = new ArrayList<>();
        if (alreadyVisited == null)
            alreadyVisited = new ArrayList<>();
    }

    public static void setWantToVisit(ArrayList<Country> wantToVisit) {
        wantToVisit = wantToVisit;
    }

    public static void setAlreadyVisited(ArrayList<Country> alreadyVisited) {
        alreadyVisited = alreadyVisited;
    }

    public static ArrayList<Country> getAllCoutries() {
        return allCoutries;
    }

    public static ArrayList<Country> getWantToVisit() {
        return wantToVisit;
    }

    public static ArrayList<Country> getAlreadyVisited() {
        return alreadyVisited;
    }

    public boolean removeWantToVisit(Country count) {
        return wantToVisit.remove(count);
    }

    public boolean removeAlredyVisited(Country count) {
        return alreadyVisited.remove(count);
    }

    public void initCountryList() {
        allCoutries.add(new Country(id++, "INDIA", "New Delhi", "$3.202 trillion USD", 1380004385, "http://4.bp.blogspot.com/_tXq8IlSptuA/S-T1j-iK0LI/AAAAAAAAA6k/xwZLbYrl0mQ/s1600/1.jpg"));
        allCoutries.add(new Country(id++, "USA", "Washington DC", "$22.32 trillion USD", 1329227746, "http://www.getsready.com/wp-content/uploads/2016/03/Statue-of-liberty-evacuation.jpg"));
        allCoutries.add(new Country(id++, "JAPAN", "Tokyo", "$5.413 trillion USD", 126486413, "https://business.okstate.edu/site-files/images/cagle/japan-big.jpg"));
        allCoutries.add(new Country(id++, "RUSSIA", "Moscow", "$1.657 trillion USD", 145933256, "https://s-i.huffpost.com/gen/1210750/images/o-RUSSIA-VIRTUALPRIDE-facebook.jpg"));
        allCoutries.add(new Country(id++, "BRAZIL", "Brasília", "1.893 trillion USD", 212516958, "https://s-i.huffpost.com/gen/1819005/images/o-BRAZIL-facebook.jpg"));
    }
}
