package com.thiunuwan.pointofsale.dto.response;


import com.thiunuwan.pointofsale.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponseDTO {

    private int itemId;

    private String itemName;

    private double qtyBalance;

    private double supplierPrice;

    private double sellingPrice;

    private boolean active;
}
