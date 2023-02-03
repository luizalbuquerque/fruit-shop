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
@Table(name = "receipt")
public class ReceiptEntity implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_receipt")
        private Long idReceipt;

        @ManyToOne
        @JoinColumn(name = "id_item")
        private ItemEntity itemEntity;

        @ManyToOne
        @JoinColumn(name = "id_offer)")
        private OfferEntity offerEntity;

        @Column
        private double price;
}
