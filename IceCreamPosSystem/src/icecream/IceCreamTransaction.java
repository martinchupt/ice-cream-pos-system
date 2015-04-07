package icecream;

import java.util.HashMap;

public class IceCreamTransaction {
	
	private IceCreamFlavor flavor;
	private HashMap<IceCreamDecorator, Integer> decoratorMap;	// Key: IceCreamDecorator, Value: quantity
																// Create a hashmap to temporarily store the number of clicks of decorator button
	public IceCreamTransaction() {
		decoratorMap = new HashMap<IceCreamDecorator, Integer>();
	}

	public IceCreamFlavor getFlavor() {
		return flavor;
	}

	public void setFlavor(IceCreamFlavor flavor) {
		this.flavor = flavor;
	}

	public HashMap<IceCreamDecorator, Integer> getDecoratorMap() {
		return decoratorMap;
	}

	public void setDecoratorMap(HashMap<IceCreamDecorator, Integer> decoratorMap) {
		this.decoratorMap = decoratorMap;
	}

	public String getSummary() {
		String summary = "";
		double totalPrice = 0;
		if (flavor != null && flavor.getName() != null) {
			summary += flavor.getDescription();
			totalPrice += flavor.getCost();
			
			if (decoratorMap != null && !decoratorMap.isEmpty()) {
				summary += " with ";													// if decorator > 0, add "with"
				int index = 0;
				for (IceCreamDecorator iceCreamDecorator : decoratorMap.keySet()) {		//  for each element in the keyset (decorator) do looping
					if (index++ > 0) {													//
						summary += ", ";												//  if more than 1 decorator, add ","
					}																	//
					summary += iceCreamDecorator.getName() + " x " + decoratorMap.get(iceCreamDecorator);
					totalPrice += decoratorMap.get(iceCreamDecorator) * iceCreamDecorator.getCost();
				}
			}
		}
		
		summary += " - Total Price: $" + totalPrice;
		return summary;
	}
	
	public void addDecoratorQuantity(IceCreamDecorator iceCreamDecorator) {
		if (isDecoratorExist(iceCreamDecorator)) {
			addExistingDecoratorQuantity(iceCreamDecorator);	//  jump to add existing decorator on the map
		} else {
			decoratorMap.put(iceCreamDecorator, 1);				//  Create a new record of decorator on the map
		}
	}
	
	
	public boolean isDecoratorExist(IceCreamDecorator iceCreamDecorator) {								//  check existence of decorator
		boolean result = false;
		if (iceCreamDecorator != null && decoratorMap != null) {
			for (IceCreamDecorator tempIceCreamDecorator : decoratorMap.keySet()) {						//  for each element in the keyset (decorator) do looping
				if (iceCreamDecorator.getName().equalsIgnoreCase(tempIceCreamDecorator.getName())) {	//  check whether the decorator is on the map by name comparison 
					result = true;																		//
					break;																				//
				}																						//
			}																							//
		}
		return result;
	}
	
	public Integer addExistingDecoratorQuantity(IceCreamDecorator iceCreamDecorator) {
		Integer tempQuantity = 0;
		for (IceCreamDecorator tempIceCreamDecorator : decoratorMap.keySet()) {							//  for each element in the keyset (decorator) do looping
			if (iceCreamDecorator.getName().equalsIgnoreCase(tempIceCreamDecorator.getName())) {		//  check whether the decorator is on the map by name comparison
				tempQuantity = decoratorMap.get(tempIceCreamDecorator);									//  retrieve the decorator
				decoratorMap.put(tempIceCreamDecorator, ++tempQuantity);								//  Increase the quantity if a match decorator is on the map
				break;																					//
			}																							//
		}																								//
		return tempQuantity;
	}
	
}
