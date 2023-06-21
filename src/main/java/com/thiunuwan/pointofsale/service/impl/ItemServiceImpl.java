package com.thiunuwan.pointofsale.service.impl;

import com.thiunuwan.pointofsale.dto.request.ItemSaveRequestDTO;
import com.thiunuwan.pointofsale.dto.response.ItemGetResponseDTO;
import com.thiunuwan.pointofsale.entity.Item;
import com.thiunuwan.pointofsale.repository.ItemRepository;
import com.thiunuwan.pointofsale.service.ItemService;
import com.thiunuwan.pointofsale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemDTO) {
        Item item =modelMapper.map(itemDTO,Item.class);

        if(!itemRepository.existsById(item.getItemId())){
            item.setActive(true);
            itemRepository.save(item);
            return "added";
        }else{
            throw new RuntimeException("error");
        }

    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String name) {
        List<Item> itemList=  itemRepository.findAllByItemNameEqualsAndActiveEquals(name,true);

        if(itemList.size()>0){
            List<ItemGetResponseDTO> responseDTOList =modelMapper.map(itemList,new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return responseDTOList;
        }
        else {
            throw new RuntimeException("error");
        }

//        List<ItemGetResponseDTO> responseDTOList =null;
//        for (Item item: itemList) {
//            responseDTOList.add(modelMapper.map(item, ItemGetResponseDTO.class));
//        }


    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusUsingMapStruct(String name) {
        List<Item> itemList=  itemRepository.findAllByItemNameEqualsAndActiveEquals(name,true);

        if(itemList.size()>0){
            List<ItemGetResponseDTO> responseDTOList =itemMapper.entityListToDTOList(itemList);
            return responseDTOList;
        }
        else {
            throw new RuntimeException("error");
        }
    }
}
