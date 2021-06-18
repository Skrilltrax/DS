#include <iostream>
using namespace std;

class Polynomial {
    int capacity;
    int *degreeCoeff;

    public:

    Polynomial() {
        capacity = 1;
        degreeCoeff = new int[capacity];
        degreeCoeff[0] = 0;
    }

    Polynomial(Polynomial const &p) {
        this -> degreeCoeff = new int[p.capacity];
        for (int i = 0; i < p.capacity; i++) {
            this -> degreeCoeff[i] = p.degreeCoeff[i];
        }
        this -> capacity = p.capacity;
    }

    void operator= (Polynomial const &p) {
        for (int i = 0; i < p.capacity; i++) {
            this -> degreeCoeff[i] = p.degreeCoeff[i];
        }
        this -> capacity = p.capacity;
    }

    void print() {
        for (int i = 0; i < capacity; i++) {
            cout << degreeCoeff[i] << "x^" << i << " ";
        }
        cout << endl;
    }

    void setCoeff(int degree, int coeff) {
        if (capacity > degree) {
            degreeCoeff[degree] = coeff;
            return;
        }
        int oldCapacity = capacity;
        while (capacity <= degree) {
            capacity *= 2;
        }
        int *newDegreeCoeff = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            if (i < oldCapacity) {
                newDegreeCoeff[i] = degreeCoeff[i];
            } else {
                newDegreeCoeff[i] = 0;
            }
        }
        delete[] degreeCoeff;
        degreeCoeff = newDegreeCoeff;
        degreeCoeff[degree] = coeff;
    }

    Polynomial operator+(Polynomial const &p) {
        if (capacity < p.capacity) {
            Polynomial ptemp;
            int oldCapacity = this -> capacity;
            this -> capacity = p.capacity;
            int *temp = new int[capacity];
            for (int i = 0; i < capacity; i++) {
                if (i < oldCapacity) {
                    temp[i] = this -> degreeCoeff[i] + p.degreeCoeff[i];
                } else {
                    temp[i] = p.degreeCoeff[i];
                }
            }
            ptemp.degreeCoeff = temp;
            ptemp.capacity = capacity;
            return ptemp;
        }
        else {
            Polynomial ptemp;
            int *temp = new int[capacity];
            for (int i = 0; i < capacity; i++) {
                temp[i] = degreeCoeff[i] + p.degreeCoeff[i];
            }
            ptemp.degreeCoeff = temp;
            ptemp.capacity = capacity;
            return ptemp;
        }
    }

    Polynomial operator-(Polynomial const &p) {
        if (capacity < p.capacity) {
            Polynomial ptemp;
            int oldCapacity = this -> capacity;
            this -> capacity = p.capacity;
            int *temp = new int[capacity];
            for (int i = 0; i < capacity; i++) {
                if (i < oldCapacity) {
                    temp[i] = this -> degreeCoeff[i] - p.degreeCoeff[i];
                } else {
                    temp[i] = -p.degreeCoeff[i];
                }
            }
            ptemp.degreeCoeff = temp;
            ptemp.capacity = capacity;
            return ptemp; 
        }
        else {
            Polynomial ptemp;
            int *temp = new int[capacity];
            for (int i = 0; i < capacity; i++) {
                temp[i] = this -> degreeCoeff[i] - p.degreeCoeff[i];
            }
            ptemp.degreeCoeff = temp;
            ptemp.capacity = capacity;
            return ptemp;
        }
    }
};