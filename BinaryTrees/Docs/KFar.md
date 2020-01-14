# KFar

## Using Path List

Get all the nodes in path and traverse the nodes and find all the elements at distance k-i in a loop.

Time: O(n)  
Space: O(n)

[KFar](./../Codes/Java/BinaryTrees/src/app/questions/KFar.java)

## Using backtracking

Backtrack our way to reach the target node then backtrack again and reach the parent then call KAway from parent with distance equal to the new distance obtained.

Time: O(n)  
Space: O(1)

[KFar](./../Codes/Java/BinaryTrees/src/app/questions/KFar.java)
