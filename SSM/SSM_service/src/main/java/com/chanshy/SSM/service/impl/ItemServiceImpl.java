package com.chanshy.SSM.service.impl;

import com.chanshy.SSM.dao.IItemDao;
import com.chanshy.SSM.domain.Item;
import com.chanshy.SSM.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements IItemService {

    @Autowired
    private IItemDao itemDao;

    @Override
    public List<Item> findAll() throws Exception {
        return itemDao.findAll();
    }

    @Override
    public void save(Item item) throws Exception {
        itemDao.save(item);
    }

    @Override
    public void alter(Item item) throws Exception {
        itemDao.alter(item);
    }

    @Override
    public Item findItem(int id) throws Exception {
        return itemDao.findItem(id);
    }

    @Override
    public void deleteUser(Integer id) {
        itemDao.deleteItem(id);
    }
}
