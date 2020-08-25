package model;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
      public String getRole() {
            return role;
      }

      public void setRole(String role) {
            this.role = role;
      }

      //      @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "toy_shop.roles_id_seq")

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "toy_shop.roles_id_seq")
      private Integer id;
      @Column
      private String role;

      @ManyToMany(mappedBy = "roles")
      private Set<User> users;

      public Role(){}

      public Integer getId() {
            return id;
      }

      public Set<User> getUsers() {
            return users;
      }

      public void setUsers(Set<User> users) {
            this.users = users;
      }

      @Override
      public String toString() {
            return "Role{" +
             "role='" + role + '\'' +
             '}';
      }
}
