package com.example.studentlist.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentlist.R;
import com.example.studentlist.models.Model;
import com.example.studentlist.models.Student;

public class StudentDetails extends AppCompatActivity {
    Student student;
    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result != null && result.getResultCode() == RESULT_OK) {
                if (result.getData() != null && result.getData().getBooleanExtra("SHOULD_UPDATE",false)) {
                    Intent data = new Intent();
                    data.putExtra("SHOULD_UPDATE", true);
                    setResult(RESULT_OK, data);
                }
                if (result.getData().getStringExtra("ACTION") != null && result.getData().getStringExtra("ACTION").equals("DELETE")) {
                    finish();
                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        Intent currentIntent = getIntent();
        Bundle data = currentIntent.getExtras();
        student = Model.instance().getAllStudents().get(data.getInt("studentIndex"));



        Button editButton = this.findViewById(R.id.student_details_edit_button);
        editButton.setOnClickListener(view -> {
            Intent editStudentIntent = new Intent(this, StudentEditActivity.class);
            editStudentIntent.putExtra("studentIndex", data.getInt("studentIndex"));
            startForResult.launch(editStudentIntent);
        });

        bindData();
    }

    protected void bindData(){
        TextView nameTv = this.findViewById(R.id.student_details_name_input);
        TextView idTv = this.findViewById(R.id.student_details_id_input);
        TextView phoneTv = this.findViewById(R.id.student_details_phone_number_input);
        TextView addressTv = this.findViewById(R.id.student_details_address_input);
        CheckBox checkbox = this.findViewById(R.id.student_details_checkbox);


        nameTv.setText(student.getName());
        idTv.setText(student.getID());
        phoneTv.setText(student.getPhoneNumber());
        addressTv.setText(student.getAddress());
        checkbox.setChecked(student.getIsChecked());
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindData();
    }
}