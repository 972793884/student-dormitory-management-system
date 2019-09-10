package com.star.service;

import com.star.vo.Repairs;

import java.util.List;

public interface RepairsService {
    List<Repairs> findAll();

    Repairs getRepairsById(Integer id);

    Integer saveRepairs(Repairs repairs);

    Integer updateRepairs(Repairs repairs);

    Integer delRepairs(Integer id);

    List<Repairs> getMyRepairs();

    List<Repairs> getFeedBackRepairs();

    List<Repairs> getHistoryRepairs();

    List<Repairs> getRepairs();
}
