package task14;

import java.util.ArrayList;

public class Graph {
	/*Teorija grafova je matematička teorija o svojstvima i primeni grafova tj. mreža.
	 *Tipovi grafova:
	 *-undirected graph je onaj u kome ivice(edges) nemaju orijentaciju. edge (U,V)=(V,U)
	 *-directed graph ili digraph: ivice imaju orijentaciju. edge(U,V) je ivica od noda U(ili vertex-a U) do noda V; U-->V
	 *-weighted graph: težina predstavlja neku vrednost(npr. razdaljinu) (U,V,W). I undirected i directed grafovi mogu imati težinu.
	 *-special graphs:
	 *I Najvažniji posebni graf je tree. Tree je aciklični undirected graf. To je povezani graf sa N nodova i N-1 ivica.
	 *II Rooted graf je tree graf sa root nodom prema kojem, ili od koga, sve ivice pokazuju.
	 *Kada ivice pokazuju od root-a, takav graf se naziva out-tree(arborescence), a kada pokazuju ka root-u, in-tree(anti-arborescence).
	 *III Directed Acyclic Graphs(DAGs) su, kao što im ime kaže, aciklični directed grafovi. Svi out-tree grafovi su DAGs, ali svi DAG-ovi nisu out-tree!
	 *IV Bipartite graf je onaj čiji se nodovi mogu podeliti u dve nezavisne grupe U,V tako da svaka ivica povezuje U i V.
	 *V Kompletni graf - onaj u kome postoji jedinstvena ivica između svakog para nodova. Kompletni graf sa n nodova se obeležava kao graf kn. */
	
	private ArrayList<Node> nodes;
	private boolean isWeighted;
	private boolean isDirected;
	
	public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
		this.nodes = new ArrayList<Node>();
		this.isWeighted=inputIsWeighted;
		this.isDirected = inputIsDirected;
	}
	
	public Node addNode(String data) {
		Node newNode = new Node(data);
		this.nodes.add(newNode);
		return newNode;
	}
	
	public void addEdge(Node startNode, Node endNode, Integer weight) {
		/*Checks if the edge is weighted. If it isn't, sets weight parameter to null.
		 *Weight parameter is of the type Integer instead of int for this reason.*/
		if (!this.isWeighted) {
			weight = null;
		}
		
		startNode.addEdge(endNode, weight);
		/*Creates an undirected edge if the boolean value isDirected is false*/
		if (!this.isDirected) {
			endNode.addEdge(startNode, weight);
		}
	}
	
	public void removeEdge(Node startNode, Node endNode) {
		startNode.removeEdge(endNode);
		if(!this.isDirected) {
			endNode.removeEdge(startNode);
		}
	}
	
	public void removeNode(Node node) {
		this.nodes.remove(node);
	}
	
	public ArrayList<Node> getNodes(){
		return this.nodes;
	}
	
	public boolean isWeighted() {
		return this.isWeighted;
	}
	
	public boolean isDirected() {
		return this.isDirected;
	}
	
	public Node getNodeByValue(String value) {
		for(Node v : this.nodes) {
			if(v.getData()==value) {
				return v;
			}
		}	
		return null;
	}
	
	public void print() {
		for(Node v : this.nodes) {
			v.print(isWeighted);
		}
	}
	
	public static int distanceKm(Graph g) {
		int distance = 0;
		ArrayList<Edge> allEdges = new ArrayList<>();
		for(int i=0;i<g.getNodes().size();i++) {
			allEdges.add(g.getNodes().get(i).getEdges().get(0));
		}
		for(Edge e : allEdges) {
			distance += e.getWeight();
		}
		return distance;
	}

	public static void main(String[] args) {
			Graph busNetwork = new Graph(true,true);
			Node beogradStanica = busNetwork.addNode("Beograd");
			Node noviSadStanica = busNetwork.addNode("Novi Sad");
			Node suboticaStanica = busNetwork.addNode("Subotica");
			Node nisStanica = busNetwork.addNode("Niš");
			Node cacakStanica = busNetwork.addNode("Čačak");
			Node negotinStanica = busNetwork.addNode("Negotin");
			Node uziceStanica = busNetwork.addNode("Užice");
			Node zajecarStanica = busNetwork.addNode("Zaječar");
			
			busNetwork.addEdge(beogradStanica, noviSadStanica, 95);
			busNetwork.addEdge(noviSadStanica, suboticaStanica, 108);
			busNetwork.addEdge(suboticaStanica, nisStanica, 420);
			busNetwork.addEdge(nisStanica, cacakStanica, 205);
			busNetwork.addEdge(cacakStanica, negotinStanica, 268);
			busNetwork.addEdge(negotinStanica, uziceStanica, 322);
			busNetwork.addEdge(uziceStanica, zajecarStanica, 276);
			busNetwork.addEdge(zajecarStanica, beogradStanica, 251);
			busNetwork.print();
			
			
			System.out.println("\nUkupno kilometara: " + distanceKm(busNetwork)+"km");
			
			
	}

}
