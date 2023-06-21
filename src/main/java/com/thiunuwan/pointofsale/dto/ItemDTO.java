package com.thiunuwan.pointofsale.dto;

import com.thiunuwan.pointofsale.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {

    private int itemId;

    private String itemName;

    private MeasuringUnitType measuringUnitType;

    private double qtyBalance;

    private double supplierPrice;

    private double sellingPrice;

    private boolean active;
}
