package se.yrgo.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tutorId;
    private String name;
    private int salary;
    @OneToMany
    private Set<Student> teachingGroup;

    public Tutor() {
    }

    public Tutor(String tutorId, String name, int salary) {
        this.teachingGroup = new HashSet<Student>();
        this.tutorId = tutorId;
        this.name = name;
        this.salary = salary;
    }

    public String getTutorId() {
        return tutorId;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Set<Student> getTeachingGroup() {
        return Collections.unmodifiableSet(this.teachingGroup);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void addStudentToTeachingGroup(Student newStudent) {
        this.teachingGroup.add(newStudent);
    }

    public void removeStudentFromTeachingGroup(Student student) {
        this.teachingGroup.remove(student);
    }

}
