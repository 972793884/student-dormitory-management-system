package com.star.service;

import com.star.vo.Advice;

import java.util.List;

public interface AdviceService {
    List<Advice> findAll();

    Advice getAdviceById(Integer id);

    Integer saveAdvice(Advice advice);

    Integer updateAdvice(Advice advice);

    Integer delAdvice(Integer id);
}
