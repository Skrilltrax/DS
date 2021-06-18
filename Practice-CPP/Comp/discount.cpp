#include<bits/stdc++.h>

 using namespace std;

 int main() {
     int t;
     cin>>t;
     for(int it=0;it<t;it++) {
        int n;
        cin>>n;
        int num=n;
        vector<int>vec;
        while(num!=0) {
            int r = num%10;
            num = num/10;
            vec.push_back(r);
        }
        int zero_count=0;
        for(int i=0;i<vec.size();i++) {
            if(vec[i]==0) zero_count++;
        }
        if(zero_count==vec.size()) {
                cout<<"0";
                continue;
        }
        reverse(vec.begin(), vec.end());
        int flag=-1;
        for(int i=0;i<vec.size();i++) {
            if(vec[i]==0) {
                flag=i;
            }
        }
        if(flag==-1) {
            int maximum=INT_MIN;
            int index=-1;
            for(int i=0;i<vec.size();i++) {
                if(vec[i]>maximum) {
                        maximum=vec[i];
                        index=i;
                }
            }
            vec.erase(vec.begin()+index);
            for(int i=0;i<vec.size();i++) {
                cout<<vec[i];
            }
        }
        else {
            int maximum=INT_MIN;
            int index=-1;
            for(int i=0;i<flag;i++) {
                if(vec[i]>maximum) {
                    maximum=vec[i];
                    index=i;
                }
            }
            vec.erase(vec.begin()+index);
            while(!vec[0]) {
                vec.erase(vec.begin());
            }
            for(int i=0;i<vec.size();i++) {
                cout<<vec[i];
            }
        }
        cout<<"\n";
     }
 }