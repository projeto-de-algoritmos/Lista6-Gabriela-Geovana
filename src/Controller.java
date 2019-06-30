import java.util.ArrayList;
import java.util.Random;

public class Controller {
	public int roots[][];
	int cost[][];
	int[] keys;
	public Node root;
	
	public int getRandomInt(int max){
		Random rnd = new Random();
		return rnd.nextInt(Math.abs(max));
	}
	
	public int[] getRandomNodes() {
	
		int num_elements = getRandomInt(5) + 3;
		int nodes[] = new int[num_elements];
		
		for(int i = 0; i < num_elements; i++) {
			if(i > 0)
				nodes[i] = nodes[i-1] + getRandomInt(50) + 1;
			else
				nodes[i] = getRandomInt(50) + 1;
		}
		keys = nodes;
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
		  
        cost = new int[n + 1][n + 1]; 
        roots = new int[n + 1][n + 1]; 
  
        //diagonal
        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
            roots[i][i] = i;
        }
  
        for (int L = 2; L <= n; L++) { 
  
            for (int i = 0; i <= n - L + 1; i++) { 

                int j = i + L - 1; 
                cost[i][j] = Integer.MAX_VALUE; 
  
                for (int r = i; r <= j; r++) { 
  
                    // c = cost when keys[r] becomes root of this subtree 
                    int c = ((r > i) ? cost[i][r - 1] : 0) 
                            + ((r < j) ? cost[r + 1][j] : 0) + sum(freq, i, j); 
                    if (c < cost[i][j]) {
                    	cost[i][j] = c; 
                    	roots[i][j] = r;
                    }
                        
                } 
            } 
        }
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		System.out.println("(" + i + "," + j + ")" + ":" + roots[i][j]);
        	}
        }
        
        root = printTree(0, n-1, n);
        System.out.println("Ra�z PRINT: " + root.key);
        
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

	public Node printTree(int i, int j, int size) {
//		http://software.ucv.ro/~cmihaescu/ro/laboratoare/SDA/docs/arboriOptimali_en.pdf
		Node p;
		if (i == j) {
			p = new Node(i, keys[i]);
		}
		else {
			p = new Node(roots[i][j], keys[roots[i][j]]);
			if (p.value> 0 && i <= p.value -1) {
				p.left = printTree(i, p.value -1 , size);				
				System.out.println(p.left.key + " � filho esquerdo de " + p.key);
			}
			if (p.value < size && p.value + 1 <= j) {
				p.right = printTree(p.value + 1, j, size);
				System.out.println(p.right.key + " � filho direito de " + p.key);
			}
		}
		return p;
	}
}
