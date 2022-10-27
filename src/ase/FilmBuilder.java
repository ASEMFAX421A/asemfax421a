package ase;

import java.util.*;

import ase.Film.*;
import ase.FilmBuilder.*;


public class FilmBuilder {
    private  String titel;
    private  Date releaseDate;
    private  String lang;
    private  Genre genre;
    private  long length;
    private  String studio;

    public void setTitle(String titel) {
        this.titel = titel;
    }
    public void setReleaseDate(Date date) {
        releaseDate= date;
    }
    public void setLanguage(String langCode) {
        lang = langCode;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public void setLength(long length) {
        this.length = length;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }
    public Film build() {
        return new Film(titel, releaseDate,lang,genre, length,studio);
        
    }
    
}
