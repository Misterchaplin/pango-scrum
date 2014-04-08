package net.controller;

import net.models.Product;

public class ProductController {
	// produit sélectionné
	private Product selectedProduct = (Product) AppController.session.get(Product.class, 3);

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

}
