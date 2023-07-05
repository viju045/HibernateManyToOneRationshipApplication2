package org.mahagan.domain;

import jakarta.persistence.*;
//This is my Second ManyToOne mapping ralationship application in hibernate.
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int studentId;

    private String studentFirstName;

    private String studentLastName;
    private String section;
    @ManyToOne(cascade = CascadeType.ALL)
    private Unversity unversity;

    public Unversity getUnversity() {
        return unversity;
    }

    public void setUnversity(Unversity unversity) {
        this.unversity = unversity;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }


}
