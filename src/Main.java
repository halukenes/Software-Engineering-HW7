import java.util.ArrayList;

public class Main {
	
	ArrayList<Integer> totals = new ArrayList<Integer>();
	
	public ArrayList<Integer> getTotals() {
		return totals;
	}


	public String findMaxValuedNeighbourhood(int[][] map) {	
		
		String coordinatesOfMax = null;
				
		int max = 0;
				
		for(int i = 0; i < map.length; i++) {
			for(int k = 0; k < map[i].length; k++) {
				
				int total = 0;
				
				if(i == 0) {
					
					
					if(k == 0) {
						//right ve down
						
						total = map[i][k] + map[i][k+1] + map[i+1][k];
					}else if(k > 0 && k < map[i].length - 1) {
						//right,left,down
						
						total = map[i][k] + map[i][k+1] + map[i][k-1] + map[i+1][k];
					}else if(k == map[i].length - 1) {
						//left,down
						total = map[i][k] + map[i][k-1] + map[i+1][k];
					}
					
					
				}else if(i == map.length - 1) {
					
					
					if(k == 0) {
						//right,up
						
						total = map[i][k] + map[i][k+1] + map[i-1][k];
					}else if(k > 0 && k < map[i].length - 1) {
						//right,left,up
						
						total = map[i][k] + map[i][k+1] + map[i][k-1] + map[i-1][k];
					}else if(k == map[i].length - 1){
						//left,up
						
						total = map[i][k] + map[i][k-1] + map[i-1][k];
					}
					
					
				}else {
										
					if(k == 0) {
						//right,up,down
						total = map[i+1][k] + map[i][k+1] + map[i-1][k];
					}else if(k > 0 && k < map[i].length - 1) {
						total = map[i][k] + map[i+1][k] + map[i-1][k] + map[i][k+1] + map[i][k-1];
					}else if(k == map[i].length - 1){
						total = map[i][k] + map[i+1][k] + map[i-1][k] + map[i][k-1];
					}
					
				}
				
				totals.add(total);
				
				if(total >= max) {
					max = total;
					coordinatesOfMax = "(" + k + "," + i + ")";
				}
			}
		}
				
		return coordinatesOfMax;
	}

	
	public boolean isItValid(int[][] map) {
		
		boolean onesAndZeros = true;
		
		for(int i = 0; i < map.length; i++) {
			for(int k = 0; k < map[i].length; k++) {
				if((map[i][k] != 0) == (map[i][k] != 1)) {
					onesAndZeros = false;
				}
			}
		}
		
		return onesAndZeros;
	}
}