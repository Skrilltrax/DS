#include <iostream>
using namespace std;

class Fraction {
    int numerator;
    int denominator;

    public:

    Fraction(int num, int den) {
        numerator = num;
        denominator = den;
    }

    void display() {
        cout << "Numerator : " << numerator << " Denominator : " << denominator << endl; 
    }

    Fraction operator+(Fraction const &f) {
        int lcm = denominator * f.denominator;
        Fraction fnew =  Fraction(numerator*f.denominator + f.numerator*denominator, lcm);
        fnew.simplify();
        return fnew; 
    }

    Fraction operator-(Fraction const &f) {
        int lcm = denominator * f.denominator;
        Fraction fnew =  Fraction(numerator*f.denominator - f.numerator*denominator, lcm);
        fnew.simplify();
        return fnew; 
    }

    Fraction operator*(Fraction const &f) {
        Fraction fnew = Fraction(numerator*f.numerator, denominator*f.denominator);
        fnew.simplify();
        return fnew; 
    }

    Fraction operator/(Fraction const &f) {
        Fraction fnew = Fraction(numerator*f.denominator, denominator*f.numerator);
        fnew.simplify();
        return fnew; 
    }

    bool operator==(Fraction const &f) {
        if (f.numerator == numerator && f.denominator == denominator)
            return true;
        return false;
    }

    void simplify() {
        int m = min(numerator, denominator);
        for (int i = 2; i <= m; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                this -> numerator /= i;
                this -> denominator /= i;
                i--;
            }
        }
    }

    int min(int a, int b) {
        if (a <= b) {
            return a;
        } else {
            return b;
        }
    }
};

int main() {
    Fraction f1(1, 2);
    Fraction f2(1, 2);
    if (f1 == f2) {
        Fraction f3 = f1 + f2;
        f3.display();
    }
}