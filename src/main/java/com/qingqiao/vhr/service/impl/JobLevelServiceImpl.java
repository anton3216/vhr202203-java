package com.qingqiao.vhr.service.impl;

import com.qingqiao.vhr.bean.JobLevel;
import com.qingqiao.vhr.mapper.JObLevelMapper;
import com.qingqiao.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobLevelServiceImpl implements JobLevelService {

    @Autowired
    private JObLevelMapper mapper;

    @Override
    public List<JobLevel> getAllJobLevels() {
        return mapper.getAllJobLevels();
    }

    @Override
    public int addJobLevel(JobLevel jobLevel) {
        return mapper.insertSelective(jobLevel);
    }

    @Override
    public int updateJobLevel(JobLevel jobLevel) {
        return mapper.updateByPrimaryKeySelective(jobLevel);
    }

    @Override
    public int deleteJobLevel(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteManyJobLevel(Integer[] ids) {
        return mapper.deleteManyJobLevel(ids);
    }
}
