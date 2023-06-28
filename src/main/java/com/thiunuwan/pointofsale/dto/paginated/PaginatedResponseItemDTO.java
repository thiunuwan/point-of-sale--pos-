package com.thiunuwan.pointofsale.dto.paginated;


import com.thiunuwan.pointofsale.dto.response.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {

    private List<ItemGetResponseDTO> list;
    private long dataCount;



}
