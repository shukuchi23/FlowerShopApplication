package model;

import javax.persistence.*;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "storage")
public class Storage {

      public Storage() {
      }

      @Id
      @Column
      private Integer id_prod;

      @ElementCollection
      @MapKeyColumn(name = "id_prod")
      @Column(name = "amount")
      @CollectionTable (name = "storage", joinColumns = @JoinColumn(name = "id_prod"))
      private Map<Product, Integer> prod_amount = new HashMap<>();

      public Map<Product, Integer> getProd_amount() {
            return prod_amount;
      }

      public void setProd_amount(Map<Product, Integer> prod_amount) {
            this.prod_amount = prod_amount;
      }

      @Override
      public String toString(){
            StringBuilder s = new StringBuilder("");
            Formatter f = new Formatter();

            for (Map.Entry<Product, Integer> e : prod_amount.entrySet()) {
                  s.append( f.format("{%s : %d}\n", e.getKey().getName(), e.getValue()));
            }
            return s.toString();
      }
      /*Нам нужно указать Hibernate, где взять ключ и значение.
            В качестве ключа мы использовали @MapKeyColumn,
             указывая, что ключом Map является столбец item_name
             нашей таблицы соединения, order_item_mapping.
             Точно так же @Column указывает, что значение карты соответствует столбцу цены объединенной таблицы.

      Кроме того, объект itemPriceMap представляет собой карту типов значений,
      поэтому мы должны использовать аннотацию @ElementCollection.

      В дополнение к объектам базового типа значения, объекты @Embeddable также могут использоваться в качестве значений Map аналогичным образом.*/
}
