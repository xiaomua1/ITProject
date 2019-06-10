package com.Service.userService;

import com.Model.schedule;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public interface classByTermAndWeekService {
    void classByTermAndWeek(HttpServletResponse response, String term, String week);
    void addClass(HttpServletResponse response, schedule schedulec);
}
