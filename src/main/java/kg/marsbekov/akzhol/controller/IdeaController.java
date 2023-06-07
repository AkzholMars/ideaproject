package kg.marsbekov.akzhol.controller;

import jakarta.validation.Valid;
import kg.marsbekov.akzhol.model.IdeaDto;
import kg.marsbekov.akzhol.service.IdeaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ideas")
@RequiredArgsConstructor
public class IdeaController {

    private final IdeaService ideaService;

    @PostMapping
    public ResponseEntity<?> saveIdea(@Valid @RequestBody IdeaDto body) {
        ideaService.saveIdea(body);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<?> getAllIdeas() {
        return new ResponseEntity<>(ideaService.getAllIdeas(),HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteIdea(@RequestParam Long id) {
        ideaService.deleteIdea(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
