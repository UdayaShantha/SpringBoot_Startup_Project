package com.samplesprintbootapp.Project_1.controller;


import com.samplesprintbootapp.Project_1.dto.CustomerDTO;
import com.samplesprintbootapp.Project_1.dto.paginated.ItemPaginatedResponseDto;
import com.samplesprintbootapp.Project_1.dto.request.ItemSaveRequestDTO;
import com.samplesprintbootapp.Project_1.service.ItemService;
import com.samplesprintbootapp.Project_1.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

//    @PostMapping(path={"/save"})
//    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
//        String msg=itemService.saveItem(itemSaveRequestDTO);
//        return msg;
//    }

    @PostMapping(path = {"/save"})
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String msg = itemService.saveItem(itemSaveRequestDTO);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", msg), HttpStatus.CREATED
        );
        return response;
    }

//    @GetMapping(path="getByName", params="name")
//    public List<ItemSaveRequestDTO> getByName(@RequestParam(value="name") String name){
//        List<ItemSaveRequestDTO> itemSaveRequestDTOS=itemService.getByName(name);
//        return itemSaveRequestDTOS;
//    }

    @GetMapping(path = "getByName", params = "name")
    public ResponseEntity<StandardResponse> getByName(@RequestParam(value = "name") String name) {
        List<ItemSaveRequestDTO> itemSaveRequestDTOS = itemService.getByName(name);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", itemSaveRequestDTOS), HttpStatus.OK
        );
    }

//    @GetMapping(path="getByNameByMapsruct", params="name")
//    public List<ItemSaveRequestDTO> getByNameByMapstruct(@RequestParam(value="name") String name){
//        List<ItemSaveRequestDTO> itemSaveRequestDTOS=itemService.getByNameByMapstruct(name);
//        return itemSaveRequestDTOS;
//    }

    @GetMapping(path = "getByNameByMapsruct", params = "name")
    public ResponseEntity<StandardResponse> getByNameByMapstruct(@RequestParam(value = "name") String name) {
        List<ItemSaveRequestDTO> itemSaveRequestDTOS = itemService.getByNameByMapstruct(name);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", itemSaveRequestDTOS), HttpStatus.OK
        );
    }

    @GetMapping(path = "getByActiveStatus", params = {"active","page","size"})
    public ResponseEntity<StandardResponse> getByActiveStatus(@RequestParam(value = "active") boolean active,
                                                              @RequestParam(value = "page") int page,
                                                              @RequestParam(value = "size") int size
                                                             )
    {
//        List<ItemSaveRequestDTO> itemSaveRequestDTOS = itemService.getByActiveStatus(active);
        ItemPaginatedResponseDto itemPaginatedResponseDto=itemService.getByActiveStatusWithpaginated(active,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", itemPaginatedResponseDto), HttpStatus.OK
        );
    }


    @GetMapping(path = "get-all-items-paignated", params = {"page","size","active"})
    public ResponseEntity<StandardResponse> getAllActiveItemPaiginated(@RequestParam(value = "page") int page,
                                                              @RequestParam(value = "size") int size,
                                                              @RequestParam(value = "active") boolean active
                                                              )
    {
        ItemPaginatedResponseDto itemPaginatedResponseDto=itemService.getAllActiveItemPaiginated(page,size,active);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", itemPaginatedResponseDto), HttpStatus.OK
        );
    }

}

