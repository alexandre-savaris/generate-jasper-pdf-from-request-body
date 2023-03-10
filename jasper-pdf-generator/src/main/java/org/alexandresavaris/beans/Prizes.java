package org.alexandresavaris.beans;

import java.util.List;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Prizes {

    private String year;
    private String category;
    private String overallMotivation;
    private List<Laureates> laureates;
    // This is the tricky part: each prize has a list of laureates, which is exported as a datasource to be accessed by the report template at runtime.
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
        // Generates the datasource and returns it populated with laureates' data.
        this.laureatesDataSource = new JRBeanCollectionDataSource(laureates, false);
        return laureatesDataSource;
    }

    public void setLaureatesDataSource(JRBeanCollectionDataSource laureatesDataSource) {
        this.laureatesDataSource = laureatesDataSource;
    }
}
