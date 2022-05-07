package ru.mirea.Restaurant.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.Restaurant.data.Category;

import java.util.List;

@ResponseBody
public interface CategoryRepo extends CrudRepository <Category, Long> {
    @Query(value = "select * from categories where id = ?1", nativeQuery = true)
    List<Category> findById(int id);
    @Query(value = "select * from categories", nativeQuery = true)
    List<Category> categoryFindAll();
    @Query(value = "select * from categories where id = (select category_id from dishes where id = ?1)", nativeQuery = true)
    List<Category> categoryFindFromDish(int id);
}
