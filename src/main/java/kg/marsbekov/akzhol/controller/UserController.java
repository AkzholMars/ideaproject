package kg.marsbekov.akzhol.controller;



import kg.marsbekov.akzhol.dal.entity.UserEntity;
import kg.marsbekov.akzhol.dal.repository.UserRepository;
import kg.marsbekov.akzhol.model.UserDto;
import kg.marsbekov.akzhol.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/users/")
@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("loginForm", new UserEntity());
        return "index";
    }
    @PostMapping("/logger")
    public String loginUser(@ModelAttribute UserDto user, Model model) {
        model.addAttribute("loginForm", new UserEntity());
//        model.addAttribute("message", " you login");

        userService.createUser(user);
        return "add-user";
    }

    @GetMapping("/addForm")
    public String addUserForm(UserEntity model){
//        model.addAttribute("addUserForm", new UserEntity());
        return "add-user";
    }

//    @PostMapping()
//    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto body){
//        userService.createUser(body);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//    @GetMapping
//    public ResponseEntity<?> getUser(@RequestParam(name = "id") Long id) {
//        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
//    }

//    @DeleteMapping(value = "/delete/{str}")
//    public ResponseEntity<?> deleteUser(@RequestParam Long id) {
//        userService.deleteIdea(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}