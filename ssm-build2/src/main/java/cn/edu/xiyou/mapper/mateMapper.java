package cn.edu.xiyou.mapper;

import cn.edu.xiyou.pojo.Classmate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface mateMapper {
    List<Classmate> selectAll();
    List<Classmate> fuzzySelect(@Param("name") String name);
    Integer delMate(Integer id);
    Integer addMate(Classmate classmate);
    Integer updateMate(Classmate classmate);
    Classmate selectById(Integer id);
}
