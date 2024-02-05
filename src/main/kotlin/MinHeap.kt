package org.example

/**
 * Representation of a min heap
 * @param T the type of the heap elements
 */
class MinHeap<T> {
    private var vertices: MutableList<Pair<T, Double>> = mutableListOf()
    fun insert(data: T, heapNumber: Double) {
        vertices.add(Pair<T, Double>(data, heapNumber))
        percolateUp(vertices.size-1)
    }

    fun getMin(): T? {
        when (vertices.size) {
            0 -> {
                return null
            }
            1 -> {
                val tmp = vertices[0].first
                vertices = mutableListOf()
                return tmp
            }
            else -> {
                val tmp = vertices[0].first
                vertices[0] = vertices.last()
                vertices.removeLast()
                bubbleDown(0)
                return tmp
            }
        }
    }

    private fun bubbleDown(startIndex: Int) {
        val startNumber = vertices[startIndex].second
        val leftIndex = getLeftIndex(of=startIndex)
        val rightIndex = getRightIndex(of=startIndex)
        val leftNumber = if (leftIndex >= vertices.size) Double.POSITIVE_INFINITY else vertices[leftIndex].second
        val rightNumber = if (rightIndex >= vertices.size) Double.POSITIVE_INFINITY else vertices[rightIndex].second
        if (startNumber < leftNumber && startNumber < rightNumber) {
            return
        } else if (leftNumber < rightNumber) {
            // swap with left since it is smallest
            val tmp = vertices[leftIndex]
            vertices[leftIndex] = vertices[startIndex]
            vertices[startIndex] = tmp
            bubbleDown(leftIndex)
            return
        } else {
            // swap with right since it is smallest
            val tmp = vertices[rightIndex]
            vertices[rightIndex] = vertices[startIndex]
            vertices[startIndex] = tmp
            bubbleDown(rightIndex)
            return
        }
    }

    private fun percolateUp(startIndex: Int) {
        val parentIndex = getParentIndex(of = startIndex)
        if (parentIndex < 0) {
            // we must be at the root
            return
        } else if (vertices[startIndex].second < vertices[parentIndex].second) {
            val temp = vertices[parentIndex]
            vertices[parentIndex] = vertices[startIndex]
            vertices[startIndex] = temp
            percolateUp(parentIndex)
        }
    }

    private fun getVertex(index: Int):Pair<T, Double>? {
        return if (index < vertices.size) {
            vertices[index]
        } else {
            null
        }
    }

    private fun getParentIndex(of: Int):Int {
        return (of - 1) / 2
    }

    private fun getLeftIndex(of: Int):Int {
        return of * 2 + 1
    }

    private fun getRightIndex(of: Int):Int {
        return of * 2 + 2
    }
}