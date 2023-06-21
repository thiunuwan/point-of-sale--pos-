package com.thiunuwan.pointofsale.dto.request;

import com.thiunuwan.pointofsale.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSaveRequestDTO {

    private String itemName;

    private MeasuringUnitType measuringUnitType;

    private double qtyBalance;

    private double supplierPrice;

    private double sellingPrice;

}
