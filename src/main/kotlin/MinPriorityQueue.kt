package org.example

/**
 * A class for Priority Queue built on top of the MinPriorityQueue interface
 * which uses methods from the Min Heap built in MyMinHeap class
 *
 * @param T the representation of the items in the queue
 */
class PriorityQueue<T> : MinPriorityQueue<T> {

    private val heap: MyMinHeap<T> = MyMinHeap()

    /**
     * @return true if the queue is empty, false otherwise
     */
    override fun isEmpty(): Boolean {
        return heap.isEmpty()
    }

    /**
     * Add [elem] with at level [priority]
     */
    override fun addWithPriority(elem: T, priority: Double) {
        heap.insert(elem, priority)
    }

    /**
     * Get the next (lowest priority) element.
     * @return the next element in terms of priority.  If empty, return null.
     */
    override fun next(): T? {
        return heap.extractMin()
    }

    /**
     * Adjust the priority of the given element
     * @param elem whose priority should change
     * @param newPriority the priority to use for the element
     *   the lower the priority the earlier the element in the order.
     */
    override fun adjustPriority(elem: T, newPriority: Double) {
        heap.decreaseKey(elem, newPriority)
    }
}