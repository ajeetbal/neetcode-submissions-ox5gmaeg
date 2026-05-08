class LRUCache {
    class Node{
        int key,value;
        Node next,prev;
        
        Node() {}

        Node(int key, int value) {
        this.key = key;
        this.value = value;
        }   
    }

    private int currentSize,maxCapacity;
    private Node dummyHead,dummyTail;
    private HashMap<Integer,Node> cacheMap;


    public LRUCache(int capacity) {
        this.maxCapacity=capacity;
        this.currentSize=0;

        this.dummyHead=new Node();
        this.dummyTail=new Node();

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

        this.cacheMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key)){
            return -1;
        }

        Node targetNode = cacheMap.get(key);

        removeNodeFromList(targetNode);
        addNodeToHead(targetNode);

        return targetNode.value;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            Node existingNode = cacheMap.get(key);

            removeNodeFromList(existingNode);

            existingNode.value = value;

            addNodeToHead(existingNode);
        }else{
            Node newNode = new Node(key,value);
            cacheMap.put(key,newNode);
            addNodeToHead(newNode);
            currentSize++;

            if(currentSize > maxCapacity){
                Node tobeRemoved = dummyTail.prev;
                cacheMap.remove(tobeRemoved.key);
                removeNodeFromList(tobeRemoved);
                currentSize--;
            }

        }
    }

    private void removeNodeFromList(Node targetNode){
        targetNode.prev.next = targetNode.next;
        targetNode.next.prev= targetNode.prev;
    }

    private void addNodeToHead(Node targetNode) {
        targetNode.next = dummyHead.next;
        targetNode.prev = dummyHead;

        dummyHead.next.prev = targetNode;
        dummyHead.next = targetNode;

    }
}


