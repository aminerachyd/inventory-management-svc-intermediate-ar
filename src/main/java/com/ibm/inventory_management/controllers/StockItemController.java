package com.ibm.inventory_management.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.ibm.inventory_management.models.StockItem;
import com.ibm.inventory_management.services.StockItemApi;

@RestController
public class StockItemController {

  private final StockItemApi service;

  public StockItemController(StockItemApi service) {
    this.service = service;
  }

  @GetMapping(path = "/stock-items", produces = "application/json")
  public List<StockItem> listStockItems() {
    return this.service.listStockItems();
  }

  @PostMapping(path = "/stock-item")
  public void addStockItem(@RequestParam String name, @RequestParam String manufacturer, @RequestParam float price, @RequestParam int stock) {
    this.service.addStockItem(name,manufacturer,price,stock);
  }

  @PutMapping(path = "/stock-item/{id}")
  public void updateStockItem(@PathVariable("id") String id, @RequestParam(required=false) String name, @RequestParam(required=false) String manufacturer, @RequestParam(required=false) Double price, @RequestParam(required=false) Integer stock) {
    this.service.updateStockItem(id,name,manufacturer,price,stock);
  }

  @DeleteMapping(path = "/stock-item/{id}")
  public void deleteStockItem(@PathVariable("id") String id){
    this.service.deleteStockItem(id);
  }
}
