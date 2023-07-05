package org.mahagan.domain;

import jakarta.persistence.*;



@Entity
@Table(name = "unversity")
public class Unversity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int unversityId;
    private String unversityName;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    public int getUnversityId() {
        return unversityId;
    }

    public void setUnversityId(int unversityId) {
        this.unversityId = unversityId;
    }

    public String getUnversityName() {
        return unversityName;
    }

    public void setUnversityName(String unversityName) {
        this.unversityName = unversityName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
