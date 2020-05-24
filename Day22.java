class Element{
    
    Character c;
    Integer frequency;
    
    Element(Character c, Integer frequency){
        this.c = c;
        this.frequency = frequency;
    }
    
}

class SortByFrequency implements Comparator<Element>{
    
    public int compare(Element ob1, Element ob2){
        return ob2.frequency - ob1.frequency;   // sort descending order
    }
    
}

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(hm.containsKey(c)){
                hm.replace(c, hm.get(c)+1);
            }else{
                hm.put(c, 1);
            }
        }
        
        ArrayList<Element> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : hm.entrySet()){
            list.add(new Element(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list, new SortByFrequency());
        s = "";
        for(Element e : list){
            for(int j=0; j<e.frequency; j++)
                s += e.c;
        }
        return s;
    }
}