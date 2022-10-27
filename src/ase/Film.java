package ase;

import java.util.*;


public class Film {
    private final String titel;
    private final Date releaseDate;
    private final String lang;
    enum Genre{
     Action,
     Comedy
    }
    private final Genre genre;
    private final long length;
    private final String Studio;
        Film(String titel, Date releaseDate, String lang, Genre genre, long length, String studio) {
        super();
        this.titel = titel;
        this.releaseDate = releaseDate;
        this.lang = lang;
        this.genre = genre;
        this.length = length;
        this.Studio = studio;
    }

}