package com.example.studentlist.models;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();
    List<Student> students = new LinkedList<>();
    private Model() {
    }

    public static Model instance() {
        return Model._instance;
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student getStudent(int index){
        if(students.size() > 0){
            return students.get(index);
        }
        return null;
    }

    public void addStudent(Student st){
        students.add(st);
    }

    public void editStudent(int studentIndex,Student st){
        Student currentStudent = students.get(studentIndex);
        currentStudent.update(st);

    }

    public void removeStudent(int studentIndex){
        students.remove(studentIndex);
    }

    public void createMockData() {
        students.add(new Student("313196032","Afik Nof","0525914991","George Wise 20","",true));
        students.add(new Student("313196032","Rotem Biton","0525914991","George Wise 20","",false));
        students.add(new Student("313196032","Asaf Nof","0525914991","George Wise 20","",false));
        students.add(new Student("313196032","Tamar Nof","0525914991","George Wise 20","",false));
        students.add(new Student("313196032","Ofer Nof","0525914991","George Wise 20","",false));
        students.add(new Student("313196032","Limor Nof","0525914991","George Wise 20","",false));
        students.add(new Student("313196032","Rili Klein","0525914991","George Wise 20","",false));
        students.add(new Student("313196032","Yuli Klein","0525914991","George Wise 20","",false));
        students.add(new Student("313196032","Liv Klein","0525914991","George Wise 20","",false));
        students.add(new Student("313196032","Omer Kaplan","0525914991","George Wise 20","",false));
        students.add(new Student("313196032","Shira Halifa","0525914991","George Wise 20","",false));
    }
}
