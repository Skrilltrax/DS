class MyHashSet {

    class Node {
        public int key;
        public int count;
        
        public Node(int key, int count) {
            this.key = key;
            this.count = count;
        }
        
        public void incrementCount() {
            this.count++;
        }
    }
    
    ArrayList<Node>[] bucket;
    int size;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        initialize(8);
    }
    
    public void add(int key) {
        Node node = findNodeInGroup(key);
        if (node == null) {
            addCount(key, 1);
            return;
        }
        
        node.incrementCount();
    }
    
    public void remove(int key) {
        Node node = findNodeInGroup(key);
        if (node == null) {
            return;
        }
        
        int group = getGroup(key);
        bucket[group].remove(node);
        this.size--;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return (findNodeInGroup(key) == null) ? false : true;
    }
    
    public int size() {
        return size;
    }
    
    private void addCount(int key, int count) {
        ArrayList<Node> group = bucket[getGroup(key)];
        group.add(new Node(key, count));
        this.size++;
        
        double lambda = group.size()/bucket.length;
        if (lambda > 0.7) reHash();
    }
    
    private void initialize(int size) {
        this.size = 0;
        bucket = new ArrayList[size];
        for(int i = 0; i < size; i++) {
            bucket[i] = new ArrayList<>();
        }
    }
    
    private Node findNodeInGroup(int key) {
        int group = getGroup(key);
        
        for(Node node: bucket[group]) {
            if (key == node.key) {
                return node;
            }
        }
        
        return null;
    }
    
    private int getGroup(int key) {
        return Math.abs(key)%bucket.length;
    }
    
    private void reHash() {
        ArrayList<Node>[] oldBucket = bucket;
        initialize(oldBucket.length * 2);
        this.size = 0;
        
        for(ArrayList<Node> group: oldBucket) {
            for(Node node: group) {
                addCount(node.key, node.count);
            }
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
