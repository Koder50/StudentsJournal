package org.school;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.school.Student;

import static org.junit.Assert.assertEquals;
import java.lang.IllegalArgumentException;

public class StudentsJournalTest {

    StudentsJournal journal;
    @Before
    public void setUp() {
        journal = new StudentsJournal();
    }
    @Test
    public void addStudentCorrectData() {
        journal.addStudent(new Student(1,"Karol","Nowak",new double[]{91,92,93,90}));
        assertEquals(1, journal.getStudents().size());
        Student studentExpected = new Student(1,"Karol","Nowak",new double[]{91,92,93,90});
        Student studentActual = new Student(journal.getStudents().get(0).getId(),journal.getStudents().get(0).getFirstName(),journal.getStudents().get(0).
                getLastName(),journal.getStudents().get(0).getGrades());
        assertEquals(studentExpected.toString(), studentActual.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentNegativeId() throws IllegalArgumentException {
        journal.addStudent(new Student(1,"Karol","Nowak",new double[]{91,92,93,90}));
        journal.addStudent(new Student(-1,"Karol","Nowak",new double[]{91,92,93,90}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentZeroId() throws IllegalArgumentException {
        journal.addStudent(new Student(1,"Karol","Nowak",new double[]{91,92,93,90}));
        journal.addStudent(new Student(0,"Karol","Nowak",new double[]{91,92,93,90}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWrongCharactersAtStartOfFirstName() {
        journal.addStudent(new Student(1,"-1Karol","Nowak",new double[]{91,92,93,90}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWrongCharacterInTheEndOfFirstName() {
        journal.addStudent(new Student(1,"Karol(","Nowak",new double[]{91,92,93,90}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWrongCharacterInTheMiddleOfFirstName() {
        journal.addStudent(new Student(1,"Kar(ol","Nowak",new double[]{91,92,93,90}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentSpaceInTheMiddleOfFirstName() {
        journal.addStudent(new Student(1,"Kar ol","Nowak",new double[]{91,92,93,90}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentSpaceAtTheStartOfFirstName() {
        journal.addStudent(new Student(1," Karol","Nowak",new double[]{91,92,93,90}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentSpaceInTheEndOfFirstName() {
        journal.addStudent(new Student(1,"Karol ","Nowak",new double[]{91,92,93,90}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWrongCharactersAtStartOfLastName() {
        journal.addStudent(new Student(1,"Karol","-1Nowak",new double[]{91,92,93,90}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWrongCharacterInTheEndOfLastName() {
        journal.addStudent(new Student(1,"Karol","Nowak(",new double[]{91,92,93,90}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWrongCharacterInTheMiddleOfLastName() {
        journal.addStudent(new Student(1,"Karol","No(wak",new double[]{91,92,93,90}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentSpaceInTheMiddleOfLastName() {
        journal.addStudent(new Student(1,"Karol","No wak",new double[]{91,92,93,90}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentSpaceAtTheStartOfLastName() {
        journal.addStudent(new Student(1,"Karol"," Nowak",new double[]{91,92,93,90}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentSpaceInTheEndOfLastName() {
        journal.addStudent(new Student(1,"Karol","Nowak ",new double[]{91,92,93,90}));
    }

    @Test
    public void addStudentCorrectDoubleArray() {
        journal.addStudent(new Student(1,"Karol","Nowak",new double[]{0,92,1,90}));
    }

    @Test
    public void addStudentCorrectDataAllInManyParts() {
        journal.addStudent(new Student(1,"Karol","Nowak",new double[]{91,92,93,90}));
        assertEquals(1, journal.getStudents().size());
        assertEquals(1, journal.getStudents().get(0).getId());
        assertEquals("Karol", journal.getStudents().get(0).getFirstName());
        assertEquals("Nowak", journal.getStudents().get(0).getLastName());
        assertEquals(91, journal.getStudents().get(0).getGrades()[0],0.01);
        assertEquals(92, journal.getStudents().get(0).getGrades()[1],0.01);
        assertEquals(93, journal.getStudents().get(0).getGrades()[2],0.01);
        assertEquals(90, journal.getStudents().get(0).getGrades()[3],0.01);
        assertEquals(91.5, journal.getStudents().get(0).getAverageGrade(), 0.01);
    }

    @Test
    public void addStudentsCheckSize() {
        journal.addStudents(journal);
        assertEquals(3, journal.getStudents().size());
    }

    @Test
    public void addStudentsCheckFirstId() {
        journal.addStudents(journal);
        assertEquals(1, journal.getStudents().get(0).getId());
    }

    @Test
    public void addStudentsCheckThirdId() {
        journal.addStudents(journal);
        assertEquals(3, journal.getStudents().get(2).getId());
    }

    @Test
    public void addStudentsCheckFirstFirstNameId() {
        journal.addStudents(journal);
        assertEquals("Jack", journal.getStudents().get(0).getFirstName());
    }

    @Test
    public void addStudentsCheckThirdLastNameId() {
        journal.addStudents(journal);
        assertEquals("Smith", journal.getStudents().get(2).getLastName());
    }

    @Test
    public void addStudentsCheckSecondDoubleArraySizeAllInOneObject() {
        journal.addStudents(journal);
        assertEquals( 4, journal.getStudents().get(1).getGrades().length);
    }

    @Test
    public void addStudentsCheckSecondDoubleArraySecondElementAllInOneObject() {
        journal.addStudents(journal);
        assertEquals( 92, journal.getStudents().get(1).getGrades()[1],0.01);
    }

    @Test
    public void addStudentsThenDeleteAllAllInOneObject() {
        journal.addStudents(journal);
        journal.deleteStudents();
        assertEquals(0,journal.getStudents().size());
    }

    @Test
    public void addStudentThenDeleteAllInOneObject() {
        journal.addStudent(new Student(1,"Karol","Nowak",new double[]{91,92,93,90}));
        journal.deleteStudents();
        assertEquals(0,journal.getStudents().size());
    }

    @Test
    public void deleteStudents() {
        journal.deleteStudents();
        assertEquals(0,journal.getStudents().size());
    }


    @Test
    public void addStudentThenGetItAllInOneObject() {
        journal.addStudent(new Student(1,"Karol","Nowak",new double[]{91,92,93,90}));
        assertEquals(1,journal.getStudents().size());
    }

    @Test
    public void addStudentsThenGetAllAllInOneObject() {
        journal.addStudents(journal);
        assertEquals(3,journal.getStudents().size());
    }

    @Test
    public void addStudentsGetAverageGradeWhenZeroGradesAllInOneObject() {
        journal.addStudent(new Student(1,"Karol","Nowak",new double[]{}));
        assertEquals(0,journal.getStudents().get(0).getAverageGrade(),0.01);
    }

    @Test
    public void addStudentsGetAverageGradeWhenTwoGradesAllInOneObject() {
        journal.addStudent(new Student(1,"Karol","Nowak",new double[]{2,91}));
        assertEquals(46.5,journal.getStudents().get(0).getAverageGrade(),0.01);
    }

    @After
    public void tearDown() {
        journal.deleteStudents();
        journal = null;
    }
}
