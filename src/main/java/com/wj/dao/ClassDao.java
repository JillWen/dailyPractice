package com.wj.dao;

import com.wj.po.ClassPO;
import com.wj.po.Student;

import java.util.List;

/**
 * Created by wj on 2018/1/14.
 */
public interface ClassDao {
    ClassPO queryClassTeacher(String classId);
    ClassPO getClassPO(String Id);
    List<Student> getStudents(String classId);
}
