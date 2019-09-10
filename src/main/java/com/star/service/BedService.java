package com.star.service;

import com.star.vo.Bed;

import java.util.List;

public interface BedService {
    List<Bed> findAll();

    Bed getBedById(Integer id);

    Integer saveBed(Bed bed);

    Integer updateBed(Bed bed);

    Integer delBed(Integer id);

    Bed getBedByStudentId(Integer id);

    Integer changeBed(Bed bed);

    Bed getBedByBuildingAndRoom(Integer buildingNum, Integer roomNum);

    List<Integer> getBuilding();

    List<Integer> getRoom(Integer id);

    List<Integer> getBed(Integer buildingNo, Integer roomNo);
}
