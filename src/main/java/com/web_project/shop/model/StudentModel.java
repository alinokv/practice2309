package com.web_project.shop.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Size(min = 3, message = "мало букав")
    private String Name;
    @Size(min = 3, message = "мало букав")
    private String FirstName;
    @Nullable
    private String LastName;

    public StudentModel(long i, String name, String firstName, String lastName, String corpEmail, int course){

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public @Size(min = 3, message = "мало букав") String getName() {
        return Name;
    }

    public void setName(@Size(min = 3, message = "мало букав") String name) {
        Name = name;
    }

    public @Size(min = 3, message = "мало букав") String getFirstName() {
        return FirstName;
    }

    public void setFirstName(@Size(min = 3, message = "мало букав") String firstName) {
        FirstName = firstName;
    }

    @Nullable
    public String getLastName() {
        return LastName;
    }

    public void setLastName(@Nullable String lastName) {
        LastName = lastName;
    }

    @Nullable
    public @Email(message = "не корректно") String getCorpEmail() {
        return CorpEmail;
    }

    public void setCorpEmail(@Nullable @Email(message = "не корректно") String corpEmail) {
        CorpEmail = corpEmail;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getCourse() {
        return Course;
    }

    public void setCourse(int course) {
        Course = course;
    }

    @Nullable
    @Email(message = "не корректно")
    private String CorpEmail;
    private boolean isDeleted;
    private int Course;

    public StudentModel(int course, boolean isDeleted, @Nullable String corpEmail, @Nullable String lastName, String firstName, String name, long id) {
        Course = course;
        this.isDeleted = isDeleted;
        CorpEmail = corpEmail;
        LastName = lastName;
        FirstName = firstName;
        Name = name;
        Id = id;
    }
}
