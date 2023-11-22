package com.example.rektmodule4.controller;

import com.example.rektmodule4.model.Branch;
import com.example.rektmodule4.model.Employee;
import com.example.rektmodule4.service.BranchService;
import com.example.rektmodule4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    BranchService branchService;



    @ModelAttribute("listBranch")
    public List<Branch> getListBranch() {
        return branchService.findAll();
    }

    @GetMapping("/home")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("listEmployee", employeeService.findAll(Sort.by("age")));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("deleteEmployee", employeeService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute("deleteEmployee") Employee employee) {
        employeeService.delete(employee);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/create")

    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("newEmployee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("newEmployee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("create");
        }
        employeeService.save(employee);

        return new ModelAndView("createDone");
    }

    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("employeeEdit", employeeService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Valid @ModelAttribute("employeeEdit") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("edit");
        }
        employeeService.save(employee);
        return new ModelAndView("editDone");
    }

    @GetMapping("/employeeDetail/{id}")
    public ModelAndView viewDetail(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("employeeDetail");
        modelAndView.addObject("employeeDetail", employeeService.findById(id));
        return modelAndView;
    }



}
