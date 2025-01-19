package com.samplesprintbootapp.Project_1.dto.paginated;

import com.samplesprintbootapp.Project_1.dto.request.ItemSaveRequestDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ItemPaginatedResponseDto {

    List<ItemSaveRequestDTO> itemSaveRequestDTOS;
    private long totalItems;
}
