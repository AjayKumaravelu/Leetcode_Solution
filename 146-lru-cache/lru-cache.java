class LRUCache {
    // First wew will declare class Node
    class Node{
        Node next,prev;
        int key,value;
        Node(int _key,int _value){
            key = _key;
            value = _value;
        }
    }

    // We want two nodes initially which are head and tail
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    // Now we will declare hashmap
    Map<Integer, Node> map = new HashMap();
    int Capacity;

    public LRUCache(int capacity) {
        Capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // We will check whether map contains the key if contains we will remove and insert at first
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // We will put element after head and first we will check whether the map contains the key
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == Capacity){
            // As tail previous is least frequently used
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */