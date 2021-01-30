package com.example.recordingstudentsdataapp.DataBaseApp.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.recordingstudentsdataapp.Model.StudentModel;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    void insertStudent(StudentModel student);
    @Update
    void updateStudent( StudentModel student);
    @Delete
    void removeStudent( StudentModel student);
    @Query("select * from student_table")
    List<StudentModel> getAllStudentData();
}
