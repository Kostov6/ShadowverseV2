package tools;

import java.util.Arrays;

public class CardAbs {

	private int cost;
	private Integer alternative;
	private CardAbs[] effectiveGain;
	private String name;
	
	public CardAbs(int cost, String name) {
		this.cost = cost;
		this.name = name;
	}
	public CardAbs(int cost, Integer alternative, String name) {
		this.cost = cost;
		this.alternative = alternative;
		this.name = name;
	}
	public CardAbs(int cost, CardAbs[] effectiveGain, String name) {
		this.cost = cost;
		this.effectiveGain = effectiveGain;
		this.name = name;
	}
	public CardAbs(int cost, Integer alternative, CardAbs[] effectiveGain, String name) {
		this.cost = cost;
		this.alternative = alternative;
		this.effectiveGain = effectiveGain;
		this.name = name;
	}

	public int getPlayCost(int playPoints)
	{
		if(alternative==null)
			return cost;
		
		int min = cost < alternative ? cost : alternative;
		int max = cost < alternative ? alternative : cost;
		
		if(max <= playPoints)
			return max;
		
		return min;
	}

	
	public CardAbs[] getEffectiveGain() {
		return effectiveGain;
	}

	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		if(alternative!=null)
			return "["+cost+"("+alternative+") "+name+"]"; 
		return "["+cost+" "+name+"]";
	}

	
}
