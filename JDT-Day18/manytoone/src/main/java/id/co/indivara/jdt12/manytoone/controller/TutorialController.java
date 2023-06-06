package id.co.indivara.jdt12.manytoone.controller;

import id.co.indivara.jdt12.manytoone.entity.Tutorial;
import id.co.indivara.jdt12.manytoone.exception.NotFoundException;
import id.co.indivara.jdt12.manytoone.repo.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class TutorialController {
    @Autowired
    private TutorialRepository tutorialRepository;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title){
        List<Tutorial> tutorials = new ArrayList<>();
        if (title == null){
            tutorialRepository.findAll().forEach(tutorials::add);
        } else {
            tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
        }

        if (tutorials.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }

    @GetMapping("tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") Long id){
        Tutorial tutorial = tutorialRepository.findById(id).orElseThrow(()->new NotFoundException("Tutorial with id " + id +" not found"));

        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
        Tutorial tutor = tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), tutorial.getPublished()));

        return new ResponseEntity<>(tutor, HttpStatus.CREATED);
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable Long id, @RequestBody Tutorial tutorial){
        Tutorial tutor = tutorialRepository.findById(id).orElseThrow(()-> new NotFoundException("Tutorial id " + id + " not found"));
        tutor.setTitle(tutorial.getTitle());
        tutor.setDescription(tutorial.getDescription());
        tutor.setPublished(tutorial.getPublished());

        return new ResponseEntity<>(tutorialRepository.save(tutor), HttpStatus.OK);
    }

    @DeleteMapping("tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Long id ){
        tutorialRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("tutorials-all")
    public ResponseEntity<HttpStatus> deleteAllTutorial(){
        tutorialRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished(){
        List<Tutorial> tutorials = tutorialRepository.findByPublished(true);
        if (tutorials.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }
}
