package com.samplesprintbootapp.Project_1.service.impl;

import com.samplesprintbootapp.Project_1.dto.paginated.ItemPaginatedResponseDto;
import com.samplesprintbootapp.Project_1.dto.request.ItemSaveRequestDTO;
import com.samplesprintbootapp.Project_1.entity.Item;
import com.samplesprintbootapp.Project_1.exception.NotFoundexception;
import com.samplesprintbootapp.Project_1.repo.ItemRepo;
import com.samplesprintbootapp.Project_1.service.ItemService;
import com.samplesprintbootapp.Project_1.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;


@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
//        Item item = new Item(
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasureType(),
//                itemSaveRequestDTO.getQty(),
//                itemSaveRequestDTO.getSupplierPrice(),
//                itemSaveRequestDTO.getSellingPrice()
//        );
//        itemRepo.save(item);
//        return "Item saved successfully";


        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return "Item Saved";
        }
        else{
            return "Item Already Exists";
        }
    }

    @Override
    public List<ItemSaveRequestDTO> getByName(String name) {
        List<Item> items=itemRepo.findAllByItemNameEqualsAndActiveEquals(name,true);
        if(items.size()>0){
            List<ItemSaveRequestDTO> itemSaveRequestDTOS=modelMapper.map(items,new TypeToken<List <ItemSaveRequestDTO>>(){}.getType());
            return itemSaveRequestDTOS;
        }
        else{
            return null;
        }
    }

    @Override
    public List<ItemSaveRequestDTO> getByNameByMapstruct(String name) {
        return List.of();
    }

    @Override
    public List<ItemSaveRequestDTO> getByNameByMapstruct(String name, int page, int size) {
        List<Item> items=itemRepo.findAllByItemNameEqualsAndActiveEquals(name,true);
        if(items.size()>0){
            List<ItemSaveRequestDTO> itemSaveRequestDTOS=itemMapper.entityListToDtoList(items);
            return itemSaveRequestDTOS;
        }
        else{
            throw new NotFoundexception("Item Not Found");
        }
    }

    @Override
    public List<ItemSaveRequestDTO> getByActiveStatus(boolean active) {
        List<Item> items=itemRepo.findAllByActiveEquals(active);
        if(items.size()>0){
            List<ItemSaveRequestDTO> itemSaveRequestDTOS=itemMapper.entityListToDtoList(items);
            return itemSaveRequestDTOS;
        }
        else{
            throw new NotFoundexception("Item Not Found");
        }
    }

    @Override
    public ItemPaginatedResponseDto getByActiveStatusWithpaginated(boolean active, int page, int size) {
        Page<Item> items =itemRepo.findAllByActiveEquals(active, PageRequest.of(page,size));
        if(items.getSize()>0){
            ItemPaginatedResponseDto responseDto=new ItemPaginatedResponseDto(
                    itemMapper.listDtoToPage(items),2
            );
            return responseDto;
        }
        else{
            throw new NotFoundexception("Item Not Found");
        }
    }

    @Override
    public ItemPaginatedResponseDto getAllActiveItemPaiginated(int page, int size, boolean active) {
        Page<Item> items =itemRepo.findAllByActiveEquals(PageRequest.of(page,size),active);
        if(items.getSize()>0){
            ItemPaginatedResponseDto responseDto=new ItemPaginatedResponseDto(
                    itemMapper.listDtoToPage(items),2
                    );
            return responseDto;
        }
        else{
            throw new NotFoundexception("Item Not Found");
        }
    }
}
