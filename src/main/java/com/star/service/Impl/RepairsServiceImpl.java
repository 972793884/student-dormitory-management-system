package com.star.service.Impl;

import com.star.mapper.RepairsMapper;
import com.star.service.LoginService;
import com.star.service.RepairsService;
import com.star.vo.Repairs;
import com.star.vo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class RepairsServiceImpl implements RepairsService {
    @Autowired
    RepairsMapper repairsMapper;
    @Autowired
    LoginService loginService;
    @Override
    public List<Repairs> findAll() {
        return repairsMapper.findAll();
    }

    @Override
    public Repairs getRepairsById(Integer id) {
        return repairsMapper.getRepairsById(id);
    }

    @Override
    public Integer saveRepairs(Repairs repairs) {
        repairs.setIsDelete(0);
        repairs.setCreateTime(new Date());
        repairs.setStatus(0);
        repairs.setCreateUser((String) SecurityUtils.getSubject().getPrincipal());
        return repairsMapper.saveRepairs(repairs);
    }

    @Override
    public Integer updateRepairs(Repairs repairs) {
        return repairsMapper.updateRepairs(repairs);
    }

    @Override
    public Integer delRepairs(Integer id) {
        Repairs repairs =getRepairsById(id);
        repairs.setIsDelete(1);
        return repairsMapper.updateRepairs(repairs);
    }

    @Override
    public List<Repairs> getMyRepairs() {
        String name=(String) SecurityUtils.getSubject().getPrincipal();
        return repairsMapper.getMyRepairs( name);
    }

    @Override
    public List<Repairs> getRepairs() {
        String name=(String) SecurityUtils.getSubject().getPrincipal();
        User u = loginService.findByName(name);
        return repairsMapper.getRepairs(u.getId());
    }

    @Override
    public List<Repairs> getFeedBackRepairs() {
        String name=(String) SecurityUtils.getSubject().getPrincipal();
        return repairsMapper.getFeedBackRepairs(name);
    }

    @Override
    public List<Repairs> getHistoryRepairs() {
        String name=(String) SecurityUtils.getSubject().getPrincipal();
        return repairsMapper.getHistoryRepairs(name);
    }
}
