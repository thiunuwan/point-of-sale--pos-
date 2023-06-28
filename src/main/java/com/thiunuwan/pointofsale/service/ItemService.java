package com.thiunuwan.pointofsale.service;


import com.thiunuwan.pointofsale.dto.ItemDTO;
import com.thiunuwan.pointofsale.dto.paginated.PaginatedResponseItemDTO;
import com.thiunuwan.pointofsale.dto.request.ItemSaveRequestDTO;
import com.thiunuwan.pointofsale.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {

    String saveItem(ItemSaveRequestDTO itemDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String name);

    List<ItemGetResponseDTO> getItemByNameAndStatusUsingMapStruct(String name);


    PaginatedResponseItemDTO getAllItemsByActiveStatus(boolean activeStatus, int page, int size);
}
