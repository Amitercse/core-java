package com.amit.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOperations {

	public static void main(String[] args) {
		int [] arr= {1,2,3,4};
		StreamOperations operations = new StreamOperations();
		Product product1 = new Product(1, "product 1", 100.5);
		Product product2 = new Product(2, "product 2", 160.5);
		Product product3 = new Product(3, "product 3", 250.5);
		Product product4 = new Product(4, "product 4", 220.5);
		List<Product> productList = new ArrayList<>();
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		Map<Integer, Product> map = new HashMap<>();
		map.put(product1.getProductId(), product1);
		map.put(product2.getProductId(), product2);
		map.put(product3.getProductId(), product3);
		map.put(product4.getProductId(), product4);
		operations.filterListAndPrint(productList);
		operations.filterListAndCount(productList);
		operations.filterMapAndPrint(map);
		operations.filterMapAndCount(map);
		operations.convertListToPriceList(productList);
		operations.convertMapToPriceList(map);
		operations.findMaxFromList(productList);
		operations.findMinFromList(productList);
		operations.priceSum(productList);
		operations.arrayToStream(arr);
		operations.convertListToMap(productList);
		operations.convertArrayToSet();
		operations.sortStream(productList);
	}

	private void filterListAndPrint(List<Product> productList) {
		productList.stream().filter(p -> p.getPrice() > 170).forEach(p -> System.out.println("product id: "
				+ p.getProductId() + ", description:" + p.getDescription() + ", price: " + p.getPrice()));
	}

	private void filterListAndCount(List<Product> productList) {
		long count = productList.stream().filter(p -> p.getPrice() < 200).count();
		System.out.println("total filtered elements from list: " + count);
	}

	private void filterMapAndPrint(Map<Integer, Product> productMap) {
		productMap.entrySet().stream().filter(entry -> entry.getValue().getPrice() > 170)
				.forEach(entry -> System.out.println("product id: " + entry.getValue().getProductId() + ", description:"
						+ entry.getValue().getDescription() + ", price: " + entry.getValue().getPrice()));
	}

	private void filterMapAndCount(Map<Integer, Product> productMap) {
		long count = productMap.entrySet().stream().filter(entry -> entry.getValue().getPrice() < 200).count();
		System.out.println("total filtered elements from map: " + count);
	}

	private void convertListToPriceList(List<Product> productList) {
		List<Double> priceList = productList.stream().map(Product::getPrice).collect(Collectors.toList());
		System.out.println(priceList);
	}

	private void convertMapToPriceList(Map<Integer, Product> productMap) {
		List<Double> priceList = productMap.entrySet().stream().map(entry -> entry.getValue().getPrice())
				.collect(Collectors.toList());
		System.out.println(priceList);
	}
	
	private void findMaxFromList(List<Product> productList)
	{
		Product product= productList.stream().max((p1, p2) -> p1.getPrice()> p2.getPrice()?1:-1).get();
		System.out.println("Product with max price: "+ product.getPrice());
	}
	
	private void findMinFromList(List<Product> productList)
	{
		Product product= productList.stream().min((p1, p2) -> p1.getPrice()> p2.getPrice()?1:-1).get();
		System.out.println("Product with min price: "+ product.getPrice());
	}
	
	private void priceSum(List<Product> productList)
	{
		double totalPrice= productList.stream().map(Product::getPrice).reduce(0.0,(sum,p) -> sum+p);
		System.out.println("total price: "+ totalPrice);
	}
	
	private void arrayToStream(int[] array)
	{
		Arrays.stream(array).forEach(System.out::println);
	}
	
	private void convertArrayToSet() {
		int[] arr = { 1, 2, 3, 4, 5 };
		/*
		 * Primitive stream can't be converted to object stream. Here stream of integer
		 * array will return intStream but set need object stream like IntegerStream.
		 * Hence calling boxed() on intStream() will help.
		 */
		Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
		System.out.println(set);
	}
	
	private void sortStream(List<Product> productList) {
		Comparator<Product> comparator = new Comparator<Product>() {

			@Override
			public int compare(Product p1, Product p2) {
				return (p1.getPrice() > p2.getPrice() ? -1 : 1);
			}

		};
		productList.stream().sorted(comparator).forEach(System.out::println);
	}
	
	private void convertListToMap(List<Product> productList)
	{
		Map<Integer, Product> productMap= productList.stream().collect(Collectors.toMap(Product::getProductId, Function.identity()));
		System.out.println(productMap);
	}
}