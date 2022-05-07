package ru.mirea.Restaurant.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Entity
@Table(name = "dishes")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
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
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private float price;

    @JsonIgnore
    @ManyToOne
    public Category category;
}
