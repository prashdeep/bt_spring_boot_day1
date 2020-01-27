package com.bt.itemmgmt.service;

import com.bt.itemmgmt.dao.ItemDao;
import com.bt.itemmgmt.model.Item;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service("itemService")
//@Scope("singleton")
public class ItemServiceImpl implements ItemService {


    private final ItemDao itemDAO;

   /* public ItemServiceImpl(@Qualifier("inMemory") ItemDao itemDao){
        this.itemDAO = itemDao;
    }*/
   public ItemServiceImpl(ItemDao itemDao){
        this.itemDAO = itemDao;
   }

    @PostConstruct
    public void customInit(){
        System.out.println("Custom initialization method");
    }

    @PreDestroy
    public void customDestroy(){
        System.out.println("Custom destruction method");
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