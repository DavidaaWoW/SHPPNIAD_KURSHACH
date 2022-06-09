package ru.mirea.Restaurant.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.Restaurant.data.Category;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    DishRepo dishRepo;

    @CrossOrigin
    @GetMapping("/category/{id}")
    public @ResponseBody Iterable<Category> getCategory(@PathVariable("id") String id){
        return categoryRepo.findById(Integer.parseInt(id));
    }

    @CrossOrigin
    @GetMapping("/category/all")
    public @ResponseBody Iterable<Category> getCategoryAll(){
        return categoryRepo.categoryFindAll();
    }

    @CrossOrigin
    @GetMapping("/dish/{id}/category")
    public @ResponseBody Iterable<Category> getCategoryFromDish(@PathVariable("id") String id){
        return categoryRepo.categoryFindFromDish(Integer.parseInt(id));
    }
}
