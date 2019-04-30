import java.io.*;

public class Assignment31{
    public static void main(String[] args) {
        String s;
        
        int num;
        int index = -1;

        try {
            BufferedReader rd =
                new BufferedReader(new FileReader("input.txt"));
            BufferedWriter wr =
                new BufferedWriter(new FileWriter("output.txt"));
    
            s = rd.readLine();
            num = Integer.parseInt(s);
            String[] stack = new String[num];
            String[] line = new String[num];

            for(int i=0; i<num; i++){
                line[i] = rd.readLine();
                String[] new_line = line[i].split(" ");
                if(new_line[0].equals("u")){
                    index++;
                    stack[index] = new_line[1] + " " + new_line[2];
                }
                else if(new_line[0].equals("e")){
                    wr.write(stack[index] + "\n");
                }
                else if(new_line[0].equals("o")){
                    if(index == -1){
                        wr.write("empty" + "\n");
                    }
                    else{
                        wr.write(stack[index] + "\n");
                        index--;
                    }
                }
            }
            rd.close();
            wr.close();
        }
        catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}