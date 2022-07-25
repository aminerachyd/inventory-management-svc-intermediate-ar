package com.ibm.inventory_management.services;

import java.util.List;

import com.ibm.inventory_management.models.StockItem;

public interface StockItemApi {
  List<StockItem> listStockItems();

  void addStockItem(String name, String manufacturer, double price, int stock);

  void updateStockItem(String id, String name, String manufacturer, Double price, Integer stock);

  void deleteStockItem(String id);
}
