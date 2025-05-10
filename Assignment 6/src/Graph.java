import java.util.*;

public class Graph implements GraphInterface<Town,Road>{

    private ArrayList<Town> towns;
    private ArrayList<Road> roads;
    private HashMap<Town,Integer> roadMap;
    private ArrayList<Integer> shortestPath;

    public Graph() {
        this.towns = new ArrayList<>();
        this.roads = new ArrayList<>();
        this.roadMap = new HashMap<>();
    }


    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     * <p>
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex      source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return an edge connecting source vertex to target vertex.
     */
    @Override
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
        for(Road road : roads) {
            if (road.getTown1().equals(sourceVertex) && road.getTown2().equals(destinationVertex)) {
                return road;
            }else if(road.getTown2().equals(sourceVertex) && road.getTown1().equals(destinationVertex)) {
                return road;
            }
        }
        return null;
    }

    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge.
     * <p>
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     * @param sourceVertex      source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight            weight of the edge
     * @param description       description for edge
     * @return The newly created edge if added to the graph, otherwise null.
     * @throws IllegalArgumentException if source or target vertices are not
     *                                  found in the graph.
     * @throws NullPointerException     if any of the specified vertices is null.
     */
    @Override
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        Road temp = new Road(sourceVertex, destinationVertex, weight, description);
        this.roads.add(temp);
        return temp;
    }

    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param town vertex to be added to this graph.
     * @return true if this graph did not already contain the specified
     * vertex.
     * @throws NullPointerException if the specified vertex is null.
     */
    @Override
    public boolean addVertex(Town town) {
        if(towns.contains(town)){
            return false;
        }
        towns.add(town);
        return true;
    }

    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex      source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return true if this graph contains the specified edge.
     */
    @Override
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
        for(Road road : roads){
            if(road.getTown1() == sourceVertex && road.getTown2() == destinationVertex){
                return true;
            }else if(road.getTown2() == sourceVertex && road.getTown1() == destinationVertex){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param town vertex whose presence in this graph is to be tested.
     * @return true if this graph contains the specified vertex.
     */
    @Override
    public boolean containsVertex(Town town) {
        return towns.contains(town);
    }

    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     * @return a set of the edges contained in this graph.
     */
    @Override
    public Set<Road> edgeSet() {
        return new HashSet<Road>(this.roads);    }

    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     *               returned.
     * @return a set of all edges touching the specified vertex.
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException     if vertex is null.
     */
    @Override
    public Set<Road> edgesOf(Town vertex) {
        Set<Road> edges = new HashSet<>();
        for(Road road : this.roads) {
            if(road.getTown1() == vertex || road.getTown2() == vertex) {
                edges.add(road);
            }
        }
        return edges;
    }

    /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph.
     * <p>
     * If weight >- 1 it must be checked
     * If description != null, it must be checked
     * <p>
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex      source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight            weight of the edge
     * @param description       description of the edge
     * @return The removed edge, or null if no edge removed.
     */
    @Override
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        for(Road road : roads){
            if(road.getTown1() == sourceVertex && road.getTown2() == destinationVertex){
                Road temp = road;
                this.roads.remove(road);
            }else if(road.getTown2() == sourceVertex && road.getTown1() == destinationVertex){
                Road temp = road;
                this.roads.remove(road);
            }
        }
        return null;
    }

    /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     * <p>
     * If the specified vertex is null returns false.
     *
     * @param town vertex to be removed from this graph, if present.
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
    @Override
    public boolean removeVertex(Town town) {
        for(Town vertex : towns){
            if(vertex.equals(town)){
                return towns.remove(vertex);
            }
        }
        return false;
    }

    /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     * @return a set view of the vertices contained in this graph.
     */
    @Override
    public Set<Town> vertexSet() {
        return new HashSet<Town>(this.towns);
    }

    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     *
     * @param sourceVertex      starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
     * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
     * would be in the following format(this is a hypothetical solution):
     * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
     * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
     * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */
    @Override
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
        this.shortestPath = new ArrayList<>();
        this.dijkstraShortestPath(destinationVertex);
        ArrayList<String> shortestPathStr = new ArrayList<>();
        return shortestPathStr;
    }

    /**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     *
     * @param sourceVertex the vertex to find shortest path from
     */
    @Override
    public void dijkstraShortestPath(Town sourceVertex) {

    }

    public Town getVertex(String name) {
        for(Town i : this.towns) {
            if(i.getName() == name){
                return i;
            }
        }
        return null;
    }

    public ArrayList<String> getTowns(){
        ArrayList<String> temp = new ArrayList<>();
        for(Town i : this.towns) {
            temp.add(i.getName());
        }
        Collections.sort(temp);
        return temp;
    }

    public Road getRoad(String r1, String r2) {
        for(Road i : this.roads) {
            if(i.getTown1().getName().equals(r1) && i.getTown2().getName().equals(r2)) {
                return i;
            } else if (i.getTown1().getName().equals(r2) && i.getTown2().getName().equals(r1)) {
                return i;
            }
        }
        return null;
    }

}
