/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschool;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Natasa
 */
public class Assignment {

    private String title;
    private String description;
    private LocalDate subDateTime;
    private float oralMark;
    private float totalMark;
    private Course course;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDateTime = subDateTime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public float getOralMark() {
        return oralMark;
    }

    public void setOralMark(float oralMark) {
        this.oralMark = oralMark;
    }

    public float getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(float totalMark) {
        this.totalMark = totalMark;
    }

    public Assignment(String title, String description, LocalDate subDateTime, Course course) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.course = course;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
        return "Title: " + title + ". Description: " + description + ". \n" + "Submission date: " + subDateTime.format(dateFormat);
    }

}
