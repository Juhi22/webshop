package homeproject.webshop.webshop.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role_name")
    private Roles roleName;

    @ManyToMany(mappedBy = "roles")
    Set<WebShopUser> webShopUsers;

}
