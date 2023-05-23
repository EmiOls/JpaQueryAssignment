package se.yrgo.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Tutor {
    private String tutorId;
    private String name;
    private int salary;

    @ManyToMany(mappedBy = "tutors")
    private Set<Subject> subjectsToTeach;

    @OneToMany
    private Set<Student> teachingGroup;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Tutor() {
    }

    public Tutor(String tutorId, String name, int salary) {
        this.teachingGroup = new HashSet<Student>();
        this.tutorId = tutorId;
        this.name = name;
        this.salary = salary;
        this.subjectsToTeach = new HashSet<Subject>();
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
        return name;
    }

    public void addStudentToTeachingGroup(Student newStudent) {
        this.teachingGroup.add(newStudent);
    }

    public void addSubjectsToTeach(Subject subject) {
        subject.getTutors().add(this);
    }

}
