package cn.edu.xiyou.service;

import cn.edu.xiyou.mapper.mateMapper;
import cn.edu.xiyou.pojo.Classmate;

import java.util.List;

public class mateServiceImpl implements mateService {
    private mateMapper mateMapper;

    public void setMateMapper(mateMapper mateMapper) {
        this.mateMapper = mateMapper;
    }
    //查询所有学生信息
    public List<Classmate> selectAll() {
        return mateMapper.selectAll();
    }

    public List<Classmate> fuzzySelect(String name) {
        return mateMapper.fuzzySelect(name);
    }

    public Integer delMate(Integer id) {
        return mateMapper.delMate(id);
    }

    public Integer addMate(Classmate classmate) {
        return mateMapper.addMate(classmate);
    }

    public Integer updateMate(Classmate classmate) {
        return mateMapper.updateMate(classmate);
    }

    public Classmate selectById(Integer id) {
        return mateMapper.selectById(id);
    }
}
