package com.example.studentlist.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;


import com.example.studentlist.R;
import com.example.studentlist.adapters.StudentRecyclerAdapter;
import com.example.studentlist.models.Model;
import com.example.studentlist.models.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class StudentRecyclerActivity extends AppCompatActivity {
    List<Student> students;
    StudentRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentlist_recycler);
        Model.instance().createMockData();
        students = Model.instance().getAllStudents();

        RecyclerView list = findViewById(R.id.studentlist_recycled);
        list.setHasFixedSize(true);

        list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentRecyclerAdapter(students);
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(pos ->{
            Intent studentDetailsIntent = new Intent(this, StudentDetails.class);
            studentDetailsIntent.putExtra("studentIndex",pos);
            startActivity(studentDetailsIntent);
        });

        FloatingActionButton addStudentButton = findViewById(R.id.studentlist_new_student);
        addStudentButton.setOnClickListener(view -> {
            Intent newStudentActivity = new Intent(this, StudentEditActivity.class);
            startActivity(newStudentActivity);
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();
    }



}

