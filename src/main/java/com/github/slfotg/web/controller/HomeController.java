package com.github.slfotg.web.controller;

import java.util.Map.Entry;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.github.slfotg.web.form.RegisterForm;

@Controller
@RequestMapping("/")
@SessionAttributes("registerForm")
public class HomeController {

    @ModelAttribute
    public RegisterForm registerForm() {
        RegisterForm registerForm = new RegisterForm();
        return registerForm;
    }

    @GetMapping
    public String index(@ModelAttribute RegisterForm registerForm) {
        return "index";
    }

    @PostMapping
    public String register(@Valid @ModelAttribute RegisterForm registerForm, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public String validationHandler(BindException ex, Model model) {
        ex.printStackTrace();
        for (Entry<String, Object> entry : ex.getModel().entrySet()) {
            System.out.println(String.format("%s - %s", entry.getKey(), entry.getValue()));
        }
        model.addAllAttributes(ex.getModel());
        return "index";
    }

}
