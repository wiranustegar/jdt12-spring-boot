package id.co.indivara.jdt12.hellorest.controller;

import id.co.indivara.jdt12.hellorest.model.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    //method yang akan berfungsi sebagai view

    @GetMapping("/salam")
    public Greeting ucapkanSalam(@RequestParam(value = "kode", defaultValue = "0") int id,
                                 @RequestParam(value = "nama", defaultValue = "Dunia") String name){
        return new Greeting(id,"Halo guys "+ name + " ini GET ");
    }

    @PostMapping("/salam")
    public Greeting salamPost (@RequestParam(value = "kode", defaultValue = "0") int id,
                               @RequestParam(value = "nama", defaultValue = "Default") String name) {
        return new Greeting(id,"Hallo guys " + name + " ini POST");
    }

    @PutMapping("/salam")
    public Greeting salamPut(@RequestParam(value = "kode", defaultValue = "0") int id,
                             @RequestParam(value = "nama", defaultValue = "Default") String name) {
        return new Greeting(id,"Hallo guys " + name + " ini PUT");
    }

    @PatchMapping("/salam")
    public Greeting salamPatch(@RequestParam(value = "kode", defaultValue = "0") int id,
                               @RequestParam(value = "nama", defaultValue = "Default") String name) {
        return new Greeting(id, "hallo guys " + name + " ini PATCH");
    }
    @DeleteMapping("/salam")
    public Greeting salamDelete(@RequestParam(value = "kode", defaultValue = "0") int id,
                               @RequestParam(value = "nama", defaultValue = "Default") String name) {
        return new Greeting(id, "hallo guys " + name + " ini DELETE");
    }
}
