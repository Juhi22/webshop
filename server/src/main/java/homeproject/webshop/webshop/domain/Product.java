package homeproject.webshop.webshop.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @ElementCollection(targetClass = String.class)
    private List<String> comments;

    @ManyToMany(mappedBy = "products")
    Set<Cart> carts;
}
