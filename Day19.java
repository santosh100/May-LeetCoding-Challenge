import java.util.Stack;


class Element{
    int price;
    int span;
    Element(int price, int span){
        this.price = price;
        this.span = span;
    }
}


class StockSpanner {

    
    // APPROACH - 1
    /*
    ArrayList<Integer> list;
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {        
        int count = 1;
        int i = list.size()-1;
        while(i >=0 && list.size() > 0 && list.get(i) <= price){
            count++;
            i--;
        }
        list.add(price);
        return count;
    }
    */
    
    // APPROACH - 2
    // Faster than Approach - 1
    /*
    Stack<Integer> prices, weights;

    public StockSpanner() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }
    */
    
    // APPROACH - 3
    // Faster than Approach - 2
    /*
    int priceArr[];
    int spanArr[];
    int top;
    public StockSpanner() {
        priceArr = new int[10000];
        spanArr = new int[10000];
        top = -1;
    }
    
    public int next(int price) {       
        int span = 1;
        while(top >= 0 && priceArr[top] <= price){
            span += spanArr[top];
            top--;
        }
        top++;
        priceArr[top] = price;
        spanArr[top] = span;
        return span;
    }       
    */
    
    
    // APPROACH - 4
    // One more Approach
    
    Stack<Element> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {       
        int count=1;
        while(!stack.isEmpty() && stack.peek().price <= price){
            count +=stack.pop().span;
        }
        stack.push(new Element(price, count));
        return count;
    }
    
                     
    
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */