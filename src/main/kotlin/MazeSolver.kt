package org.example

/**
 * Node class used to store maze coordinates
 * @param i x-coordinate of the node
 * @param j y-coordinate of the node
 */
data class Node(var i: Int, var j: Int)

/**
 * Maze Solver
 * Source used to build: https://inginious.org/course/competitive-programming/graphs-maze
 * Put the pieces together in order to be able to find a path in a maze. There is always a path in the mazes provided.
 *
 * @param maze Input: n lines each with a string of length m giving the rows of the maze.
 *  A '#' represents a wall, a '.' represents a white space, 'S' and 'T' represent the origin
 *  and destination, respectively. The positions are numbered starting from 0.
 */
class MazeSolver(private val maze: List<String>) {
    private val n: Int = maze.size
    private val m: Int = maze[0].length
    private val start: Node
    private val target: Node
    private val graph: DirectedWeightedGraph<Node>

    init {
        start = Node(-1, -1)
        target = Node(-1, -1)
        graph = DirectedWeightedGraph()

        // Find start and target positions
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (maze[i][j] == 'S') {
                    start.i = i
                    start.j = j
                } else if (maze[i][j] == 'T') {
                    target.i = i
                    target.j = j
                }
            }
        }

        // Add edges to the graph
        for (i in 0 until n) {
            for (j in 0 until m) {
                val from = Node(i, j)
                if (maze[i][j] != '#') {
                    if (i > 0 && maze[i - 1][j] != '#') {
                        val to = Node(i - 1, j)
                        graph.addEdge(from, to, 1.0)
                    }
                    if (i < n - 1 && maze[i + 1][j] != '#') {
                        val to = Node(i + 1, j)
                        graph.addEdge(from, to, 1.0)
                    }
                    if (j > 0 && maze[i][j - 1] != '#') {
                        val to = Node(i, j - 1)
                        graph.addEdge(from, to, 1.0)
                    }
                    if (j < m - 1 && maze[i][j + 1] != '#') {
                        val to = Node(i, j + 1)
                        graph.addEdge(from, to, 1.0)
                    }
                }
            }
        }
    }

    /**
     * Solve the maze and return the path as a list of nodes
     */
    fun solve(): List<Node> {
        val path = mutableListOf<Node>()
        val shortestPath = DijkstraShortestPath(graph, start, target)
        if (shortestPath != null) {
            path.addAll(shortestPath)
        }
        return path
    }
}

