package com.logy.mapper;

import com.logy.mode.Nation;

import java.util.List;

public interface NationMapper {
    /**
     * 查询所有名族
     * @return
     */
    List<Nation> queryAllNation();
}
