package org.school;

import java.util.ArrayList;

public class StudentsJournal {

    private ArrayList<Student> students=new ArrayList<>();
    public static void main(String[] args) throws IllegalArgumentException {

        StudentsJournal journal = new StudentsJournal();
        journal.addStudents(journal);
        journal.printGoodStudents(journal);
        journal.deleteStudents();
        System.out.println(journal.getStudents().size() + " students");
        journal.addStudents(journal);
        journal.printBadStudents(journal);
    }

    public void addStudents(StudentsJournal journal) throws IllegalArgumentException {
        journal.addStudent(new Student(journal.getStudents().size() + 1, "Jack", "Grant", new double[]{1, 2, 3, 90}));
        journal.addStudent(new Student(journal.getStudents().size() + 1, "John", "Doe", new double[]{91, 92, 93, 90}));
        journal.addStudent(new Student(journal.getStudents().size() + 1, "Joe", "Smith", new double[]{81, 72, 93, 80}));

    }


    public void addStudent(Student student) {
        this.students.add(student);
    }

    private void printGoodStudents(StudentsJournal journal) {
        for(Student student : journal.getStudents()){
            if(student.getAverageGrade()>80) {
                System.out.println("Student with ID " + student.getId() + " and firstname "
                        + student.getFirstName() + " and lastname " + student.getLastName() +
                        " has an average grade of " + student.getAverageGrade());
            }
        }
        System.out.println(journal.getStudents().size() + " students");
    }

    public void deleteStudents() {
        this.students.clear();
    }

    private void printBadStudents(StudentsJournal journal) {
        for (Student student : journal.getStudents()) {
            if (student.getAverageGrade() < 80) {
                System.out.println("Student with ID " + student.getId() + " and firstname "
                        + student.getFirstName() + " and lastname " + student.getLastName() +
                        " has an average grade of " + student.getAverageGrade());
            }
        }
        System.out.println(journal.getStudents().size() + " students");
    }

    public ArrayList<Student> getStudents(){
        return students;
    }
}