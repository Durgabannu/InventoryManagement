package com.toyStore.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class OrderItem {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long itemId;
	    private int quantity;
		public OrderItem() {
			super();
		}
		public OrderItem(Long itemId, int quantity) {
			super();
			this.itemId = itemId;
			this.quantity = quantity;
		}
		public Long getItemId() {
			return itemId;
		}
		public void setItemId(Long itemId) {
			this.itemId = itemId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	    
	    
	    
	}

