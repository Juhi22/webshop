package homeproject.webshop.webshop.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "web_shop_user")
@Data
public class WebShopUser {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column
    private String password;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;
}
