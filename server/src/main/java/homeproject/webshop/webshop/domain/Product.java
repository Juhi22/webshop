package homeproject.webshop.webshop.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private Integer quantity;

    @Column
    private ProductCategories category;

    @Column
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> ratings;

    @Column
    private Double rating;

    @Column
    @ElementCollection(targetClass = Comment.class)
    private List<Comment> comments;

    @Column
    private String description;

    @ManyToMany(mappedBy = "products")
    Set<Cart> carts;
}
