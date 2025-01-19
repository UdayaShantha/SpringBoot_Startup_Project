package com.samplesprintbootapp.Project_1.service;


import com.samplesprintbootapp.Project_1.dto.paginated.ItemPaginatedResponseDto;
import com.samplesprintbootapp.Project_1.dto.request.ItemSaveRequestDTO;

import java.util.List;


public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemSaveRequestDTO> getByName(String name);

    List<ItemSaveRequestDTO> getByNameByMapstruct(String name);

    List<ItemSaveRequestDTO> getByNameByMapstruct(String name, int page, int size);

    List<ItemSaveRequestDTO> getByActiveStatus(boolean active);

    ItemPaginatedResponseDto getByActiveStatusWithpaginated(boolean active, int page, int size);

    ItemPaginatedResponseDto getAllActiveItemPaiginated(int page, int size, boolean active);
}
