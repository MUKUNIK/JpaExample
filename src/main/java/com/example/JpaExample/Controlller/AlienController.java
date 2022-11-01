package com.example.JpaExample.Controlller;

import com.example.JpaExample.Dao.Repo;
import com.example.JpaExample.Model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController//No need to add response body now.
public class AlienController {

    @Autowired
    Repo repo;

    @RequestMapping("/")
    public String home()
    {
        System.out.println("hi");
        return "home.jsp";
    }

  /*  @RequestMapping("/addAlien")
    public String addAlien(Alien alien)
    {
        repo.save(alien);
        return "home.jsp";
    }*/

    //@PostMapping("/aliens")
    @PostMapping(path = "/aliens", consumes = {"application/json"})
    public Alien addAlien(@RequestBody Alien alien)
    {
        repo.save(alien);
        return  alien;
    }
  /*  @RequestMapping("/showData")
    public ModelAndView showData(@RequestParam int aid)
    {
        ModelAndView modelAndView = new ModelAndView("showData.jsp");
        Alien alien = repo.findById(aid).orElse(null);
      //  System.out.println(repo.findByAname("car"));
      //  System.out.println(repo.findbyAnameSorted("car"));
       modelAndView.addObject(alien);
        return modelAndView;
    }*/
    //@RequestMapping(path = "/aliens", produces =  "application/xml")
  @GetMapping("/aliens")
    //@ResponseBody
    public List<Alien> getAliens()
    {
        return  repo.findAll();
    }

    @RequestMapping("/aliens/{id}")
    @ResponseBody
    @Cacheable(cacheNames = "alien", key = "#id")
    public Optional<Alien> getAlien(@PathVariable int id)
    {
        return  repo.findById(id);
    }

    @DeleteMapping("/aliens/{id}")
    @CacheEvict(cacheNames = "alien", key = "#id")
    public String deleteAlien(@PathVariable int id)
    {
        Alien alien = repo.findById(id).orElse(null);
        repo.delete(alien);
        return "deleted";
    }
    @PutMapping("/aliens")
    @CachePut(cacheNames = "alien",key = "#alien.id")
    public String updateeAlien(@RequestBody Alien alien)
    {
        repo.save(alien);
        return "updated";
    }

}
