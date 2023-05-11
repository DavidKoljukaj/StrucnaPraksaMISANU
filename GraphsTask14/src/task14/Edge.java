package task14;

public class Edge {
	private Node start;
	private Node end;
	private Integer weight;
	
	public Edge(Node start, Node end, Integer w) {
		this.start=start;
		this.end=end;
		this.weight=w;
	}
	
	public Node getStart() {
		return this.start;
	}
	
	public Node getEnd() {
		return this.end;
	}
	
	public Integer getWeight() {
		return this.weight;
	}
	
	
}
