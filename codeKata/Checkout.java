package codeKata;

import java.util.HashMap;
import java.util.List;

public class Checkout {
	private HashMap<String, Pricing_rules> rules = new HashMap<>();
	private HashMap<String, Integer> items = new HashMap<>();
	
	public Checkout(List<Pricing_rules> checkoutRules) {
        for (Pricing_rules productRule : checkoutRules) {
        	rules.put(productRule.getProduct(), productRule);
		}
	}
	
	public int CalculateTotal(){
		int total = 0;
		
		for (String item : items.keySet()) {
			int subtotal = 0;
			//Verifico se o item est� na tabela
			if (!rules.containsKey(item)) {
				//Caso o item n�o esteja presente na tabela, apenas remove o item
				items.remove(item);		
		    } else {
		    	//Caso o item esteja presente na tabela, buscar o valor inteiro do item
		    	int units = items.get(item);
		    	//Busca as regras do item (product;unitPrice;quantityForSpecialPrice;specialPrice;hasDesconto)
		    	Pricing_rules produto = rules.get(item);
		    	
		    	//Pega o valor unit�rio do produto
		    	final int unitPrice = produto.getUnitPrice();
		    	//Verifica se este produto possui desconto
		    	if (!produto.isSpecialPrice()) {
		    		//Caso n�o tenha desconto apenas multiplica a quantidade pelo pre�o unit�rio
		    		subtotal = units * unitPrice;
		    	} else {
		    		//Caso tenha desconto, verifica a quantidade de iten para desconto
		    		final int quantityForSpecialPrice = produto.getQuantityForSpecialPrice();
		    		//Se a quantidade do produto for menor que a quantidade para o desconto
		    		if (units < quantityForSpecialPrice) {
		    			//Multiplica a quantidade pelo pre�o unit�rio
		    			subtotal = units * unitPrice;
		    				//Se a quantidade do produto for maior ou igual que a quantidade para o desconto
		                    } else if (units >= quantityForSpecialPrice) {
		                    	//Divide a quantidade de itens pela quantidade para o desconto e pega o resto da divis�o
		                        int normalPriceItens = units % quantityForSpecialPrice;
		                        //Subtrai as unidade pelo resto da divis�o e divide pela quantidade minima para o desconto
		                        int specPriceItens = (units - normalPriceItens) / quantityForSpecialPrice;
		                        //Busca o valor do produto com desconto
		                        final int specialPrice = produto.getSpecialPrice();
		                        //Multiplica a quantidade do produto com desconto pelo pre�o do mesmo com desconto e adiciona a 
		                        //quantidade excedente do produto com o pre�o normal.
		                        subtotal = normalPriceItens * unitPrice + specPriceItens * specialPrice;
		                    }
		                }
		            }
		            total += subtotal;
		        }
		        return total;
		    }
		
		    public void scan(String product) {
		        if (items.containsKey(product)) {
		            int value = items.get(product);
		            items.put(product, value + 1);
		        } else
		        	items.put(product, 1);
		    }
}
