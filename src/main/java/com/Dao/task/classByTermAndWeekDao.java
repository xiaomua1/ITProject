package com.Dao.task;

import com.Model.schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface classByTermAndWeekDao {
    List<schedule> classByTAndW(@Param("term") String term, @Param("week") String week);
    int addClass(@Param("schedule") schedule schedule);
}
