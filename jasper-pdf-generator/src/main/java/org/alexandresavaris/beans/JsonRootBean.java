package org.alexandresavaris.beans;

import java.util.List;

public class JsonRootBean {

    private List<Prizes> prizes;

    public void setPrizes(List<Prizes> prizes) {
        this.prizes = prizes;
    }

    public List<Prizes> getPrizes() {
        return prizes;
    }
}
