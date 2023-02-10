package org.alexandresavaris.beans;

import java.util.List;

public class Prizes {

    private String year;
    private String category;
    private List<Laureates> laureates;

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setLaureates(List<Laureates> laureates) {
        this.laureates = laureates;
    }

    public List<Laureates> getLaureates() {
        return laureates;
    }
}
