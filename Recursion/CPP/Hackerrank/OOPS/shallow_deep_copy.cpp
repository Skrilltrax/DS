#include <iostream>
#include <cstring>
using namespace std;

class Student {
    char* name;
    int age;

    public:

    int getAge() {
        return this -> age;
    }

    char* getName() {
        return this -> name;
    }

    void setAge(int age) {
        this -> age = age;
    }

    void setNameShallow(char* name) {
        this -> name = name;
    }

    void setNameDeep(char* name) {
        this -> name = new char[strlen(name) + 1];
        strcpy(this -> name, name);
    }
};

int main() {
    Student s1;
    char name[] = "Aditya";
    s1.setAge(18);
    s1.setNameShallow(name);

    Student s2;
    s2.setAge(19);
    s2.setNameDeep(name);

    cout << "Name : " << s1.getName() << " Age : " << s1.getAge() << endl;
    cout << "Name : " << s2.getName() << " Age : " << s2.getAge() << endl;

    name[0] = 'X';

    cout << "Name : " << s1.getName() << " Age : " << s1.getAge() << endl;
    cout << "Name : " << s2.getName() << " Age : " << s2.getAge() << endl;

}