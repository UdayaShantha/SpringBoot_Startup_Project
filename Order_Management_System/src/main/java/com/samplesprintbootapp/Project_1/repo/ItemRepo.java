package com.samplesprintbootapp.Project_1.repo;


import com.samplesprintbootapp.Project_1.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item, Integer> {


    List<Item> findAllByItemNameEqualsAndActiveEquals(String name, boolean b);

    List<Item> findAllByActiveEquals(boolean b);

    Page<Item> findAllByActiveEquals(boolean b, Pageable pageable);

    Page<Item> findAllByActiveEquals(PageRequest of,boolean active);
}
