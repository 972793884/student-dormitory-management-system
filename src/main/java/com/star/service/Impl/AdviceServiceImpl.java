package com.star.service.Impl;

import com.star.mapper.AdviceMapper;
import com.star.service.AdviceService;
import com.star.vo.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdviceServiceImpl implements AdviceService {
    @Autowired
    AdviceMapper adviceMapper;
    @Override
    public List<Advice> findAll() {
        return adviceMapper.findAll();
    }

    @Override
    public Advice getAdviceById(Integer id) {
        return adviceMapper.getAdviceById(id);
    }

    @Override
    public Integer saveAdvice(Advice advice) {
        return adviceMapper.saveAdvice(advice);
    }

    @Override
    public Integer updateAdvice(Advice advice) {
        return adviceMapper.updateAdvice(advice);
    }

    @Override
    public Integer delAdvice(Integer id) {
        Advice advice =getAdviceById(id);
        advice.setIsDelete(1);
        return adviceMapper.updateAdvice(advice);
    }
}
