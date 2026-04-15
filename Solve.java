package Calculator;

public class Solve {
    static String[] numArrage(String[] numbers, String operator, int indexIndentify, int i){        
                 for (int change = i + 1; change < indexIndentify; change++) {
                    numbers[change] = numbers[change+1];
                 }
                numbers[indexIndentify] = "";
        return numbers;
    }

    static String MDAS(String input){

        String expression = input;
        String[] numbers = new String[expression.length()];
        for (int i = 0; i<numbers.length; i++) {
            numbers[i] = "";
        }
        //JOptionPane.showConfirmDialog(null, "Length: "+expression.length());
        String operator = "";
        int expressionIndex = 0;
        if(expression.charAt(0) == '-') {
            numbers[0] += expression.charAt(0);
            expressionIndex++;
        }
        for (int i = 0; i<numbers.length; i++) {//Array Index
            for (; expressionIndex<expression.length(); expressionIndex++) { //Expression Index
                if( (expression.charAt(expressionIndex) == '+') || 
                    (expression.charAt(expressionIndex) == '-') ||
                    (expression.charAt(expressionIndex) == 'x') ||
                    (expression.charAt(expressionIndex) == '%') ||
                    (expression.charAt(expressionIndex) == '÷')
                ) {
                    operator += expression.charAt(expressionIndex);

                    if(expression.charAt(expressionIndex+1) == '-') {
                    numbers[i+1] += expression.charAt(expressionIndex+1);
                    expressionIndex++;
                    }
                    if(expression.charAt(expressionIndex+1) == '+') {
                    numbers[i+1] += expression.charAt(expressionIndex+1);
                    expressionIndex++;
                    }

                    expressionIndex++;
                    break;
                }
                numbers[i] += expression.charAt(expressionIndex); //Store the number
            }
          //  System.out.println("Numbers: "+Arrays.toString(numbers)+": "+i+" Operator: "+operator);
            }


            int indexIndentify = numbers.length-1;
            for (int i = 0; i<operator.length(); i++) {
                if (operator.charAt(i) == 'x' || operator.charAt(i) == '÷' || operator.charAt(i) == '%') {
                    //Multiply
                    if (operator.charAt(i) == 'x') {
                        numbers[i] = Operator.multiply(numbers[i], numbers[i+1]);
                        operator = operator.substring(0, i) + operator.substring(i + 1);  
                        numbers = numArrage(numbers, operator, indexIndentify, i);
                        indexIndentify--;
                        i--;
                        //Debug
                        //JOptionPane.showMessageDialog(null, "Operator: "+operator+"\n Numbers: "+Arrays.toString(numbers));
                        continue;
                    }
                    if (operator.charAt(i) == '÷') {
                        numbers[i] = Operator.divide(numbers[i], numbers[i+1]);
                        operator = operator.substring(0, i) + operator.substring(i + 1);  
                        numbers = numArrage(numbers, operator, indexIndentify, i);
                        indexIndentify--;
                        i--;
                        //Debug
                        //JOptionPane.showMessageDialog(null, "Operator: "+operator+"\n Numbers: "+Arrays.toString(numbers));
                        continue;
                    }
                    if (operator.charAt(i) == '%') {
                        numbers[i] = Operator.modulo(numbers[i], numbers[i+1]);
                        operator = operator.substring(0, i) + operator.substring(i + 1);  
                        numbers = numArrage(numbers, operator, indexIndentify, i);
                        indexIndentify--;
                        i--;
                        //Debug
                        //JOptionPane.showMessageDialog(null, "Operator: "+operator+"\n Numbers: "+Arrays.toString(numbers));
                        continue;
                    }  
                 }
            }
            for (int i = 0; i<operator.length(); i++) {
                if (operator.charAt(i) == '+' || operator.charAt(i) == '-') {
                    //Multiply
                    if (operator.charAt(i) == '+') {
                        numbers[i] = Operator.add(numbers[i], numbers[i+1]);
                        operator = operator.substring(0, i) + operator.substring(i + 1);  
                        numbers = numArrage(numbers, operator, indexIndentify, i);
                        indexIndentify--;
                        i--;
                        //Debug
                        //JOptionPane.showMessageDialog(null, "Operator: "+operator+"\n Numbers: "+Arrays.toString(numbers));
                        continue;
                    }
                    if (operator.charAt(i) == '-') {
                        numbers[i] = Operator.subtract(numbers[i], numbers[i+1]);
                        operator = operator.substring(0, i) + operator.substring(i + 1);  
                        numbers = numArrage(numbers, operator, indexIndentify, i);
                        indexIndentify--;
                        i--;
                        //Debug
                        //JOptionPane.showMessageDialog(null, "Operator: "+operator+"\n Numbers: "+Arrays.toString(numbers));
                        continue;
                    }
            }
            }
            return numbers[0];
    }
    static String PEMDAS(String input) {
             System.out.println("Before Edit: "+input);
        //input check if Correct Parenthesis
        int openP = 0;
        int closeP = 0;
        for (int i = 0; i<input.length(); i++) {
            if (input.charAt(i) == '(') {
                openP++;
            }
            if(input.charAt(i) == ')') {
                closeP++;
            }
        }
        if (openP != closeP) {
            return "Invalid Parenthesis";
        }

        //Edit Expression
        String NE = ""; //New Expression
        for(int i = 0; i<input.length(); i++){
            if (input.charAt(i) == '('){
                if(i != 0 && input.charAt(i-1) != 'x' && input.charAt(i-1) != '('){
                    if (
                        input.charAt(i-1) == '-' || 
                        input.charAt(i-1) == '+' ||
                        input.charAt(i-1) == '÷' ||
                        input.charAt(i-1) == '%'
                        ) {
                        NE += input.charAt(i);
                        continue;
                    }else {
                        NE += "x"+input.charAt(i);
                        continue;
                    }
                }
            }
            if (input.charAt(i) == ')'){
                if(i != input.length()-1 && input.charAt(i+1) != 'x' && input.charAt(i+1) != ')' && input.charAt(i+1) != '('){
                    if (
                        input.charAt(i+1) == '-' || 
                        input.charAt(i+1) == '+' ||
                        input.charAt(i+1) == '÷' ||
                        input.charAt(i+1) == '%'
                    ) {
                        NE += input.charAt(i);
                        continue;
                    }else {
                        NE += input.charAt(i)+"x";
                        continue;
                    }
                }
            }
            NE += input.charAt(i);
        }
        return SolvePEMDAS("(("+NE+"))");
    }
    static String SolvePEMDAS(String input) {
        input = input.substring(1, input.length()-1);
        System.out.println("input: "+input);

        int OpenCloseP = 0;

        String toStore = "";
        String CalCuParen = "";

        int II = 0;
        for (; II<input.length(); II++) {
            String toRecurse = "";
            if (input.charAt(II) == '(') {
                for (; II<input.length(); II++) {
                    if (input.charAt(II) == '(') {
                        OpenCloseP++;
                    }
                    toRecurse += input.charAt(II);
                    if (input.charAt(II) == ')') {
                        OpenCloseP--;
                        if (OpenCloseP == 0) {
                            II++;
                            break;
                        }
                    }
                }
                String From = toStore+toRecurse;

                toStore += SolvePEMDAS(toRecurse);

                //Logs
                System.out.println("\nFrom = "+From+" \nReturned: "+toStore+"\nAnswer: "+MDAS(toStore));
                CalCuParen = toStore;
            }
            if (II<input.length()) {
                toStore += input.charAt(II);
            }
        }
        if(!CalCuParen.isEmpty()){
            return MDAS(toStore);
        }


        System.out.println("To MDAS 2: "+MDAS(input));
        return MDAS(input);
        }   
}