package ru.mirea.Restaurant.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.Restaurant.data.Dish;

import java.util.List;

@Repository
public interface DishRepo extends CrudRepository <Dish, Long> {
    @Query(value = "select * from dishes where id = ?1", nativeQuery = true)
    List<Dish> findById(int id);
    @Query(value = "select * from dishes", nativeQuery = true)
    List<Dish> dishFindAll();
    @Query(value = "select * from dishes where category_id = ?1", nativeQuery = true)
    List<Dish> dishFindAllFromCategory(int id);
    @Query(value = "select * from dishes where category_id = ?1 and subsequence_number = ?2", nativeQuery = true)
    List<Dish> dishFindFromCategoryWithSubsequenceNumber(int id, int subsequence_number);

}
