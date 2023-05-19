package com.sortstudent.service;

import com.sortstudent.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class StudentDecreaseService implements Comparator<Student>,IStudentDecrease {
    static String[] level = {"Suat sac", "Tien tien", "Kha", "Trung binh", "Yeu"};
    @Override
    public int compare(Student student1, Student student2) {
        // Định nghĩa thứ tự sắp xếp
        int index1 = java.util.Arrays.asList(level).indexOf(student1.getLevel());
        int index2 = java.util.Arrays.asList(level).indexOf(student2.getLevel());
        int result = Integer.compare(index1, index2);
        if (result!=0) return result;
        else {
            return Integer.compare(student2.getAge(),student1.getAge());
        }
    }

    @Override
    public List<Student> studentDecrease(List<Student> students){
        Collections.sort(students, new StudentDecreaseService());
        return students;
    }
}
