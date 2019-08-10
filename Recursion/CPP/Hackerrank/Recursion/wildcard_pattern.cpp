// find all string which can be formed when a ? is obtained.
// 11?01?1?1 (use 0 and 1)

#include <iostream>
using namespace std;

void printAllCombinations(char pattern[], int i)
{
	if (pattern[0] == '\0')
	{
		printf("%s\n", pattern);
		return;
	}

	// if the current character is '?'
	if (pattern[0] == '?')
	{
		for (int k = 0; k < 2; k++)
		{
			// replace '?' with 0 and 1
			pattern[0] = (char) k;
			
			// recur for the remaining 
            cout<<pattern[0];
			printAllCombinations(pattern, i + 1);
			
			// backtrack (As array is passed by reference to the function)
			pattern[0] = '?';
		}
		return;
	}
}
int main() {
    char s[] = "?";
    printAllCombinations(s, 1);
}