package com.example.aiservice.controllers;

import com.example.aiservice.domain.User;
import com.example.aiservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public ModelAndView main(
            Map<String, Object> model,
            @RequestParam(name="name", required = false, defaultValue = "World") String name
    ){
        model.put("main", name);
        return new ModelAndView("greeting", model);

    }

    @GetMapping("/user")
    public ModelAndView getName(Map<String, Object> model){
        List<User> users = userRepository.findAll();
        model.put("users", users);
        return new ModelAndView("main", model);

    }

    @PostMapping("/user")
    public ModelAndView setName(@RequestParam String name, Map<String, Object> model){
        User user = new User(name);
        userRepository.save(user);
        List<User> users = userRepository.findAll();
        model.put("users", name);
        return new ModelAndView("main", model);
    }

//    @Autowired
//    private UserRepository userRepository;
//
//    @GetMapping("/")
//    public ResponseEntity<String> hello(){
//        return ResponseEntity.ok().body("Hello");
//    }
//
//    @GetMapping("/user/all")
//    public ResponseEntity<List<User>> all() {
//        return ResponseEntity.ok().body(userRepository.findAll());
//    }

//    @GetMapping("/user/{id}")
//    User userById(@PathVariable Long id) {
//        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
//                HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping("/user/save")
//    User save(@RequestBody User user) {
//        return userRepository.save(user);
//    }
}