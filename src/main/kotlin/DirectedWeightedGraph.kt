package org.example

/**
 * A class for a Directed, Weighted Graph built on top of the Graph interface.
 *
 * @param VertexType the type representing a vertex in a graph
 */
class DirectedWeightedGraph<VertexType> : Graph<VertexType> {
    private val adjacencyMap: MutableMap<VertexType, MutableMap<VertexType, Double>> = mutableMapOf()

    /**
     * @return the vertices in the graph
     */
    override fun getVertices(): Set<VertexType> {
        val vertices = mutableSetOf<VertexType>()
        adjacencyMap.forEach { (vertex, edges) ->
            vertices.add(vertex)
            edges.keys.forEach { vertices.add(it) }
        }
        return vertices
    }

    /**
     * Add an edge to the graph from one vertex to another with weighted cost
     */
    override fun addEdge(from: VertexType, to: VertexType, cost: Double) {
        adjacencyMap.computeIfAbsent(from) { mutableMapOf() }[to] = cost
    }

    /**
     * @return the edges in the graph
     */
    override fun getEdges(from: VertexType): Map<VertexType, Double> {
        return adjacencyMap[from] ?: emptyMap()
    }

    /**
     * Remove all edges and vertices from the graph
     */
    override fun clear() {
        adjacencyMap.clear()
    }
}