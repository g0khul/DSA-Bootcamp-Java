class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.height = 0

class Tree:
    def __init__(self):
        self.root = None

    def insert(self, val):
        if self.root is None:
            self.root = Node(val)
        else:
            self.populate(self.root, val)

    def populate(self, node, val):
        if val < node.val:
            if node.left is None:
                node.left = Node(val)
                return

            self.populate(node.left, val)
        
        if val > node.val:
            if node.right is None:
                node.right = Node(val)
                return

            self.populate(node.right, val)
        
        node.height = max(self.height(node.left), self.height(node.right)) + 1
    
    def height(self, node):
        if node is None:
            return -1

        return node.height
    
    def display(self):
        self.pretty_display(self.root, 0)
        
    def pretty_display(self, node, level):
        if node is None:
            return

        self.pretty_display(node.left, level + 1)
        if level != 0:
            for i in range(level):
                print(end="\t")
            print("|---->", node.val)
        else:
            print(node.val)
        self.pretty_display(node.right, level + 1)
    
    

root = Tree()
root.insert(15)
root.insert(7)
root.insert(21)
root.insert(4)
root.insert(10)
root.insert(17)
root.insert(24)

root.display()
