package com.example.recordingstudentsdataapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recordingstudentsdataapp.DataBaseApp.AllDataBase;
import com.example.recordingstudentsdataapp.Model.StudentModel;
import com.example.recordingstudentsdataapp.R;

public class RecordingStudentActivity extends AppCompatActivity {
 private EditText name,course,attendance;
 private Button inset,update,remove,display;
 private AllDataBase allDataBase;
 private StudentModel student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // id EditText
        name=findViewById(R.id.txt_input_name);
        course=findViewById(R.id.txt_input_course);
        attendance=findViewById(R.id.txt_input_attendance);
       // id Buttons
        inset=findViewById(R.id.btn_insert);
        update=findViewById(R.id.btn_update);
        remove=findViewById(R.id.btn_remove);
        display=findViewById(R.id.btn_display_all_student);
        //
        allDataBase= AllDataBase.getDataBase(this);
        //
        inset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(CheckNotEmptyData())
             {
                 student=new StudentModel(name.getText().toString()
                 ,course.getText().toString(),
                         Integer.parseInt(attendance.getText().toString()));
                 allDataBase.studentDao().insertStudent(student);
                 Toast.makeText(getApplicationContext(),
                         "Success insert",Toast.LENGTH_LONG).show();
             }
             else
                Toast.makeText(getApplicationContext(),
                        "Failed insert",Toast.LENGTH_LONG).show();

            }
        });

        //
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(CheckNotEmptyData())
                {
                    student=new StudentModel(name.getText().toString()
                            ,course.getText().toString(),
                            Integer.parseInt(attendance.getText().toString()));
                    allDataBase.studentDao().updateStudent(student);
                    Toast.makeText(getApplicationContext(),
                            "Success Update",Toast.LENGTH_LONG).show();

                }
                else
                    Toast.makeText(getApplicationContext(),
                            "Empty input",Toast.LENGTH_LONG).show();

            }
        });
        //
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(CheckNotEmptyData())
                {
                    student=new StudentModel(name.getText().toString()
                            ,course.getText().toString(),
                            Integer.parseInt(attendance.getText().toString()));
                    allDataBase.studentDao().removeStudent(student);
                    Toast.makeText(getApplicationContext(),
                            "Success Remove",Toast.LENGTH_LONG).show();
                    /*if(res!=0)
                     Toast.makeText(getApplicationContext(),
                            "Success Remove",Toast.LENGTH_LONG).show();
                     else
                        Toast.makeText(getApplicationContext(),
                                "Failed Remove",Toast.LENGTH_LONG).show();
                */
                }
                else
                    Toast.makeText(getApplicationContext(),
                            "Empty Data",Toast.LENGTH_LONG).show();
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecordingStudentActivity.this
                ,DisplayAllStudentsActivity.class);
                startActivity(intent);
            }
        });
    }
    public boolean CheckNotEmptyData()
    {
        if((!name.getText().toString().equals(""))
                &&(!course.getText().toString().equals(""))
                && (!attendance.getText().toString().equals("")))
        {
            return true;
        }
        return false;
    }
}
