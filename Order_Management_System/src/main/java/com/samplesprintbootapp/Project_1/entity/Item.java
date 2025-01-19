package com.samplesprintbootapp.Project_1.entity;


import com.samplesprintbootapp.Project_1.entity.enums.MeasureType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Item")
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class Item {

    @Id
    @Column(name="item_id",length=30)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name="item_name",length =50,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name="measure_type",length = 40,nullable = false)
    private MeasureType measureType;

    @Column(name="balance_qty",length = 40,nullable = false)
    private double qty;

    @Column(name="supplier_price",length = 40,nullable = false)
    private double supplierPrice;

    @Column(name="selling_price",length = 40,nullable = false)
    private double sellingPrice;

    @Column(name="active_state",columnDefinition = "TINYINT default 0")
    private boolean active;
}
