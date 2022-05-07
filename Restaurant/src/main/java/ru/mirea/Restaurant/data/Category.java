package ru.mirea.Restaurant.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Entity
@Table(name = "categories")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue( strategy =
            GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "subsequence_number")
    private int subsequenceNumber;
    @Column(name = "image_link")
    private String imageLink;


    @JsonIgnore
    @OneToMany(mappedBy = "category")
    public List<Dish> dishes;



}
