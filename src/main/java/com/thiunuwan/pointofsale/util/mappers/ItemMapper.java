package com.thiunuwan.pointofsale.util.mappers;


import com.thiunuwan.pointofsale.dto.response.ItemGetResponseDTO;
import com.thiunuwan.pointofsale.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<ItemGetResponseDTO> entityListToDTOList(List<Item> itemList);

}


//list<Item> --->List<ItemGetResponseDTO>