package com.sortstudent.service;

import com.sortstudent.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class StudentDecreaseService implements Comparator<Student>,IStudentDecrease {
    @Override
    public int compare(Student hs1, Student hs2) {
        // Định nghĩa thứ tự sắp xếp
        String[] level = {"Suat sac", "Tien tien", "Kha", "Trung binh", "Yeu"};
        int index1 = java.util.Arrays.asList(level).indexOf(hs1.getLevel());
        int index2 = java.util.Arrays.asList(level).indexOf(hs2.getLevel());
        return Integer.compare(index1, index2);
    }

    @Override
    public List<Student> studentDecrease(List<Student> students){
        Collections.sort(students, new StudentDecreaseService());
        return students;
    }
}
