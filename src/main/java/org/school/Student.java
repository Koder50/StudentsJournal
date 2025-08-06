package org.school;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private double[] grades;
    public Student(int id,String firstName, String lastName, double[] grades) throws IllegalArgumentException {
        if(id<=0) throw new IllegalArgumentException("Wrong id value");
        else if (firstName.length() == 0 || (firstName.toLowerCase().matches(".*[^a-z].*")))
            throw new IllegalArgumentException("First name cannot be empty or contain special characters");
        else if (lastName.length() == 0 || (lastName.toLowerCase().matches(".*[^a-z].*")))
            throw new IllegalArgumentException("Last name cannot be empty or contain special characters");
        else if (!(grades instanceof double[]))
            throw new IllegalArgumentException("You should use a double array");

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    //first student should have id number 1
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double[] getGrades() {
        return grades;
    }

    public double getAverageGrade(){
        double sum = 0;
        double [] grades = new double[getGrades().length];
        grades=getGrades();
        for(double grade : grades){
            sum += grade;
        }
        if(grades.length==0) return sum;
        return sum / grades.length;
    }

    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grades=" + grades[0]+", " + grades[1]+", " + grades[2]+", " + grades[3] +
                '}';
    }

}
