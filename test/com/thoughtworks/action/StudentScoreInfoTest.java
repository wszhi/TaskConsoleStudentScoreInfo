package com.thoughtworks.action;


import com.thoughtworks.domain.Student;
import com.thoughtworks.domain.Summary;
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
    private StudentScoreInfo studentScoreInfo;
    private List<Student> students = new ArrayList<>();
    private Student student1;
    private Student student2;

    @Before
    public void setUp() throws Exception {
        student1 = new Student("张三", 95, 80, 75, 80);
        student2 = new Student("李四", 80, 70, 85, 90);
        students = Arrays.asList(student1, student2);
        studentScoreInfo = new StudentScoreInfo();
    }

    @Test
    public void shouldReturnStudentArrayListWhenTransformToModelAndView() throws Exception {
        List<Student> result = studentScoreInfo.transformModelAndView(studentString);
        assertThat(result.size(), is(2));
        assertThat(student1, is(result.get(0)));
        assertThat(student2, is(result.get(1)));
    }

    @Test
    public void shouldReturnStudentArrayListWithAverageAndMiddleScoreWhenCallGetStudentScore() throws Exception {
        studentScoreInfo.getStudentScore(students);

        assertThat(students.size(), is(2));
        assertEquals("张三", students.get(0).getName());
        assertThat(students.get(0).getAverage(), is(82.5));
        assertThat(students.get(0).getTotal(), is(330.0));
        assertThat(students.get(1).getAverage(), is(81.25));
        assertThat(students.get(1).getTotal(), is(325.0));

    }

    @Test
    public void shouldReturnSummaryWhenCallCalculateMethod() throws Exception {
        students.get(0).setTotal(330.0);
        students.get(1).setTotal(325.0);
        Summary summary = studentScoreInfo.calculate(students);
        assertThat(summary.getTotalAverage(),is(327.5));
        assertThat(summary.getTotalMidden(),is(327.5));

    }

    @Test
    public void shouldReturnScoresSheetStringWhenCallPrintMethod() throws Exception {
        students.get(0).setTotal(330.0);
        students.get(0).setAverage(82.5);
        students.get(1).setAverage(81.25);
        students.get(1).setTotal(325.0);
        Summary summary = new Summary(327.5,327.5);
        String result = studentScoreInfo.printResult(students,summary);
        String expect = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分 \n" +
                "=================================\n" +
                "张三|75.0|95.0|80.0|80.0|82.5|330.0\n" +
                "李四|85.0|80.0|70.0|90.0|81.25|325.0\n" +
                "=================================\n" +
                "全班总分平均数：327.5\n" +
                "全班总分中位数：327.5";
        assertEquals(expect,result);

    }
}
