package practice.java.hashing.ds;

import java.util.LinkedList;

public class HashMap<K, V> {

    private final int INITIAL_SIZE = 16;
    private final float LOAD_FACTOR = 0.75f;
    private LinkedList<Node>[] buckets;
    private int size = 0;
    private int capacity = INITIAL_SIZE;

    private class Node {
        public K key;
        public V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMap() {
        // Initialize the array
        initializeBuckets(INITIAL_SIZE);
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndexFromKey(key);
        int itemPosition = getItemPositionInBucket(bucketIndex, key);

        // Update existing node
        if (itemPosition != -1) {
            Node node = buckets[bucketIndex].get(itemPosition);
            node.value = value;
            return;
        }

        // Create a new node
        Node node = new Node(key, value);
        insertNodeInBucket(bucketIndex, node);

        if ((float) size / capacity > LOAD_FACTOR) {
            rehash();
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketIndexFromKey(key);
        int nodeIndex = getItemPositionInBucket(bucketIndex, key);

        return buckets[bucketIndex].get(nodeIndex).value;
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndexFromKey(key);
        int nodeIndex = getItemPositionInBucket(bucketIndex, key);

        removeNodeInBucket(bucketIndex, nodeIndex);
    }

    private void initializeBuckets(int capacity) {
        this.buckets = new LinkedList[capacity];
        this.capacity = capacity;
        this.size = 0;

        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndexFromKey(K key) {
        int hashCode = Math.abs(key.hashCode());
        int moduloHashCode = hashCode % capacity;

        return moduloHashCode;
    }

    private int getItemPositionInBucket(int bucketIndex, K key) {
        LinkedList<Node> items = buckets[bucketIndex];

        for (int i = 0; i < items.size(); i++) {
            Node item = items.get(i);

            if (item.key == key) return i;
        }

        // If not found in loop
        return -1;
    }

    private void insertNodeInBucket(int bucketIndex, Node node) {
        LinkedList<Node> bucket = buckets[bucketIndex];
        bucket.push(node);
        size++;
    }

    private void removeNodeInBucket(int bucketIndex, int nodeIndex) {
        LinkedList<Node> bucket = buckets[bucketIndex];
        bucket.remove(nodeIndex);
        size--;
    }

    private void rehash() {
        LinkedList[] oldBuckets = buckets;
        initializeBuckets(capacity * 2);

        for (LinkedList<Node> bucket: oldBuckets) {
            for (Node node: bucket) {
                put(node.key, node.value);
            }
        }
    }
}
