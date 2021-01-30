package com.example.recordingstudentsdataapp.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class StudentModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String course;
    @ColumnInfo
    private int attendance;
    public StudentModel(String name, String course, int attendance) {
        this.name = name;
        this.course = course;
        this.attendance = attendance;
    }
    public String getName() {
        return name;
    }
    public String getCourse() {
        return course;
    }
    public int getAttendance() {
        return attendance;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
}
