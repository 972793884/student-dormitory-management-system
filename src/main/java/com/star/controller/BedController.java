package com.star.controller;

import com.star.Utils.PageUtils;
import com.star.Utils.Ret;
import com.star.service.BedService;
import com.star.vo.Bed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RequestMapping("bed")
@RestController
public class BedController {
    @Autowired
    private BedService bedService;
    @Autowired
    PageUtils pageUtils;


    @GetMapping("getBedList")
    Ret getBedList() {
        List<Bed> list = bedService.findAll();
        return Ret.ok().set("bedlist", list);
    }

    @GetMapping("getBedById")
    Ret getBedById(Integer id) {
        Bed bed = bedService.getBedById(id);
        return Ret.ok().set("bed", bed);
    }

    @PostMapping("saveBed")
    Ret saveBed(Bed bed,boolean isChange) {
        Integer result ;
        if (isChange){
            result = bedService.changeBed(bed);
        }else {
            result = bedService.saveBed(bed);
        }
        return result > 0 ? Ret.ok() : Ret.fail();
    }

    @GetMapping("updateBed")
    Ret updateBed(Bed bed) {
        Integer result = bedService.updateBed(bed);
        return result > 0 ? Ret.ok() : Ret.fail();
    }

    @GetMapping("delBed")
    Ret delBed(Integer id) {
        Integer result = bedService.delBed(id);
        return result > 0 ? Ret.ok() : Ret.fail();
    }
    @GetMapping("getBuilding")
    List<Integer> getBuilding() {
        return bedService.getBuilding();
    }
    @GetMapping("getRoom")
    List<Integer> getRoom(Integer buildingNo) {
        return bedService.getRoom(buildingNo);
    }
    @GetMapping("getBed")
    List<Integer> getBed(Integer buildingNo,Integer roomNo) {
        return bedService.getBed(buildingNo,roomNo);
    }

    @GetMapping("backBed")
    Ret backBed(Bed bed) {
        bed.setStudentNo(null);
         Integer result = bed.save(true);
        return result > 0 ? Ret.ok() : Ret.fail();
    }


    @PostMapping("package")
    Ret test() throws InterruptedException {
        String str = "sh /usr/app/start.sh";
        System.out.println("执行脚本");
        build(str);
        return Ret.ok();
    }

    @GetMapping("package")
    Ret test2() throws InterruptedException {
        String str = "sh /usr/app/start.sh";
        System.out.println("执行脚本");
        build(str);
        return Ret.ok();
    }

    Ret build(String str) throws InterruptedException {
        Process p = null;
        try {
            System.out.println("--------------------开始执行--------------------------");
            p = Runtime.getRuntime().exec(str);
            InputStream inputStream = p.getInputStream();
            byte[] data = new byte[800];
            while ((inputStream.read(data, 0, data.length)) != -1) {
                System.out.println(new String(data));
            }

            InputStream e = p.getErrorStream();
            while ((e.read(data, 0, data.length - 1)) != -1) {
                System.out.println(new String(data));
            }
            p.getOutputStream().close();
            p.getInputStream().close();
            p.getErrorStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (p != null) {
                p.waitFor();
            }
            p.destroy();
            System.out.println("--------------------执行完毕--------------------------");
        }
        return Ret.ok();
    }

}
