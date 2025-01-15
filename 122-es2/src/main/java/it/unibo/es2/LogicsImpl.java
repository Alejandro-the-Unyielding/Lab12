package it.unibo.es2;

import java.util.HashMap;
import java.util.Map;

public class LogicsImpl implements Logics {
    final Map<Pair<Integer, Integer>, String> values = new HashMap<>();
    final int side;

    public LogicsImpl(final int size){

        this.side = size;  
        for(int i = 0; i < this.side; i++){
            for(int j = 0; j < this.side; j++){         
                values.put(new Pair<Integer, Integer>(i, j),"");
            }
        }


    }

    @Override
    public String hit(Pair<Integer, Integer> key) {
        
        String v = this.values.get(key);
        v = (v == "" ? "*" : "");
        this.values.put(key, v);
        return v;
     
    }

    @Override
    public boolean ColumnFull(){
        for(int column = 0; column < this.side ; column++){
            int count = 0;
            Pair<Integer, Integer> refCoord = new Pair<>(0, column);
            String coord = this.values.get(refCoord);
            if(coord == "*"){
                count++;
                for(int x = 1; x < this.side ; x++){
                    Pair<Integer, Integer> pair = new Pair<>(x, column);
                    String v = this.values.get(pair);
                    if(v == "*"){
                        count++;
                        if(count == this.side) return true;
                    }

                }

            }
                
        }

        return false;
        
    }
        
    @Override
    public boolean RowFull() {
        for(int row = 0; row < this.side ; row++){
            int count = 0;
            Pair<Integer, Integer> refCoord = new Pair<>(row,0);
            String coord = this.values.get(refCoord);
            if(coord == "*"){
                count++;
                for(int y = 1; y < this.side ; y++){
                    Pair<Integer, Integer> pair = new Pair<>(row, y);
                    String v = this.values.get(pair);
                    if(v == "*"){
                        count++;
                        if(count == this.side) return true;
                    }

                }

            }
                
        }

        return false;

    }

}
