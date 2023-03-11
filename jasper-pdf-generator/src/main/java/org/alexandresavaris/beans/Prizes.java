package org.alexandresavaris.beans;

import java.util.List;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Prizes {

    private String year;
    private String category;
    private String overallMotivation;
    private List<Laureates> laureates;
    private JRBeanCollectionDataSource laureatesDataSource;

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

    public String getOverallMotivation() {
        return overallMotivation;
    }

    public void setOverallMotivation(String overallMotivation) {
        this.overallMotivation = overallMotivation;
    }

    public JRBeanCollectionDataSource getLaureatesDataSource() {
        this.laureatesDataSource = new JRBeanCollectionDataSource(laureates, false);
        return laureatesDataSource;
    }

    public void setLaureatesDataSource(JRBeanCollectionDataSource laureatesDataSource) {
        this.laureatesDataSource = laureatesDataSource;
    }
}
