package com.example.studentlist.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result != null && result.getResultCode() == RESULT_OK) {
                if (result.getData() != null && result.getData().getBooleanExtra("SHOULD_UPDATE",false)) {
                    adapter.notifyDataSetChanged();
                }
            }
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentlist_recycler);
        students = Model.instance().getAllStudents();

        RecyclerView list = findViewById(R.id.studentlist_recycled);
        list.setHasFixedSize(true);

        list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentRecyclerAdapter(students);
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(pos ->{
            Intent studentDetailsIntent = new Intent(this, StudentDetails.class);
            studentDetailsIntent.putExtra("studentIndex",pos);
            startForResult.launch(studentDetailsIntent);
        });

        FloatingActionButton addStudentButton = findViewById(R.id.studentlist_new_student);
        addStudentButton.setOnClickListener(view -> {
            Intent newStudentActivity = new Intent(this, StudentEditActivity.class);
            startForResult.launch(newStudentActivity);
        });

    }




}

