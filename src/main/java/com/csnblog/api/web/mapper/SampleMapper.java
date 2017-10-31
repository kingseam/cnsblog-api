package com.csnblog.api.web.mapper;

import com.csnblog.api.web.domain.Sample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SampleMapper {
    Sample getSampleList();
}