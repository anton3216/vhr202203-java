package com.qingqiao.vhr.service;

import com.qingqiao.vhr.bean.JobLevel;

import java.util.List;

public interface JobLevelService {
    List<JobLevel> getAllJobLevels();

    int addJobLevel(JobLevel jobLevel);

    int updateJobLevel(JobLevel jobLevel);

    int deleteJobLevel(Integer id);

    int deleteManyJobLevel(Integer[] ids);
}
