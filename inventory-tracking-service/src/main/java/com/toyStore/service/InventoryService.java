package com.toyStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyStore.model.InventoryItem;
import com.toyStore.repository.InventoryRepository;

@Service
public class InventoryService {

	 @Autowired
	    private InventoryRepository inventoryRepository;

	    public InventoryItem getInventoryItem(Long itemId) {
	        return inventoryRepository.findById(itemId).orElse(null);
	    }
	    
	    public List<InventoryItem> getAllInventoryItems() {
	        return inventoryRepository.findAll();
	    }


	    public InventoryItem createInventoryItem(InventoryItem newItem) {
	        return inventoryRepository.save(newItem);
	    }

	    public InventoryItem updateInventoryItem(Long itemId, InventoryItem updatedItem) {
	        InventoryItem existingItem = inventoryRepository.findById(itemId).orElse(null);
	        if (existingItem != null) {
	            existingItem.setName(updatedItem.getName());
	            existingItem.setQuantity(updatedItem.getQuantity());
	            return inventoryRepository.save(existingItem);
	        }
	        return null;
	    }

	    public boolean deleteInventoryItem(Long itemId) {
	        if (inventoryRepository.existsById(itemId)) {
	            inventoryRepository.deleteById(itemId);
	            return true;
	        }
	        return false;
	    }

		

}
