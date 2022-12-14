package com.example.studentlist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentlist.R;
import com.example.studentlist.adapters.StudentRecyclerAdapter;
import com.example.studentlist.models.Model;
import com.example.studentlist.models.Student;

public class StudentEditActivity extends AppCompatActivity {
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_edit);
        int studentIndex = getIntent().getIntExtra("studentIndex", -1);
        Button deleteStudent = this.findViewById(R.id.student_edit_delete_button);

        if (studentIndex != -1) {
            student = Model.instance().getStudent(studentIndex);
            deleteStudent.setVisibility(View.VISIBLE);
            deleteStudent.setOnClickListener(view -> {
                Model.instance().removeStudent(studentIndex);
                Intent data = new Intent();
                data.putExtra("ACTION", "DELETE");
                data.putExtra("SHOULD_UPDATE", true);
                setResult(RESULT_OK, data);
                finish();
            });
        } else {
            student = new Student();
        }

        TextView nameTv = this.findViewById(R.id.student_edit_name_input);
        TextView idTv = this.findViewById(R.id.student_edit_id_input);
        TextView phoneTv = this.findViewById(R.id.student_edit_phone_number_input);
        TextView addressTv = this.findViewById(R.id.student_edit_address_input);
        CheckBox checkbox = this.findViewById(R.id.student_edit_checkbox);
        Button cancelButton = this.findViewById(R.id.student_edit_cancel_button);
        Button saveButton = this.findViewById(R.id.student_edit_save_button);
        idTv.setText(student.getID());
        nameTv.setText(student.getName());
        phoneTv.setText(student.getPhoneNumber());
        addressTv.setText(student.getAddress());
        checkbox.setChecked(student.getIsChecked());

        cancelButton.setOnClickListener(view -> {
            finish();
        });

        saveButton.setOnClickListener(view -> {
            String id = idTv.getText().toString();
            String name = nameTv.getText().toString();
            String phone = phoneTv.getText().toString();
            String address = addressTv.getText().toString();
            String avatar = student.getAvatarPath();
            boolean isChecked = checkbox.isChecked();
            Student newStudentData = new Student(id, name, phone, address, avatar, isChecked);
            if(studentIndex == -1){
                Model.instance().addStudent(newStudentData);
            }else{
                Model.instance().editStudent(studentIndex, newStudentData);
            }
            Intent data = new Intent();
            data.putExtra("SHOULD_UPDATE", true);
            setResult(RESULT_OK, data);
            finish();
        });


    }

}