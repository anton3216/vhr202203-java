package com.qingqiao.vhr.controller.system.basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingqiao.vhr.bean.JobLevel;
import com.qingqiao.vhr.service.JobLevelService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic")
public class JobLevelController {

    @Autowired
    JobLevelService JobLevelService;

    @GetMapping("/job")
    public String getAllJobLevels() throws JsonProcessingException {
        List<JobLevel> list = JobLevelService.getAllJobLevels();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(list);
    }

    @PostMapping("/job")
    public ResponseBean addJobLevel(@RequestBody JobLevel JobLevel){
        if(JobLevelService.addJobLevel(JobLevel) == 1){
            return ResponseBean.ok("添加成功!");
        }
        return ResponseBean.error("添加失败!");
    }

    @PutMapping("/job")
    public ResponseBean updateJobLevel(@RequestBody JobLevel JobLevel){
        if(JobLevelService.updateJobLevel(JobLevel) == 1){
            return ResponseBean.ok("修改成功!");
        }
        return ResponseBean.error("修改失败!");
    }
    @DeleteMapping("/job/{id}")
    public ResponseBean deleteJobLevel(@PathVariable Integer id){
        if(JobLevelService.deleteJobLevel(id) == 1){
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }

    @DeleteMapping("/jobs/{ids}")
    public ResponseBean deleteJobLevel(@PathVariable Integer[] ids){
        if(JobLevelService.deleteManyJobLevel(ids) == ids.length){
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }

}
