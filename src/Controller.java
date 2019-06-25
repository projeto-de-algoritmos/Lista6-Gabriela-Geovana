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
	
	public int[][] optimalSearchTree(int keys[], int freq[], int n) { 
		  
        int cost[][] = new int[n + 1][n + 1]; 
  
        //diagonal
        for (int i = 0; i < n; i++) 
            cost[i][i] = freq[i]; 
  
        for (int L = 2; L <= n; L++) { 
  
            for (int i = 0; i <= n - L + 1; i++) { 

                int j = i + L - 1; 
                cost[i][j] = Integer.MAX_VALUE; 
  
                for (int r = i; r <= j; r++) { 
  
                    // c = cost when keys[r] becomes root of this subtree 
                    int c = ((r > i) ? cost[i][r - 1] : 0) 
                            + ((r < j) ? cost[r + 1][j] : 0) + sum(freq, i, j); 
                    if (c < cost[i][j]) 
                        cost[i][j] = c; 
                } 
            } 
        } 
        return cost; 
    }
	
	public int sum(int freq[], int i, int j) { 
        int s = 0; 
        for (int k = i; k <= j; k++) { 
            if (k >= freq.length) 
                continue; 
            s += freq[k]; 
        } 
        return s; 
    } 
}
