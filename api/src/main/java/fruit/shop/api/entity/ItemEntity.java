package fruit.shop.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class ItemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private long idItem;

    @Column(unique = true)
    private String name;

    @Column
    private int quantity;

    @Column
    private double price;

}
