class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None
        
class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.head = Node(-1, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.mapping = dict()

    def get(self, key: int) -> int:
        node = self.mapping.get(key)
        if node:
            node.prev.next = node.next
            node.next.prev = node.prev
            self.push_back(node)
            return node.val
        else:
            return -1
        

    def put(self, key: int, value: int) -> None:
        node = Node(key, value)
        if key in self.mapping:
            prev_node = self.mapping[key]
            prev_node.prev.next = prev_node.next
            prev_node.next.prev = prev_node.prev
            prev_node = None
        self.mapping[key] = node
        self.push_back(node)
    
    def push_back(self, node):
        last = self.tail.prev
        last.next = node
        node.prev = last
        node.next = self.tail
        self.tail.prev = node
        
        if len(self.mapping) > self.capacity:
            least_used_node = self.head.next
            self.head.next = least_used_node.next
            least_used_node.next.prev = self.head
            
            del self.mapping[least_used_node.key]
            
            least_used_node = None

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)