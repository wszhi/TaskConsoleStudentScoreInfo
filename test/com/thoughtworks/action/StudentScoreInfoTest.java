package com.thoughtworks.action;


import com.thoughtworks.domain.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class StudentScoreInfoTest {
    private String[][] studentString = {{"张三", "95", "80", "75", "80"}, {"李四", "80", "70", "85", "90"}};
    private List<Student> students=new ArrayList<>();
    private Student student1;
    private Student student2;

    @Before
    public void setUp() throws Exception {
        student1 = new Student("张三", 95, 80, 75, 80);
        student2 = new Student("李四", 80, 70, 85, 90);
        students = Arrays.asList(student1, student2);
    }

    @Test
    public void shouldReturnStudentArrayListWhenTransformToModelAndView() throws Exception {
        StudentScoreInfo studentScoreInfo = new StudentScoreInfo();
        List<Student> result = studentScoreInfo.transformModelAndView(studentString);
        assertThat(result.size(), is(2));
        assertThat(student1, is(result.get(0)));
        assertThat(student2, is(result.get(1)));
    }

    @Test
    public void shouldReturnStudentArrayListWithAverageAndMiddleScoreWhenCallGetStudentScore() throws Exception {
        StudentScoreInfo studentScoreInfo = new StudentScoreInfo();

        studentScoreInfo.getStudentScore(students);

        assertThat(students.size(), is(2));
        assertEquals("张三", students.get(0).getName());
        assertThat(students.get(0).getAverage(), is(82.5));
        assertThat(students.get(0).getMiddle(), is(80.0));
        assertThat(students.get(1).getAverage(), is(81.25));
        assertThat(students.get(1).getMiddle(), is(82.5));

    }

}
