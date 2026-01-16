package cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache is a simple in-memory cache implementation
 * demonstrating O(1) eviction using HashMap and
 * Doubly Linked List.
 * Objective and Focus: Core data structures and object-oriented design.
 */
public class LRUCache {

    // Doubly linked list node
    private class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Dummy head and tail
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // Remove node from its current position
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node right after head (most recently used)
    private void insertAfterHead(Node node) {
        Node temp = head.next;
        node.next = temp;
        node.prev = head;
        head.next = node;
        temp.prev = node;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        Node node = cache.get(key);
        remove(node);
        insertAfterHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (cache.containsKey(key)) {
            Node existing = cache.get(key);
            remove(existing);
            cache.remove(key);
        }

        if (cache.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        insertAfterHead(newNode);
        cache.put(key, newNode);
    }
}
