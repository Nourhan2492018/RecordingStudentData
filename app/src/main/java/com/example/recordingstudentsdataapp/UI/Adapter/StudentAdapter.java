package com.example.recordingstudentsdataapp.UI.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordingstudentsdataapp.Model.StudentModel;
import com.example.recordingstudentsdataapp.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {
    private Context context;
    private List<StudentModel>studentList;

    public StudentAdapter(Context context, List<StudentModel> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).
                inflate(R.layout.student_card,parent,false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
    holder.onBindView(studentList.get(position));
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder {
        private TextView txtName,txtcourse,txtAttendance;
        private ImageView imageLogo;
        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txt_name);
            txtcourse=itemView.findViewById(R.id.txt_course);
            txtAttendance=itemView.findViewById(R.id.txt_attadence);
            imageLogo=itemView.findViewById(R.id.img_student);
        }
        public void onBindView(StudentModel student)
        {
            txtName.setText(student.getName());
            txtcourse.setText(student.getCourse());
            txtAttendance.setText(String.valueOf(student.getAttendance()));
            imageLogo.setImageResource(R.drawable.school_24dp);
        }

    }
}
