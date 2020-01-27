package com.bt.itemmgmt.dao;

import com.bt.itemmgmt.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryItemDaoImpl implements ItemDao {

    private List<Item> itemlist = new ArrayList<>();

    @Override
    public Item save(Item item) {
        item.setItemId((long) Math.ceil(Math.random()*1000));
        this.itemlist.add(item);
        return item;
    }

    @Override
    public List<Item> listAll() {
        return this.itemlist;
    }

    @Override
    public Optional<Item> findById(long itemId) {
        Optional<Item> optionalItem = this.itemlist
                                        .stream()
                                        .filter(item -> item.getItemId() == itemId)
                                        .findFirst();
        return optionalItem;
    }

    @Override
    public Item update(long itemId, Item item) {
        Optional<Item> optionalItem = findById(itemId);
        optionalItem.ifPresent(item1 -> {
            int index = this.itemlist.indexOf(item1);
            this.itemlist.add(index, item);
        } );
        return item;
    }

    @Override
    public void deleteItemById(long itemId) {
       this.itemlist.removeIf(item -> item.getItemId() == itemId);
    }
}