package com.thiunuwan.pointofsale.controller;


import com.thiunuwan.pointofsale.dto.paginated.PaginatedResponseItemDTO;
import com.thiunuwan.pointofsale.dto.request.ItemSaveRequestDTO;
import com.thiunuwan.pointofsale.dto.response.ItemGetResponseDTO;
import com.thiunuwan.pointofsale.service.ItemService;
import com.thiunuwan.pointofsale.util.StandardResponse;
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

//    @PostMapping("/save")
//    public String saveItem(@RequestBody ItemSaveRequestDTO itemDTO){
//
//        return itemService.saveItem(itemDTO);
//    }

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemDTO){

        String msg= itemService.saveItem(itemDTO);
        ResponseEntity<StandardResponse> responseEntity =new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Scuess",msg), HttpStatus.CREATED
        );
        return  responseEntity;
    }


    @GetMapping(value = "/active-item",params ="name")
    public List<ItemGetResponseDTO> getActiveItemByName(@RequestParam String name){

        return itemService.getItemByNameAndStatus(name);
    }

 @GetMapping(value = "/active-item/map-struct",params ="name")
    public List<ItemGetResponseDTO> getActiveItemByNameUsingMapStruct(@RequestParam String name){

        return itemService.getItemByNameAndStatusUsingMapStruct(name);
    }

 @GetMapping(value = "/get-all-items-by-status",params ={"activeStatus","page","size"})
    public ResponseEntity<StandardResponse> getAllItemsByActiveStatus(@RequestParam(value ="activeStatus") boolean activeStatus ,@RequestParam int page,@RequestParam int size){

       PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllItemsByActiveStatus(activeStatus,page,size);

       return new ResponseEntity<StandardResponse>(new StandardResponse(201,"Scuess",paginatedResponseItemDTO),HttpStatus.OK);
    }



}
