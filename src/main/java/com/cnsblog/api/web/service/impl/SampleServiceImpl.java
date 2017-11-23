package com.cnsblog.api.web.service.impl;

import com.cnsblog.api.web.domain.Sample;
import com.cnsblog.api.web.mapper.SampleMapper;
import com.cnsblog.api.web.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SampleServiceImpl implements SampleService {

    private final SampleMapper sampleMapper;

    @Autowired
    public SampleServiceImpl(SampleMapper sampleMapper) {
        this.sampleMapper = sampleMapper;
    }

    @Override
    public Sample getSampleList() {
        return sampleMapper.getSampleList();
    }
}
