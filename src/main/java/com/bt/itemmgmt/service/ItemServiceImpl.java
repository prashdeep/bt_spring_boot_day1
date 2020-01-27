package com.bt.itemmgmt.service;

import com.bt.itemmgmt.dao.ItemDao;
import com.bt.itemmgmt.model.Item;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    private final ItemDao itemDAO;

    public ItemServiceImpl(ItemDao itemDao){
        this.itemDAO = itemDao;
    }

    @Override
    public Item save(Item item) {
        return this.itemDAO.save(item);
    }

    @Override
    public List<Item> listAll() {
        return this.itemDAO.listAll();
    }

    @Override
    public Item findById(long itemId) {
        return this.itemDAO.findById(itemId).orElseThrow(() -> new IllegalArgumentException("Item not found"));
    }

    @Override
    public Item update(long itemId, Item item) {
        return this.itemDAO.update(itemId, item);
    }

    @Override
    public void deleteItemById(long itemId) {
        this.itemDAO.deleteItemById(itemId);
    }
}