package com.thoughtworks.domain;


public class Summary {

    private Double totalAverage;
    private Double totalMidden;

    public Summary(Double totalAverage, Double totalMidden) {
        this.totalAverage = totalAverage;
        this.totalMidden = totalMidden;
    }

    public Double getTotalAverage() {
        return totalAverage;
    }

    public Double getTotalMidden() {
        return totalMidden;
    }


}
