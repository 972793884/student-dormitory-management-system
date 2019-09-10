package com.star.service.Impl;

import com.star.mapper.BedMapper;
import com.star.service.BedService;
import com.star.vo.Bed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BedServiceImpl implements BedService {
    @Autowired
    BedMapper bedMapper;
    @Override
    public List<Bed> findAll() {
        return bedMapper.findAll();
    }

    @Override
    public Bed getBedById(Integer id) {
        return bedMapper.getBedById(id);
    }

    @Override
    public Integer saveBed(Bed bed) {
        Integer isHasBed=isHasBed(bed.getStudentNo());
        if (isHasBed>0){
            return -1;
        }
        Bed b = getBedByBuildingNoAndRoomNoAndBedBo(bed.getBuildingNo(),bed.getRoomNo(),bed.getBedNo());
        if (b==null){
            return -1;
        }
        bed.setId(b.getId());
        bed.setStatus(1);
        bed.setIsDelete(0);
        return bed.save();
    }

    private Bed getBedByBuildingNoAndRoomNoAndBedBo(Integer buildingNo, Integer roomNo, Integer bedNo) {
        return bedMapper.getBedByBuildingNoAndRoomNoAndBedBo(buildingNo,roomNo,bedNo);
    }

    private Integer isHasBed(Integer studentNo) {
        return bedMapper.isHasBed(studentNo);
    }

    @Override
    public Integer updateBed(Bed bed) {
        return bedMapper.updateBed(bed);
    }

    @Override
    public Integer delBed(Integer id) {
        Bed bed=getBedById(id);
        bed.setStatus(2);
        return bedMapper.updateBed(bed);
    }

    @Override
    public Bed getBedByStudentId(Integer id) {
        return bedMapper.getBedByStudentNo(id);
    }

    @Override
    public Integer changeBed(Bed bed) {
        Bed b = getBedByBuildingNoAndRoomNoAndBedBo(bed.getBuildingNo(),bed.getRoomNo(),bed.getBedNo());
        if (b==null){
            return -1;
        }
        Bed old=bedMapper.getBedByStudentNo(bed.getStudentNo());
        old.setStudentNo(null);
        old.setStatus(0);
        old.save(true);
        b.setStatus(1);
        b.setStudentNo(bed.getStudentNo());
        return b.save();
    }

    @Override
    public Bed getBedByBuildingAndRoom(Integer buildingNum, Integer roomNum) {
        return bedMapper.getBedByBuildingAndRoom(buildingNum,roomNum);
    }

    @Override
    public List<Integer> getBuilding() {
        return bedMapper.getBuilding();
    }

    @Override
    public List<Integer> getRoom(Integer id) {
        return bedMapper.getRoom(id);
    }

    @Override
    public List<Integer> getBed(Integer buildingNo, Integer roomNo) {
        return bedMapper.getBed(buildingNo,roomNo);
    }
}
