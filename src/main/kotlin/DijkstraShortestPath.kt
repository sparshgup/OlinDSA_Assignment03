package org.example

fun <VertexType> DijkstraShortestPath(
    graph: DirectedWeightedGraph<VertexType>, start: VertexType, target: VertexType): List<VertexType>? {

    // Priority queue to store nodes and their weights
    val queue = PriorityQueue<VertexType>()

    // Map to store distances from start node to each node
    val distances = mutableMapOf<VertexType, Double>()

    // Map to reconstruct the shortest path
    val parents = mutableMapOf<VertexType, VertexType?>()

    // Initialize distances and parent nodes
    graph.getVertices().forEach {
        distances[it] = Double.POSITIVE_INFINITY
        parents[it] = null
    }

    distances[start] = 0.0
    queue.addWithPriority(start, 0.0)

    while (!queue.isEmpty()) {
        val current = queue.next() ?: break

        // If we reach target vertex, reconstruct the path and return it
        if (current == target) {
            val path = mutableListOf<VertexType>()
            var node: VertexType? = current
            while (node != null) {
                path.add(node)
                node = parents[node]
            }
            return path.reversed()
        }

        // Update distances to neighbors
        val neighbors = graph.getEdges(current)
        for ((neighbor, weight) in neighbors) {
            val tentativeDistance = distances[current]!! + weight
            if (tentativeDistance < distances[neighbor]!!) {
                distances[neighbor] = tentativeDistance
                parents[neighbor] = current
                queue.addWithPriority(neighbor, tentativeDistance)
            }
        }
    }

    return null // No path exists
}