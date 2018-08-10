package org.dxy.websafedemo.controller;

import org.dxy.websafedemo.domain.Timeline;
import org.dxy.websafedemo.repository.TimelineRepository;
import org.dxy.websafedemo.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/csrf")
public class CsrfController {

    @Autowired
    private TimelineRepository timelineRepository;

    @GetMapping("/micro_blog")
    public String timeline(Model model) {
        List<Timeline> timelines = timelineRepository.findAll();
        model.addAttribute("timelines", timelines);
        return "csrf/timeline";
    }

    @PostMapping("/micro_blog")
    @ResponseBody
    public String microBlog(String microBlog, HttpServletRequest request) {
        timelineRepository.save(Timeline.of(SessionUtil.getUsername(request), microBlog));
        return "ok";
    }

}
