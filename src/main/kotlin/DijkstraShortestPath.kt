package org.example

fun <VertexType> DijkstraShortestPath(
    graph: DirectedWeightedGraph<VertexType>, start: VertexType, target: VertexType): List<VertexType>? {

    // Priority queue to store nodes and their weights
    val queue = PriorityQueue<VertexType>()

    // Map to store distances from start node to each node
    val distances = mutableMapOf<VertexType, Double>()

    // Map to reconstruct the shortest path
    val prev = mutableMapOf<VertexType, VertexType?>()

    // Initialize distances and parent nodes
    graph.getVertices().forEach {
        distances[it] = Double.POSITIVE_INFINITY
        prev[it] = null
    }

    distances[start] = 0.0
    queue.addWithPriority(start, 0.0)

    while (!queue.isEmpty()) {
        val u = queue.next() ?: break

        // Reconstruct path if we reach target vertex
        if (u == target) {
            val path = mutableListOf<VertexType>()
            var node: VertexType? = u
            while (node != null) {
                path.add(node)
                node = prev[node]
            }
            return path.reversed()
        }

        val neighbors = graph.getEdges(u)
        for ((v, cost) in neighbors) {
            val alt = distances[u]!! + cost
            if (alt < distances[v]!!) {
                distances[v] = alt
                prev[v] = u
                queue.addWithPriority(v, alt)
            }
        }
    }

    return null // No path exists
}