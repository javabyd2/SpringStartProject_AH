package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Role;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.RoleService;
import com.sda.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "index") //metody które wyświetlają pliki html zwracają obiekt ModelAndView
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("booksList", bookService.getBooks());
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @GetMapping(value = "web/authors")
    public ModelAndView authors(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("authorsList", authorService.getAuthors());
        modelAndView.setViewName("authors");
        return modelAndView;
    }
    @GetMapping(value = "/web/users")
    public ModelAndView users(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usersList", userService.getUsers());
        modelAndView.setViewName("users");
        return modelAndView;
    }
    @GetMapping(value = "/web/roles")
    public ModelAndView roles(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("rolesList", roleService.getRolesList());
        modelAndView.setViewName("roles");
        return modelAndView;
    }
    @PostMapping(value = "/web/addRole")
    public String addRole(@ModelAttribute("role")Role role,
                          RedirectAttributes redirectAttributes) {
        roleService.save(role);
        redirectAttributes.addFlashAttribute("message", "Dodano pomyślnie");

        return "redirect:/web/roleForm";
    }

    @GetMapping(value = "/web/roleForm")
    public ModelAndView roleForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("roleForm");
        modelAndView.addObject("role", new Role());
        return modelAndView;
    }
}
