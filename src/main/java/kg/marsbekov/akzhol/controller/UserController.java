package kg.marsbekov.akzhol.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import kg.marsbekov.akzhol.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@NotBlank(message = "login.not.blank") @RequestParam(name = "login") String login,
                                        @RequestParam(name = "email") String eMail,
                                        @RequestParam(name = "lastname")  String lastName,
                                        @RequestParam(name = "firstname")  String firstName,
                                        @RequestParam(name = "birthDate")  LocalDate birthDate){
        userService.createUser(login, eMail, lastName, firstName, birthDate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getUser(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

}
  //  @RequestParam(name = "birth_date") LocalDateTime birthDate)