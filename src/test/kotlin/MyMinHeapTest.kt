import org.example.MyMinHeap
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MyMinHeapTest {

    /**
     * Test for the insert method of MyMinHeap.
     * Verifies that elements are correctly inserted into the heap and extracted in the correct order.
     */
    @Test
    fun testInsert() {
        val minHeap = MyMinHeap<Int>()
        assertTrue(minHeap.isEmpty())

        minHeap.insert(5, 5.0)
        minHeap.insert(3, 3.0)
        minHeap.insert(7, 7.0)
        assertFalse(minHeap.isEmpty())

        assertEquals(3, minHeap.extractMin())
        assertEquals(5, minHeap.extractMin())
        assertEquals(7, minHeap.extractMin())
        assertTrue(minHeap.isEmpty())
        assertNull(minHeap.extractMin())
    }

    /**
     * Test for the extractMin method of MyMinHeap.
     * Verifies that the minimum element is correctly extracted from the heap.
     */
    @Test
    fun testExtractMin() {
        val minHeap = MyMinHeap<Int>()
        minHeap.insert(5, 5.0)
        minHeap.insert(3, 3.0)
        minHeap.insert(7, 7.0)
        assertEquals(3, minHeap.extractMin())
        assertEquals(5, minHeap.extractMin())
        assertEquals(7, minHeap.extractMin())
        assertTrue(minHeap.isEmpty())
        assertNull(minHeap.extractMin())
    }

    /**
     * Test case for the decreaseKey method of MyMinHeap.
     * Verifies that the value of a vertex in the heap is correctly decreased.
     */
    @Test
    fun testDecreaseKey() {
        val minHeap = MyMinHeap<Int>()
        minHeap.insert(5, 5.0)
        minHeap.insert(3, 3.0)
        minHeap.insert(7, 7.0)
        minHeap.decreaseKey(5, 2.0)
        assertEquals(5, minHeap.extractMin())
    }

    /**
     * Test case for the isEmpty method of MyMinHeap.
     * Verifies if the isEmpty method correctly checks whether the heap is empty.
     */
    @Test
    fun testIsEmpty() {
        val minHeap = MyMinHeap<Int>()
        assertTrue(minHeap.isEmpty())
        minHeap.insert(5, 5.0)
        assertFalse(minHeap.isEmpty())
        minHeap.extractMin()
        assertTrue(minHeap.isEmpty())
    }
}
