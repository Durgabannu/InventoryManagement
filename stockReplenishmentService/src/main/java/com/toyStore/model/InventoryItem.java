package com.toyStore.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InventoryItem {

			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
		    private String name;
		    private int quantity;
			public InventoryItem() {
				super();
			}
			public InventoryItem(Long id, String name, int quantity) {
				super();
				this.id = id;
				this.name = name;
				this.quantity = quantity;
			}
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getQuantity() {
				return quantity;
			}
			public void setQuantity(int quantity) {
				this.quantity = quantity;
			}
		    

		}

