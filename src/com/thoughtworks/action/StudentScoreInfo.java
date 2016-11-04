package com.thoughtworks.action;

import com.thoughtworks.domain.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentScoreInfo {


    public List<Student> transformModelAndView(String[][] studentString) {
        List<Student> students = new ArrayList<>();
        for (int position = 0; position < studentString.length; position++) {
            Student student = new Student();
            student.setName(studentString[position][0]);
            student.setChinese(Double.parseDouble(studentString[position][1]));
            student.setEnglish(Double.parseDouble(studentString[position][2]));
            student.setMath(Double.parseDouble(studentString[position][3]));
            student.setProgramming(Double.parseDouble(studentString[position][4]));
            students.add(student);
        }
        return students;
    }


    public void getStudentScore(List<Student> students) {

        for (Student student : students) {
            List<Double> scores = student.getScores();
            double sum = student.getChinese() + student.getEnglish() + student.getMath() + student.getProgramming();
            double average = sum / 4;
            student.setAverage(average);
            student.setMiddle(calculateMiddle(scores));
        }
    }

    private Double calculateMiddle(List<Double> scores) {
        Collections.sort(scores);
        int length = scores.size();
        if (length % 2 == 0) {
            return (scores.get((length / 2) - 1) + scores.get(length / 2)) / 2;
        } else {
            return scores.get(length / 2);
        }
    }

}
