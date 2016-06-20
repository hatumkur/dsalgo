
/*
    LRUCache
*/

class Cache{
    int maxSize;
    int size;
    HashMap<Integer, Object> map = new HashMap<Integer, Object>();
    LinkedList<Integer>linkedList = new LinkedList<Integer>();

    public Cache(int maxsize){
        this.maxSize = maxsize;
        size = 0;
    }

    public boolean addItem(int key, Object obj){
        boolean result = false;
        if(!map.containsKey(key) && size < maxsize){
            map.put(key,obj);
            linkedlist.addFirst(key);
            size++;
            result = true;
        }
        resize();
    }

    private resize() {
        if(size == maxsize) {
            int key = linkedlist.removeLast();
            map.remove(key);
            size--;
        }
    }

    public Object getItem(int key) {
        Object result = null;
        if(map.containsKey(key)){
            result = map.get(key);
            linkedList.addFirst(key);
            removeItemFromLinkedList(key);
            resize();
        }
        return result;
    }

    public Object removeItem(int key) {
        Object result = null;
        if(map.containsKey(key)){
            result = map.remove(key);
            removeItemFromLinkedList();
        }
        return result;
    }

    private removeItemFromLinkedList(int key) {
        // ... Traverse and remove the node
    }
}
