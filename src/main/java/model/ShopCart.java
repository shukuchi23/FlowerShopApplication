package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
public class ShopCart {
      @Id
      @GeneratedValue(strategy = GenerationType.SEQUENCE)
      @Column
      private Integer id;


      @Column
      private  Integer amount;

      @PrePersist
      public void toCreate() { setCreate_date(LocalDateTime.now());}

      public void setCreate_date(LocalDateTime date) {}
}
