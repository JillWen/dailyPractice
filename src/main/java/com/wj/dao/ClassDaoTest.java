package com.wj.dao;

import com.wj.po.Student;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 配置spring和junit整合，这样junit在启动时就会加载spring容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ClassDaoTest {
    @Resource
    ClassDao classDao;

    @org.junit.Test
    public void queryClassTeacher() throws Exception {
        System.out.println(classDao.queryClassTeacher("1").getTeacher().getName());
    }

    @org.junit.Test
    public void getStudents() throws Exception {
        List<Student> students = classDao.getClassPO("1").getStudents();
        for (Student student : students){
            System.out.println("1" + student.getName());
        }
        List<Student> students2 = classDao.getStudents("1");
        for (Student student : students){
            System.out.println("2" + student.getName());
        }
    }

}