package com.bt.itemmgmt.dao;

import com.bt.itemmgmt.model.Item;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("h2DAO")
@Profile("dev")
public class H2DaoImpl implements ItemDao {

    @Override
    public Item save(Item item) {
        return null;
    }

    @Override
    public List<Item> listAll() {
        return null;
    }

    @Override
    public Optional<Item> findById(long itemId) {
        return Optional.empty();
    }

    @Override
    public Item update(long itemId, Item item) {
        return null;
    }

    @Override
    public void deleteItemById(long itemId) {

    }
}