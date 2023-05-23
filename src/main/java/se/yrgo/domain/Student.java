package se.yrgo.domain;
import jakarta.persistence.*;

@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String enrollmentID;
    private String name;
    private Integer numberOfCourses;
    
    public Student() {
    }

    public Student(String name)
    {
    	this.name = name;
        this.numberOfCourses = 10;
    }   

    public Student(String name, String enrollmentID) {
        this.enrollmentID = enrollmentID;
        this.name = name;
        this.numberOfCourses = 10;
    }

    public String getEnrollmentID() {
        return enrollmentID;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOfCourses() {
        return numberOfCourses;
    }

    public int getId() {
        return id;
    }


    public void setEnrollmentID(String enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfCourses(Integer numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
