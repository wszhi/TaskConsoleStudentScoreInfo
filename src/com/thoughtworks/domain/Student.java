package com.thoughtworks.domain;


import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private double chinese;
    private double english;
    private double math;
    private double programming;
    private double average;
    private double total;

    public double getTotal() {
        return total;
    }

    public Student() {
    }

    public Student(String name, double chinese, double english, double math, double programming) {
        this.name = name;
        this.chinese = chinese;
        this.english = english;
        this.math = math;
        this.programming = programming;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getProgramming() {
        return programming;
    }

    public void setProgramming(double programming) {
        this.programming = programming;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (Double.compare(student.chinese, chinese) != 0) return false;
        if (Double.compare(student.english, english) != 0) return false;
        if (Double.compare(student.math, math) != 0) return false;
        if (Double.compare(student.programming, programming) != 0) return false;
        if (Double.compare(student.average, average) != 0) return false;
        if (Double.compare(student.total, total) != 0) return false;
        return name != null ? name.equals(student.name) : student.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(chinese);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(english);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(math);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(programming);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(average);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public List<Double> getScores() {
        return Arrays.asList(chinese,english,math,programming);
    }
}
