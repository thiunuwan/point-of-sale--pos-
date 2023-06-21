package com.thiunuwan.pointofsale.entity;

import com.thiunuwan.pointofsale.entity.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;



@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length =50,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",length = 50,nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty",length = 50,nullable = false)
    private double qtyBalance;

    @Column(name = "supplier_price",length = 50,nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price",length = 50,nullable = false)
    private double sellingPrice;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean active;

}
