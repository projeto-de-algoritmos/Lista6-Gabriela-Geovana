import java.util.Random;

public class Controller {
	
	public int getRandomInt(int max){
		Random rnd = new Random();
		return rnd.nextInt(Math.abs(max));
	}
	
	public int[] getRandomNodes() {
	
		int num_elements = getRandomInt(5) + 3;
		int nodes[] = new int[num_elements];
		
		for(int i = 0; i < num_elements; i++) {
			nodes[i] = getRandomInt(50) + 1;
		}
		
		return nodes;
	}
	
	public int[] getRandomFrequencies(int num_elements) {
		
		int freq[] = new int[num_elements];
		
		for(int i = 0; i < num_elements; i++) {
			freq[i] = getRandomInt(50) + 1;
		}
		
		return freq;
	}
	
	public String getArrayString(int[] itens) {
		StringBuilder str = new StringBuilder("");
		
		for(int i=0; i<itens.length; i++) {
			str.append(itens[i]);
			str.append("   ");
		}
		
		return str.toString();
	}
}
