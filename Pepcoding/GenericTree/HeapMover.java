public class HeapMover {
    
    public class Solutions {
        public boolean find = false;
        public int max = Integer.MIN_VALUE;
        public int min = Integer.MAX_VALUE;
        public int size = 0;
        public int height = 0;
        public int floor = Integer.MAX_VALUE;
        public int ceil = Integer.MIN_VALUE;
    }

    public static void multiSolution(Node node, int findData, Solutions mover) {
        if (node.data == findData) {
            mover.find = true;
        }

        if (node.data > mover.max) {
            mover.max = node.data;
        }

        if (node.data < mover.min) {
            mover.min = node.data;
        }

        if (node.data > mover.floor && node.data < findData) {
            mover.floor = node.data;
        }

        if (node.data < mover.ceil && node.data > findData) {
            mover.floor = node.data;
        }

        for(Node child: node.children) {
            multiSolution(child, findData, mover);
        }
    }

    public static void main(String[] args) {
        
    }
    
}