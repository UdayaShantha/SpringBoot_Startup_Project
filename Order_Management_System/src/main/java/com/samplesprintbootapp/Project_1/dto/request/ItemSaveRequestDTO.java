package com.samplesprintbootapp.Project_1.dto.request;

import com.samplesprintbootapp.Project_1.entity.enums.MeasureType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSaveRequestDTO {

    private String itemName;
    private MeasureType measureType;
    private double qty;
    private double supplierPrice;
    private double sellingPrice;

}
