package com.Controller;


import com.Model.schedule;
import com.Service.userImpl.classByTermAndWeekImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/TermAndWeek")
public class classByTermAndWeekController {

    @Autowired
    classByTermAndWeekImpl classByTermAndWeek;

    /**
     *
     * @param response
     * @param request
     */

    @RequestMapping(value = "tAndW", method = RequestMethod.GET)
    public void classByTermAndWeek(HttpServletResponse response, HttpServletRequest request){
        String term = request.getParameter("term");
        String week = request.getParameter("week");
        classByTermAndWeek.classByTermAndWeek(response, term, week);
    }

    @RequestMapping(value = "addClass", method = RequestMethod.GET)
    public void addClass(HttpServletRequest request, HttpServletResponse response){
        schedule schedule = new schedule();
        schedule.setTeacher(request.getParameter("teacher"));
        schedule.setCourse_name(request.getParameter("course_name"));
        schedule.setExper_name(request.getParameter("exper_name"));
        schedule.setWeek(request.getParameter("week"));
        schedule.setClass_name(request.getParameter("class_name"));
        schedule.setWeekday(request.getParameter("weekday"));
        schedule.setSection(request.getParameter("section"));
        System.out.println(schedule);
        classByTermAndWeek.addClass(response, schedule);
        System.out.println(schedule);
    }

}
