package id.co.indivara.jpamysql.controller;

import id.co.indivara.jpamysql.entity.ResponseMessage;
import id.co.indivara.jpamysql.entity.User;
import id.co.indivara.jpamysql.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ResponseMessage createUser(@RequestBody User user){
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            userRepository.save(user);
            responseMessage.setCode(200);
            responseMessage.setMessage("INSERT SUCCESS");
        } catch (Exception ex){
            responseMessage.setCode(201);
            responseMessage.setMessage("INSERT FAILED " + ex.getMessage());
        }

        return responseMessage;
    }

    @PostMapping("/update")
    public ResponseMessage updateUser (@RequestBody User user) {
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            User c = (User) userRepository.findById(user.getId()).get();
            c.setName(user.getName());
            c.setEmail(user.getEmail());
            userRepository.save(c);
            responseMessage.setCode(200);
            responseMessage.setMessage("UPDATE SUCCESS");
        } catch (Exception ex){
            responseMessage.setCode(201);
            responseMessage.setMessage("INSER FAILED " + ex.getMessage());
        }

        return responseMessage;
    }

    @GetMapping("/find/{id}")
    public User findUserById (@PathVariable int id){
        return userRepository.findById(id).get();
    }


    @GetMapping("/all")
    public ArrayList<User> findAllUser(){
        return (ArrayList<User>)userRepository.findAll();
    }

    @GetMapping("/delete/{id}")
    public ResponseMessage deleteUserById(@PathVariable int id){
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            userRepository.deleteById(id);
            responseMessage.setCode(200);
            responseMessage.setMessage("DELETE SUCCESS");
        } catch (Exception ex){
            responseMessage.setCode(201);
            responseMessage.setMessage("DELETE FAILED " + ex.getMessage());
        }

        return responseMessage;
    }

    @GetMapping("/findname")
    public ArrayList<User> findUserByName(@RequestParam String name){
        ArrayList<User> users=(ArrayList<User>) userRepository.findByName(name);
        return users;
    }

    @GetMapping("/deleteemail/{email}")
    public ResponseMessage deleteUserByEmail(@PathVariable String email){
        ResponseMessage responseMessage=new ResponseMessage();
        try{
            userRepository.deleteByEmail(email);
            responseMessage.setCode(200);
            responseMessage.setMessage("DELETE BERHASIL");
        }catch (Exception ex){
            responseMessage.setCode(201);
            responseMessage.setMessage("DELETE GAGAL "+ex.getMessage());
        }
        return responseMessage;
    }


}
