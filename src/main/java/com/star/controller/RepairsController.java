package com.star.controller;

import com.star.Utils.PageUtils;
import com.star.Utils.Ret;
import com.star.service.LoginService;
import com.star.service.RepairsService;
import com.star.vo.Repairs;
import com.star.vo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RequestMapping("repairs")
@RestController
public class RepairsController {
    @Autowired
    private RepairsService repairsService;
    @Autowired
    PageUtils pageUtils;
    @Autowired
    LoginService loginService;

    @GetMapping("getRepairsList")
    Ret getRepairsList() {
        List<Repairs> list = repairsService.findAll();
        return Ret.ok().set("repairsList", list);
    }

    @GetMapping("getRepairsById")
    Ret getRepairsById(Integer id) {
        Repairs repairs = repairsService.getRepairsById(id);
        return Ret.ok().set("repairs", repairs);
    }

    @GetMapping("getMyRepairs")
    List<Repairs> getMyRepairs() {
        List<Repairs> repairs = repairsService.getMyRepairs();
        return repairs;
    }

    @GetMapping("getRepairs")
    List<Repairs> getRepairs() {
        List<Repairs> repairs = repairsService.getRepairs();
        return repairs;
    }

    @GetMapping("getFeedBackRepairs")
    List<Repairs> getFeedBackRepairs() {
        List<Repairs> repairs = repairsService.getFeedBackRepairs();
        return repairs;
    }

    @GetMapping("getHistoryRepairs")
    List<Repairs> getHistoryRepairs() {
        List<Repairs> repairs = repairsService.getHistoryRepairs();
        return repairs;
    }

    @PostMapping("saveRepairs")
    Ret saveRepairs(Repairs repairs) {
        Integer result = repairsService.saveRepairs(repairs);
        return result > 0 ? Ret.ok() : Ret.fail();
    }

    @PostMapping("updateRepairs")
    Ret updateRepairs(Repairs repairs) {
        Integer save = repairs.save();
        return save > 0 ? Ret.ok() : Ret.fail();
    }

    @PostMapping("updateRepairsByWorker")
    Ret updateRepairsByWorker(Repairs repairs) {
        String name = (String) SecurityUtils.getSubject().getPrincipal();
        User u = loginService.findByName(name);
        if (repairs.getStatus() == 2)
            repairs.setDoneTime(new Date());
        else
            repairs.setRepairTime(new Date());
        repairs.setRepairUser(u.getId());
        Integer save = repairs.save();
        return save > 0 ? Ret.ok() : Ret.fail();
    }

    @GetMapping("delRepairs")
    Ret delRepairs(Integer id) {
        Integer result = repairsService.delRepairs(id);
        return result > 0 ? Ret.ok() : Ret.fail();
    }
}
