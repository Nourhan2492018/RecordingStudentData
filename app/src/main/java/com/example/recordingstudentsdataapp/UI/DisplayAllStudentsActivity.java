package com.example.recordingstudentsdataapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recordingstudentsdataapp.DataBaseApp.AllDataBase;
import com.example.recordingstudentsdataapp.Model.StudentModel;
import com.example.recordingstudentsdataapp.R;
import com.example.recordingstudentsdataapp.UI.Adapter.StudentAdapter;

import java.util.ArrayList;

public class DisplayAllStudentsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private AllDataBase allDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_students);
        recyclerView = findViewById(R.id.recycle_view);
        allDataBase = AllDataBase.getDataBase(this);
        if (allDataBase.studentDao().getAllStudentData().isEmpty()) {
            Toast.makeText(this,
                    "Not Data Yet", Toast.LENGTH_LONG).show();
        } else {
            studentAdapter = new StudentAdapter(this, allDataBase.studentDao().getAllStudentData());
            recyclerView.setAdapter(studentAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }
}
