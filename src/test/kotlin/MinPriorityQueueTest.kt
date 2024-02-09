import org.example.MinPriorityQueue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinPriorityQueueTest {

    /**
     * Test case for the isEmpty method of MinPriorityQueue.
     * Verifies that the method correctly checks whether the priority queue is empty.
     */
    @Test
    fun isEmpty() {
        val queue = MinPriorityQueue<Int>()
        assertTrue(queue.isEmpty())
        queue.addWithPriority(1, 1.0)
        assertFalse(queue.isEmpty())
        queue.next()
        assertTrue(queue.isEmpty())
    }

    /**
     * Test case for the addWithPriority method of MinPriorityQueue.
     * Verifies that elements are correctly added to the priority queue with their specified priorities.
     */
    @Test
    fun addWithPriority() {
        val queue = MinPriorityQueue<Int>()
        queue.addWithPriority(1, 1.0)
        queue.addWithPriority(2, 0.5)
        queue.addWithPriority(3, 2.0)
        assertEquals(2, queue.next())
    }

    /**
     * Test case for the next method of MinPriorityQueue.
     * Verifies that elements are removed from the priority queue in the correct order of priority.
     */
    @Test
    operator fun next() {
        val queue = MinPriorityQueue<Int>()
        queue.addWithPriority(1, 1.0)
        queue.addWithPriority(2, 0.5)
        queue.addWithPriority(3, 2.0)
        assertEquals(2, queue.next())
        assertEquals(1, queue.next())
        assertEquals(3, queue.next())
        assertNull(queue.next())
    }

    /**
     * Test case for the adjustPriority method of MinPriorityQueue.
     * Verifies that the priority of an element in the queue is correctly adjusted.
     */
    @Test
    fun adjustPriority() {
        val queue = MinPriorityQueue<Int>()
        queue.addWithPriority(1, 2.0)
        queue.addWithPriority(2, 3.0)
        queue.adjustPriority(2, 1.0)
        assertEquals(2, queue.next())
        assertEquals(1, queue.next())
    }
}