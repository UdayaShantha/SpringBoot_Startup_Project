package com.samplesprintbootapp.Project_1.util.mappers;

import com.samplesprintbootapp.Project_1.dto.request.ItemSaveRequestDTO;
import com.samplesprintbootapp.Project_1.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<ItemSaveRequestDTO> entityListToDtoList(List<Item> items);

    List<ItemSaveRequestDTO> listDtoToPage(Page<Item> items);
}
