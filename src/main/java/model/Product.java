package model;

import javax.persistence.*;
import java.math.BigDecimal;

// товар
@Entity
@Table(name = "product")
public class Product {
      public Product() { }

      public Product(String name, String description, BigDecimal price, String category) {
            this.name = name;
            this.description = description;
            this.price = price;
            this.category = category;
      }

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;

      @Column(name = "prod_name")
      private String name;

      @Column
      private String description;
      @Column
      private BigDecimal price;
      @Column
      private String category;


      public String getName() {return name;}

      //      id_category
}
