package ru.mirea.Restaurant.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.Restaurant.data.Category;
import ru.mirea.Restaurant.data.Dish;

@RestController
public class DishController {
    @Autowired
    private DishRepo dishRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @CrossOrigin
    @GetMapping("/dish/{id}")
    public @ResponseBody Iterable<Dish> getDish(@PathVariable("id") String id){
        return dishRepo.findById(Integer.parseInt(id));
    }

    @CrossOrigin
    @GetMapping("/dish/all")
    public @ResponseBody Iterable<Dish> getDishAll(){
        return dishRepo.dishFindAll();
    }

    @CrossOrigin
    @GetMapping("/category/{category_id}/all")
    public @ResponseBody Iterable<Dish> getDishAllFromCategory(@PathVariable("category_id") String category_id){
        return dishRepo.dishFindAllFromCategory(Integer.parseInt(category_id));
    }

    @CrossOrigin
    @GetMapping("/category/{category_id}/{dish_number}")
    public @ResponseBody Iterable<Dish> getDishFromCategoryWithSubsequenceNumber(@PathVariable("category_id") String category_id, @PathVariable("dish_number") String subsequence_number){
        return dishRepo.dishFindFromCategoryWithSubsequenceNumber(Integer.parseInt(category_id), Integer.parseInt(subsequence_number));
    }
}
