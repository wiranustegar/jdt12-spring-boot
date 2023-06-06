package id.co.indivara.jdt12.manytoone.controller;

import id.co.indivara.jdt12.manytoone.entity.Comment;
import id.co.indivara.jdt12.manytoone.exception.NotFoundException;
import id.co.indivara.jdt12.manytoone.repo.CommentRepository;
import id.co.indivara.jdt12.manytoone.repo.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private TutorialRepository tutorialRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/tutorials/{tutorialId}/comment")
    public ResponseEntity<List<Comment>> getAllCommentByTutorialId(@PathVariable("tutorialId") Long tutorialId){
        if (!tutorialRepository.existsById(tutorialId)){
            throw new NotFoundException("Tutorial with id " + tutorialId + " not found");
        }

        List<Comment> comments = commentRepository.findByTutorialId(tutorialId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/tutorials/{tutorialId}/comment")
    public ResponseEntity<Comment> createComment(@PathVariable("tutorialId") Long tutorialId, @RequestBody Comment commentRequest){
        Comment comment = tutorialRepository.findById(tutorialId).map(tutorial -> {
            commentRequest.setTutorial(tutorial);

            return commentRepository.save(commentRequest);
        } ).orElseThrow(()-> new NotFoundException("Tutorial id " + tutorialId + " not found"));

        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") Long id){
        commentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/tutorials/{tutorialId}/comments")
    public ResponseEntity<List<Comment>> deleteAllCommentsOfTutorial(@PathVariable("tutorialId")  Long tutorialId) {
        if (!tutorialRepository.existsById(tutorialId)){
            throw new NotFoundException("Tutorial id " + tutorialId + " not found");
        }

        commentRepository.deleteByTutorialId(tutorialId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
