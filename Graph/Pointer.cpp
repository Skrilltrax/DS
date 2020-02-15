#include <iostream>
using namespace std;

void ptr1()
{
    int a = 100;
    int *d = &a;
    {
        int x = 1;
        d = &a;
        cout << *d;
    }
    cout << *d;
}

void ptr2()
{
    int a = 10;
    int *x = new int(-10);
    int *b = &a;

    // cout << b << "  " << x;

    cout << b - x << endl;
    cout << x - b << endl;
}

int *ptr3()
{
    int a = 10;
    int *b = &a;
    return b;
}

void ptr4()
{

    int *arr = new int[5];
    for (int i = 0; i < 5; i++) {
        cout << *(arr+i) << endl;
    }
}

int main()
{
    // ptr1();
    ptr4();
    // int x = 10;
    // cout << ptr3() - x << endl;
}