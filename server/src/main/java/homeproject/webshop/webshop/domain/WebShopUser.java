package homeproject.webshop.webshop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "web_shop_user")
@Data
public class WebShopUser {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String zipCode;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String houseNumber;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;
}
