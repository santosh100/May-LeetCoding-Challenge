class Solution {
    
    // MY APPROACH
    /*
    public String DecToBinary(int n){
        if(n == 0){
            return "";
        }
        String result = DecToBinary(n/2);
        if(n%2 == 0){
             result += "0";
        }else{
            return result += "1";
        }        
        return result;
    }
    
    public int BinaryToDec(String binaryStr){
        return Integer.parseInt(binaryStr,2);
    }
    
    public String complement(String binStr){
        String binComp = "";
        for(int i=0; i<binStr.length(); i++){            
           binComp += (binStr.charAt(i) == '0') ? "1" : "0";             
        }
        return binComp;
    }
    
    public int findComplement(int num) {
        
        if(num == 0){
            return 1;
        }
        
        String binStr = DecToBinary(num);
        String binComp = complement(binStr);
        return BinaryToDec(binComp);
    }
    */
    
    
    // OPTIMAL SOLUTION
    // Trick: two steps to coplement a num
    // Step 1 : Find the number of bits in the given integer
    // Step 2 : XOR the given integer with (2^no_of_bits) - 1
    public int findComplement(int num) {
        
        int no_of_bits = (int)(Math.floor(Math.log(num) / Math.log(2))) + 1;    
        int twoPower = 1 << no_of_bits;     // Trick to get Math.pow(2, no_of_bits)
        return num ^ (twoPower - 1);
    }
}