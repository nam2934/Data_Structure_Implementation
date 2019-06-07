class HTable{
    public HEntry[] table;
    public HTable(){
        table = new HEntry[262139];
    }
    public boolean insert(int i, String s){
        int index = i;
        if(i < 0){
            index = index % 262139 + 262139;
        }
        else{
            index = index % 262139;
        }
        for(int j=0; j<262139; j++){
            if(table[j] != null){
                if(table[j].i == i && table[j].deleted == false){
                    return false;
                }
            }
        }

        if(table[index] == null){
            table[index] = new HEntry();
            table[index].i = i;
            table[index].s = s;
            table[index].deleted = false;
            return true;
        }

        else{
            if(table[index].deleted == false){
                while(table[index] != null){
                    index = (index+1)%262139;
                }
                table[index] = new HEntry();
                table[index].i = i;
                table[index].s = s;
                return true;
            }
            else{
                table[index].i = i;
                table[index].s = s;
                table[index].deleted = false;
                return true;
            }
        }
    }
    public boolean delete(int i){
        for(int j=0; j<262139; j++){
            if(table[j] != null){
                if(table[j].deleted == false){
                    if(table[j].i == i){
                        table[j].s = null;
                        table[j].deleted = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public String query(int i){
        for(int j=0; j<262139; j++){
            if(table[j] != null){
                if(table[j].deleted == false){
                    if(table[j].i == i){
                        return table[j].s;
                    }
                }
            }
        }
        return null;
    }
}