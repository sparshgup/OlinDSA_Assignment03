import org.example.DirectedWeightedGraph
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DirectedWeightedGraphTest {

    /**
     * Test case for the getVertices method of DirectedWeightedGraph.
     * Verifies that the method returns all vertices in the graph.
     */
    @Test
    fun getVertices() {
        val graph = DirectedWeightedGraph<String>()
        graph.addEdge("A", "B", 1.0)
        graph.addEdge("A", "C", 2.0)
        graph.addEdge("B", "C", 3.0)
        assertEquals(setOf("A", "B", "C"), graph.getVertices())
    }

    /**
     * Test case for the addEdge method of DirectedWeightedGraph.
     * Verifies that an edge between two vertices with the specified weight is correctly added to the graph.
     */
    @Test
    fun addEdge() {
        val graph = DirectedWeightedGraph<String>()
        graph.addEdge("A", "B", 1.0)
        assertTrue(graph.getVertices().contains("A"))
        assertTrue(graph.getVertices().contains("B"))
        assertEquals(1.0, graph.getEdges("A")["B"])
    }

    /**
     * Test case for the getEdges method of DirectedWeightedGraph.
     * Verifies that the method returns the edges originating from a given vertex.
     */
    @Test
    fun getEdges() {
        val graph = DirectedWeightedGraph<String>()
        graph.addEdge("A", "B", 1.0)
        graph.addEdge("A", "C", 2.0)
        assertEquals(mapOf("B" to 1.0, "C" to 2.0), graph.getEdges("A"))
        assertTrue(graph.getEdges("B").isEmpty())
    }

    /**
     * Test case for the clear method of DirectedWeightedGraph.
     * Verifies that the graph is cleared of all vertices and edges.
     */
    @Test
    fun clear() {
        val graph = DirectedWeightedGraph<String>()
        graph.addEdge("A", "B", 1.0)
        graph.addEdge("A", "C", 2.0)
        graph.clear()
        assertTrue(graph.getVertices().isEmpty())
        assertTrue(graph.getEdges("A").isEmpty())
    }
}