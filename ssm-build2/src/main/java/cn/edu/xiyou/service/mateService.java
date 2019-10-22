package cn.edu.xiyou.service;

import cn.edu.xiyou.pojo.Classmate;

import java.util.List;

public interface mateService {
    //查询所有学生信息
    List<Classmate> selectAll();
    //模糊查询
    List<Classmate> fuzzySelect(String name);
    //删除学生信息
    Integer delMate(Integer id);
    //添加一个学生
    Integer addMate(Classmate classmate);
    //更新学生信息
    Integer updateMate(Classmate classmate);
    //根据Id查询学生信息
    Classmate selectById(Integer id);
}
