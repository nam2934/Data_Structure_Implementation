import java.util.Scanner;
import java.util.Stack;

class infix_to_postfix{
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Scanner input = new Scanner(System.in);
        String output = "";
        int check = 0;

        System.out.print("input postfix form : ");
        String postfix = input.nextLine();
        int postfix_size = postfix.length();
        String[] array_postfix = new String[postfix_size];

        array_postfix = postfix.split("");

        for(int i = 0; i < postfix_size; i++){
            if(isOperand(array_postfix[i])){
                output = output + array_postfix[i];
                //check++;
            }
            else{
                check++;
                if(stack.isEmpty()) stack.push(array_postfix[i]);
                else{
                    if( !((stack.peek().equals("+") || stack.peek().equals("-")) && (array_postfix[i].equals("*") || array_postfix[i].equals("/")))){
                        while(!stack.isEmpty()){
                            output = output + stack.pop();
                        }
                        stack.push(array_postfix[i]); 
                    }
                    else{
                        stack.push(array_postfix[i]);
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            output = output + stack.pop();
        }
        
        System.out.println(output);
    }
    public static boolean isOperand(String s){
        return (!s.equals("+") && !s.equals("*") && !s.equals("-") && !s.equals("/"));
    }
}