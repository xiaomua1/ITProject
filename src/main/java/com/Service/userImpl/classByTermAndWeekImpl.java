package com.Service.userImpl;

import com.Dao.task.classByTermAndWeekDao;
import com.Model.schedule;
import com.Service.userService.classByTermAndWeekService;
import com.Util.toResponse;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Service
public class classByTermAndWeekImpl implements classByTermAndWeekService {
    /**
     *
     * @param response
     * @param term
     * @param week
     */
    @Resource
    classByTermAndWeekDao classByTermAndWeekDao;

    @Override
    public void classByTermAndWeek(HttpServletResponse response, String term, String week) {
        term=term.trim();
        week=week.trim();
        if("".equals(term)||"".equals(week)){
            JSONObject object = new JSONObject();
            object.put("code","Term or Week 有误！");
            try {
                toResponse.to_client(response, object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            List<schedule> list = classByTermAndWeekDao.classByTAndW(term, week);
            System.out.println("classByTermAndWeek:->list:" + list);
            if(null==list){
                JSONObject object = new JSONObject();
                object.put("code","此Term和Week下没有课程！");
                try {
                    toResponse.to_client(response, object);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    toResponse.to_client(response, list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void addClass(HttpServletResponse response, schedule schedule) {
        if(classByTermAndWeekDao.addClass(schedule)>0){
            System.out.println(schedule);
            JSONObject object = new JSONObject();
            object.put("code","添加课程成功！");
            try {
                toResponse.to_client(response, object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            JSONObject object = new JSONObject();
            object.put("code","添加课程失败！");
            try {
                toResponse.to_client(response, object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
