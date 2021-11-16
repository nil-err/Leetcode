class MapSum {
    private Trie trie;

    public MapSum() {
        trie = new Trie();
    }
    
    public void insert(String key, int val) {
        trie.insert(key, val);
    }
    
    public int sum(String prefix) {
        Trie node = trie.searchPrefix(prefix);
        return node == null ? 0 : node.getSumValue();
    }
}

class Trie {
    private Trie[] children;
    private int value;
    private int sumValue;

    public Trie(){
        children = new Trie[26];
        value = 0;
        sumValue = 0;
    }

    public void insert(String key, int value){
        Trie node = searchPrefix(key);
        if(node == null){
            insertCheckPreValue(key, value, 0);
        }else{
            insertCheckPreValue(key, value, node.value);
        }
    }

    private void insertCheckPreValue(String key, int value, int preValue){
        Trie node = this;
        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i) - 'a';
            if(node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
            node.sumValue += value - preValue;
        }
        if(node.value == preValue){
            node.value = value;
        }
    }

    public Trie searchPrefix(String key){
        Trie node = this;
        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i) - 'a';
            if(node.children[index] == null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public int getSumValue(){
        return sumValue;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
