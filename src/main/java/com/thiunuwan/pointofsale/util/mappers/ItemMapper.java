package com.thiunuwan.pointofsale.util.mappers;


import com.thiunuwan.pointofsale.dto.paginated.PaginatedResponseItemDTO;
import com.thiunuwan.pointofsale.dto.response.ItemGetResponseDTO;
import com.thiunuwan.pointofsale.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<ItemGetResponseDTO> entityListToDTOList(List<Item> itemList);
    List<ItemGetResponseDTO> entityPageToResponseDTOList(Page<Item> itemPage);

}


//list<Item> --->List<ItemGetResponseDTO>