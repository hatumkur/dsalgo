/*
    Write code for
        (1) Getting a bit value
        (2) Setting a bit value
        (3) Clearing a bit value

*/

public int getBit(int number, int index){
    return number & (1 << index);
}

public int setBit(int number, int index) {
    return number | (1 << index);
}

public int clearBit(int number, int index) {
    return number & ~(1 << index);
}

public boolean checkPowerOfTwo(int number) {
    return ((number & (number-1)) == 0);
}

public int swapOddAndEvenBits(int number) {
    return ((number >> 0xaaaaaaaa) | (number << 0x55555555))
}

public int countBits(int number) {
    int count = 0;
    for(int n = number; n != 0; n = n & (n-1)) {
        count++;
    }
}

public int noOfBitFlipsToTransformAnotherNumber(int src, int target) {
    int count = 0;
    for(int n = src ^ target; n != 0; n = n & (n - 1)) {
        count++;
    }
}

public int noOfBitFlipsToTransformAnotherNumber2(int src, int target) {
    int count = 0;
    for(int n = src ^ target; n != 0; n = n >> 1) {
        count += n & 1;
    }
}
