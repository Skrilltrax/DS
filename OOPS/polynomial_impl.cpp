#include <iostream>
#include "polynomial.cpp"
using namespace std;

int main() {
    Polynomial p1;
    p1.setCoeff(0, 1);
    p1.setCoeff(1, 2);
    p1.print();

    Polynomial p2;
    p2.setCoeff(0, 2);
    p2.setCoeff(1, 4);
    p2.print();

    Polynomial p3;
    p3 = p2 + p1;
    p3.print();

    Polynomial p4;
    p4 = p2 - p1;
    p4.print();

}