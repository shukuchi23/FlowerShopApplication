package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "account")
public class User {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;

      @Column
      private String username;
      @Column
      private String password;
      @Transient
      private transient String confirmPassword;

      @ManyToMany
      @JoinTable(name = "account_roles", joinColumns = @JoinColumn(name = "id_user"),
       inverseJoinColumns = @JoinColumn(name = "id_role"))
      private Set<Role> roles;

      @ManyToMany
      @JoinTable(name = "cart", joinColumns = @JoinColumn(name = "id_product"),
       inverseJoinColumns = @JoinColumn(name = "id_account"))
      private Set<BuyItem> buyItems;

      public User() {
      }

}
