package com.bt.itemmgmt.controller;

import com.bt.itemmgmt.model.Item;
import com.bt.itemmgmt.service.ItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StandaloneClient {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application-context.xml");

      /*  Item item = new Item();
        item.setItemName("Lenovo ThinkPad T580T");
        item.setPrice(2_00_000);
        item.setDescription("Latest model from ThinkPad");
*/
        Item item = Item.builder()
                .itemName("Lenovo ThinkPad T580T")
                .price(2_00_000)
                .description("Latest model from ThinkPad")
                .build();
        ItemService itemService = applicationContext.getBean("itemService", ItemService.class);

        Item savedItem = itemService.save(item);

        System.out.println("Saved Item >> "+savedItem);

        ((AbstractApplicationContext)applicationContext).registerShutdownHook();
    }
}