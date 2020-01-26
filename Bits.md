# Bits

## Operators

`& (and), | (or), ! (not), ~ (1's Complement), - (2's Complement)` 

## Operations

`>> Right Shift (Adds the value of previous MSB to MSB)`

`<< Left Shift (Adds 0 to LSB)` 

`>>> Triple Right Shift (Adds only 0 to MSB)`

```cpp
Array

vector<bool> arr(32, false);
int idx = k;
arr[idx] = true;
arr[idx] = false;
if (arr[idx]) {
    
} else {

}

Bits

int arr = 0;
int idx = (1 << k);
arr |= idx;
arr &= (~idx);
if ((arr & idx) != 0) {

} else {

}
```