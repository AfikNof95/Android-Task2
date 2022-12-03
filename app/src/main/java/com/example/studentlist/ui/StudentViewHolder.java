package com.example.studentlist.ui;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentlist.R;
import com.example.studentlist.interfaces.OnItemClickListener;
import com.example.studentlist.models.Student;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    TextView studentNameTv;
    TextView studentIDTv;
    ImageView studentAvatar;
    CheckBox studentCheckbox;


    public StudentViewHolder(@NonNull View itemView, OnItemClickListener listener) {
        super(itemView);
        studentNameTv = itemView.findViewById(R.id.studentlistRow_nameTv);
        studentIDTv = itemView.findViewById(R.id.studentListRow_idTv);
        studentAvatar = itemView.findViewById(R.id.studentListRow_avatar);
        studentCheckbox = itemView.findViewById(R.id.studentListRow_cb);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = getAdapterPosition();
                listener.onItemClick(pos);
            }
        });
}

    public void bind(@NonNull Student st, int pos) {
        studentNameTv.setText(st.getName());
        studentIDTv.setText(st.getID());
        studentCheckbox.setChecked(st.getIsChecked());
        studentCheckbox.setTag(pos);
    }
}