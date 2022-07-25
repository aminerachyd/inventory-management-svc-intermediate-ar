package com.ibm.inventory_management.services;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ibm.inventory_management.models.StockItem;

@Service
public class StockItemService implements StockItemApi {
    static int id = 0;
    static List<StockItem> stockItems = new ArrayList<>(asList(
            new StockItem(++id+"")
                    .withName("Item 1")
                    .withStock(100)
                    .withPrice(10.5)
                    .withManufacturer("Sony"),
            new StockItem(++id+"")
                    .withName("Item 2")
                    .withStock(150)
                    .withPrice(100.5)
                    .withManufacturer("Insignia"),
            new StockItem(++id+"")
                    .withName("Item 3")
                    .withStock(10)
                    .withPrice(1000.0)
                    .withManufacturer("Panasonic")
    ));

    @Override
    public List<StockItem> listStockItems() {
      return this.stockItems;
    }

    @Override
    public void addStockItem(String name, String manufacturer, double price, int stock) {
        this.stockItems.add(new StockItem(++id+"")
                .withName(name)
                .withStock(stock)
                .withPrice(price)
                .withManufacturer(manufacturer)
        );
    }

    @Override
    public void updateStockItem(String id, String name, String manufacturer, Double price, Integer stock) {
       StockItem itemToUpdate = this.stockItems.stream().filter(stockItem -> stockItem.getId().equals(id)).findFirst().orElse(null);

       if(itemToUpdate == null) {
           System.out.println("Item not found");
           return;
       }

       itemToUpdate.setName(name !=null ? name : itemToUpdate.getName());
       itemToUpdate.setManufacturer(manufacturer != null ? manufacturer : itemToUpdate.getManufacturer());
       itemToUpdate.setPrice(price != null ? price : itemToUpdate.getPrice());
       itemToUpdate.setStock(stock != null ? stock : itemToUpdate.getStock());
    }

    @Override
    public void deleteStockItem(String id) {
        this.stockItems = this.stockItems.stream().filter((stockItem)-> !stockItem.getId().equals(id)).collect(Collectors.toList());
    }
}
