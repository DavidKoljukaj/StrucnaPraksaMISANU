package task12;

import java.util.ArrayList;

import java.util.List;

public class RandomNumbers {
	List<Integer> random = new ArrayList<>();
	
	RandomNumbers(){
		for(int i=0;i<10;i++) {
			this.random.add((int)(Math.random()*100));
		}
	}
	


}
