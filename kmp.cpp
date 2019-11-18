#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Function to implement KMP algorithm
void KMP(const char* X, const char* Y, int m, int n)
{
	// Base Case 1: Y is NULL or empty
	if (*Y == '\0' || n == 0)
		printf("Pattern occurs with shift 0");

	// Base Case 2: X is NULL or X's length is less than that of Y's
	if (*X == '\0' || n > m)
		printf("Pattern not found");

	// next[i] stores the index of next best partial match
	int next[n + 1];

	for (int i = 0; i < n + 1; i++)
		next[i] = 0;

	for (int i = 1; i < n; i++)
	{
		int j = next[i + 1];

		while (j > 0 && Y[j] != Y[i])
			j = next[j];

		if (j > 0 || Y[j] == Y[i])
			next[i + 1] = j + 1;
	}

	for (int i = 0, j = 0; i < m; i++)
	{
		if (*(X + i) == *(Y + j))
		{
			if (++j == n)
				printf("Pattern occurs with shift %d\n", i - j + 1);
		}
		else if (j > 0) {
			j = next[j];
			i--;	// since i will be incremented in next iteration
		}
	}
}

// Program to implement KMP Algorithm in C
int main(void)
{
	char* text = "ABCABAABCABAC";
	char* pattern = "CAB";

	int n = strlen(text);
	int m = strlen(pattern);

	KMP(text, pattern, n, m);

	return 0;
}