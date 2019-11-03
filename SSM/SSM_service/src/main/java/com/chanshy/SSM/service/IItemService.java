package com.chanshy.SSM.service;

import com.chanshy.SSM.domain.Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IItemService {
    public List<Item> findAll() throws Exception;

    void save(Item item) throws Exception;

    void alter(Item item) throws Exception;

    public Item findItem(int id) throws Exception;

    void deleteUser(Integer id);
}
