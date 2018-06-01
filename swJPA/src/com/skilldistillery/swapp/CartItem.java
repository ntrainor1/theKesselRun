package com.skilldistillery.swapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cart_item")
public class CartItem {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@JoinColumn(name = "item_id")
	private Item item;

	
	// Gets and Sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	public CartItem() {};
	public CartItem(int id, Cart cart, Item item) {
		super();
		this.id = id;
		this.cart = cart;
		this.item = item;
	}

	// HashCode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + id;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (id != other.id)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", cart=" + cart.getId() + ", item=" + item.getId() + "]";
	}
	
	
	
}
