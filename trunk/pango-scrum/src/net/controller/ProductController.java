package net.controller;

import net.models.Product;

public class ProductController {
	// produit sélectionné
	private static Product selectedProduct;

	public static Product getSelectedProduct() {
		return selectedProduct;
	}

	public static void setSelectedProduct(Product selectedProduct) {
		ProductController.selectedProduct = selectedProduct;
	}



}
