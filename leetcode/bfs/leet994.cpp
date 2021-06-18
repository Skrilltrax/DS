class Solution {
    
    class Block {
    
        public:
            int r;
            int c;

            Block(int r, int c) {
                this -> r = r;
                this -> c = c;
            }
    };
    
public:
    int orangesRotting(vector<vector<int>>& grid) {
        return findRotten(grid);
    }
    
    int findRotten(vector<vector<int>>& grid) {
        queue<Block*> q;
        int minute = 0;
        int freshCount = 0;
        
        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == 2) {
                    q.push(new Block(i, j));
                } 
                
                if (grid[i][j] == 1) {
                    freshCount++;
                }  
            }
        }
        
        q.push(nullptr);    
        
        while(q.size() > 1) {
            if (q.front() == nullptr) {
                q.pop();
                q.push(nullptr);
                // displayGrid(grid);
                minute++;
            }
            
            Block *b = q.front();
            q.pop();
            
            int r = b -> r;
            int c = b -> c;
            
            if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                grid[r-1][c] = 2;
                q.push(new Block(r-1, c));
                freshCount--;
            }

            if (r + 1 < grid.size() && grid[r + 1][c] == 1) {
                grid[r+1][c] = 2;
                q.push(new Block(r+1, c));
                freshCount--;
            }
            
            if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                grid[r][c-1] = 2;
                q.push(new Block(r, c - 1));
                freshCount--;
            }
            
            if (c + 1 < grid[0].size() && grid[r][c + 1] == 1) {
                grid[r][c+1] = 2;
                q.push(new Block(r, c + 1));
                freshCount--;
            }
        }

        if (freshCount == 0) {
            return minute;    
        } else {
            return -1;
        }
        
    }
    
    void displayGrid(vector<vector<int>>& grid) {
        for(auto& row: grid) {
            for(auto& block: row) {
                cout << block << "  ";
            }
            cout << endl;
        }
    }
};
