package com.example.studentlist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentlist.R;
import com.example.studentlist.interfaces.OnItemClickListener;
import com.example.studentlist.models.Student;
import com.example.studentlist.ui.StudentViewHolder;

import java.util.List;


public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {

    List<Student> students;

    OnItemClickListener listener;

    public StudentRecyclerAdapter(List<Student> students) {
        this.students = students;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list_row, parent, false);
        return new StudentViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student st = this.students.get(position);
        holder.bind(st, position);
    }

    @Override
    public int getItemCount() {
        return this.students.size();
    }
}