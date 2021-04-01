package by.tms.controller;

import by.tms.dao.UserDao;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping(path = "/user")
    public ModelAndView saveGet (User user, ModelAndView modelAndView) {
        modelAndView.setViewName("save");
        return modelAndView;
    }

    @PostMapping(path = "/user")
    public ModelAndView savePost (User user, ModelAndView modelAndView) {
        modelAndView.setViewName("save");
        modelAndView.addObject("user", user);
        userDao.save(user);
        return modelAndView;
    }

    @GetMapping(path = "/allInfo")
    public ModelAndView allInfoGet (ModelAndView modelAndView) {
        modelAndView.setViewName("allInfo");
        modelAndView.addObject("info", userDao.findAllUsers());
        return modelAndView;
    }
}
