package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.UserEntity;
import web.service.UserService;



@Controller
public class UserController {

    UserService DB;

    public UserController(UserService DB) {
        this.DB = DB;
    }

    @GetMapping(value = "/")
    public String mainPage(Model model){
        model.addAttribute("userList", DB.getAllUsers());

        return "main";
    }

    @GetMapping(value = "/add")
    public String add(Model model){
        model.addAttribute("UserEntity", new UserEntity());
        return "add";
    }

    @PostMapping(value = "/add")
    public String add(@RequestParam("name") String name, @RequestParam String lastName) {
        DB.addUser(new UserEntity(name, lastName));
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String delete(){
        return "delete";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("Id") int Id) {
        DB.deleteUser(Id);
        return "redirect:/";
    }

    @GetMapping(value = "/update")
    public String update(){

        return "update";
    }

    @PostMapping(value = "/update")
    public String update(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam String lastName) {
        DB.updateUser(id, name, lastName);
        return "redirect:/";
    }

}
