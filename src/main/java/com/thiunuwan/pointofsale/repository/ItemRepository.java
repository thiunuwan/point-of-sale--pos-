package com.thiunuwan.pointofsale.repository;

import com.thiunuwan.pointofsale.dto.response.ItemGetResponseDTO;
import com.thiunuwan.pointofsale.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository  extends JpaRepository<Item,Integer> {



    List<Item> findAllByItemNameEqualsAndActiveEquals(String name, boolean b);


    Page<Item> findAllByActiveEquals(boolean activeStatus, Pageable pageable);
}
