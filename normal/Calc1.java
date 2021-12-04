package normal;

import java.util.Scanner;
import java.util.Vector;

public class Calc1 {
    // Defining Variables for Different Colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    // Ending Definition of Colors

    private Vector<String> eqn = new Vector<>(); // Stores Operands
    String temp1; // Stores Operand 1 temporarily
    String temp2; // Stores Operand 2 temporarily
    Scanner in = new Scanner(System.in);

    public void reset() {
        eqn.clear();
    }

    public String showEqn() {
        String str = eqn.toString();
        str = str.replace("[", "");
        str = str.replace("]", "");
        str = str.replace(",", "");
        // System.out.println(YELLOW + "Equation: " + GREEN + str + RESET);
        return str;
    }

    public Vector<String> getEqn() {
        return eqn;
    }

    public char getTop()
    {
        return eqn.get(eqn.size()-1).charAt(0);
    }

    public String getSecondTop()
    {
        return eqn.get(eqn.size()-2);
    }

    /*
     * Working Of Below Operations: STEP 1: If the size of eqn Vector is greater
     * than 0 than add the respective operator into Vector eqn (+, -, *, /) //
     * Enters do...while loop STEP 2: If eqn size is not 0 then op variable stores
     * the last added value into the eqn vector STEP 3: If eqn size is not 0 and
     * value of op is not any operator than add the respective operator into eqn
     * Vector STEP 4: Inputs Operand 1 as String(for exception handling), if Entered
     * value is empty string than exit function else check whether the given input
     * is valid number or not if it is not valid remove the last entered value into
     * eqn Vector and continue from that loop else add the value into eqn Vector
     * repeat same for Second Operand STEP 5: Before adding second operand into eqn
     * Vector add the respective operator (+, -, *, /) into eqn Vector STEP 6:
     * Continue STEP 1-5 till either one of the operand input is not an empty String
     * 
     * NOTE: All the below functions add(), sub(), mul(), div() works in the similar
     * way
     */

    // Function to perform addition of multiple numbers
    public void add() {
        char op = 0; // Stores Current Operator
        System.out.println(CYAN + "Enter Operands: " + RESET);
        if (eqn.size() > 0) { // Checks If Size of Eqn Vector is greater than 0 or not
            eqn.add("+"); // If It is than pushes + into Vector eqn
        }
        do {
            if (eqn.size() != 0)
                op = eqn.get(eqn.size() - 1).charAt(0); // Stores the last value pushed into Vector
            if (eqn.size() != 0 && (op != '+')) {
                eqn.add("+"); // If Size of eqn is greater than 0 and last value push is not an operator than
                              // push + into vector
            }
            // Gets First Input From User "1 >>" indicates first Input
            System.out.print(YELLOW + "ADD >> " + RESET);
            temp1 = in.nextLine();
            if (temp1 == "") {
                eqn.remove(eqn.size() - 1); // If Input provided is an empty string than pop the last inserted element
                                            // i.e. pop + and come out of loop
                break;
            }
            // Checking Wheter Given input is an integer or not
            try {
                Float.parseFloat(temp1);
            } catch (NumberFormatException e) {
                System.out.println(RED + "X  Error: The Given Input Is Not  a Number" + RESET);
                continue;
            }
            // If input is integer than push than value into the vector
            eqn.add(temp1);
            // Takes Second Input from user
            System.out.print(YELLOW + "ADD >> " + RESET);
            temp2 = in.nextLine();
            if (temp2 == "") {
                break;
            }
            try {
                Float.parseFloat(temp2);
            } catch (NumberFormatException e) {
                System.out.println(RED + "X  Error: The Given Input Is Not  a Number" + RESET);
                continue;
            }
            eqn.add("+");
            eqn.add(temp2);
        } while (true);
    }

    public void add(String val)
    {
        eqn.add(val);
    }
    
    public void add(String val[])
    {
        for(int i=0;i<val.length;i++)
        {
            eqn.add(val[i]);
        }
    }

    // Function to perform substraction of multiple number
    // Functionality is similar to add function but instead of '+' sign '-' sign is
    // there
    public void sub() {
        char op = 0;
        System.out.println(CYAN + "Enter Operands: " + RESET);
        if (eqn.size() > 0) {
            eqn.add("-");
        }
        do {
            if (eqn.size() != 0)
                op = eqn.get(eqn.size() - 1).charAt(0);
            if (eqn.size() != 0 && (op != '-')) {
                eqn.add("-");
            }
            System.out.print(YELLOW + "SUB >> " + RESET);
            temp1 = in.nextLine();
            if (temp1 == "") {
                eqn.remove(eqn.size() - 1);
                break;
            }
            try {
                Float.parseFloat(temp1);
            } catch (NumberFormatException e) {
                System.out.println(RED + "X  Error: The Given Input Is Not  a Number" + RESET);
                continue;
            }
            if (eqn.size() == 0) { // Checks if the size of eqn is 0 or not if it is 0 than the first number
                                   // entered is set as negative number
                float t = Float.parseFloat(temp1);
                t = (-1) * t;
                temp1 = String.valueOf(t);
                eqn.add(temp1);
            } else
                eqn.add(temp1);
            System.out.print(YELLOW + "SUB >> " + RESET);
            temp2 = in.nextLine();
            if (temp2 == "") {
                break;
            }
            try {
                Float.parseFloat(temp2);
            } catch (NumberFormatException e) {
                System.out.println(RED + "X  Error: The Given Input Is Not  a Number" + RESET);
                continue;
            }
            eqn.add("-");
            eqn.add(temp2);
        } while (true);
    }

    // Function to perform Multiplication of multiple number
    // Functionality is similar to add function but instead of '+' sign '*' sign is
    // there
    public void mul() {
        if (eqn.size() > 0) {
            eqn.add("*");
        }
        char op = 0;
        System.out.println(CYAN + "Enter Operands: " + RESET);
        do {
            if (eqn.size() != 0)
                op = eqn.get(eqn.size() - 1).charAt(0);
            if (eqn.size() != 0 && (op != '*')) {
                eqn.add("*");
            }
            System.out.print(YELLOW + "MUL >> " + RESET);
            temp1 = in.nextLine();
            if (temp1 == "") {
                eqn.remove(eqn.size() - 1);
                break;
            }
            try {
                Float.parseFloat(temp1);
            } catch (NumberFormatException e) {
                System.out.println(RED + "X  Error: The Given Input Is Not  a Number" + RESET);
                continue;
            }
            eqn.add(temp1);
            System.out.print(YELLOW + "MUL >> " + RESET);
            temp2 = in.nextLine();
            if (temp2 == "") {
                break;
            }
            try {
                Float.parseFloat(temp2);
            } catch (NumberFormatException e) {
                System.out.println(RED + "X  Error: The Given Input Is Not  a Number" + RESET);
                continue;
            }
            eqn.add("*");
            eqn.add(temp2);
        } while (true);
    }

    // Function to perform Division of multiple number
    // Functionality is similar to add function but instead of '+' sign '/' sign is
    // there
    public void div() {
        char op = 0;
        System.out.println(CYAN + "Enter Operands: " + RESET);
        if (eqn.size() > 0) {
            eqn.add("/");
        }
        do {
            if (eqn.size() != 0)
                op = eqn.get(eqn.size() - 1).charAt(0);
            if (eqn.size() != 0 && (op != '/')) {
                eqn.add("/");
            }
            System.out.print(YELLOW + "DIV >> " + RESET);
            temp1 = in.nextLine();
            if (temp1 == "") {
                eqn.remove(eqn.size() - 1);
                break;
            }
            try {
                Float.parseFloat(temp1);
            } catch (NumberFormatException e) {
                System.out.println(RED + "X  Error: The Given Input Is Not  a Number" + RESET);
                continue;
            }
            eqn.add(temp1);
            System.out.print(YELLOW + "DIV >> " + RESET);
            temp2 = in.nextLine();
            if (temp2 == "") {
                break;
            }
            if (temp2.charAt(0) == '0') {
                System.out.println(RED + "X  Error: Cannot Divide By Zero" + RESET);
                eqn.remove(eqn.size() - 1);
                continue;
            }
            try {
                Float.parseFloat(temp2);
            } catch (NumberFormatException e) {
                System.out.println(RED + "X  Error: The Given Input Is Not  a Number" + RESET);
                continue;
            }
            eqn.add("/");
            eqn.add(temp2);
        } while (true);
    }

    // Function to manually input equation
    // e.g.: 10 + 12 - 3 * 2 q
    // All the operands and operators should be seperated by a space
    // Note: To exit this function enter q as last operand
    public void manualEquation() {
        String oper; // Stores the current operator
        System.out.println(YELLOW + "Enter The Equation: " + RESET);
        do {
            if (eqn.size() != 0) {
                oper = in.next();
                if (oper.charAt(0) == 'q') // If operator is q than exit function
                {
                    break;
                }
                if (oper.charAt(0) == '+' || oper.charAt(0) == '-' || oper.charAt(0) == '*' || oper.charAt(0) == '/') {
                    eqn.add(oper); // Checks wheter given operator is valid or not if it is valid than add the
                                   // operator into the eqn Vector
                } else {
                    System.out.println(RED + "X  Error: Given Input Not an Operator..." + RESET);
                    continue;
                }
            }
            temp1 = in.next(); // Operand 1
            if (temp1.charAt(0) == 'q') // If Operand 1 is q than exit this function
            {
                break;
            }
            try {
                Float.parseFloat(temp1); // Checks whether given number is valid number or not
                eqn.add(temp1); // Adds the given operand into eqn Vector if given number is valid
            } catch (NumberFormatException e) {
                System.out.println(RED + "X  Error: Given Input Is Not a Number..." + RESET); // Prints error message if given number
                                                                                // is not a valid number and continue
                                                                                // the loop
                continue;
            }
            oper = in.next(); // Inputs Operator
            if (oper.charAt(0) == 'q') // If operator is q than exit function
            {
                break;
            }
            if (oper.charAt(0) == '+' || oper.charAt(0) == '-' || oper.charAt(0) == '*' || oper.charAt(0) == '/') {
                eqn.add(oper); // Checks wheter given operator is valid or not if it is valid than add the
                               // operator into the eqn Vector
            } else {
                System.out.println(RED + "X  Error: Given Input Not an Operator..." + RESET);
                continue;
            }
            // Operand 2 similar to Operand 1
            temp2 = in.next(); // Stores Second Operand
            if (temp2.charAt(0) == 'q') {
                break;
            }
            try {
                Float.parseFloat(temp1);
                eqn.add(temp2);
            } catch (NumberFormatException e) {
                System.out.println(RED + "X  Error: Given Input Is Not a Number..." + RESET);
                continue;
            }
        } while (true);
    }

    // Function to calculate the total of the equation
    /*
     * Working Of Total function: 1. The function iterates through the eqn Vector if
     * operand is found it pushes it in operand[] stack and if operator is found
     * then it and current operator is '*' or '/' and the operator at top of
     * operator[] stack is '+' or '-' than it pushes it into the stack else if it is
     * '*' or '/' than it pop the first(top) operator from stack and also pops two
     * operands from the operand stack and carries operation on them based on the
     * popped operator and then pushes it back into the operand stack than pushes
     * the current operator into the stack.
     * 2. If the current operator is '+' or '-' and stack top is '*' or '/' than the
     * above operation is carried till the stack is empty and than pushes the
     * current operator
     * 3. The Above operation is performed from i=0 to i<eqn.size then after than in
     * while loop the above operation is carried till the stack is empty
     */
    public String total() {
        // Below class is implemented for stack
        // Class stack starts here
        class stack {
            int size;
            String op[];
            int top = -1;

            // Default Constructor to initialize stack size as 30
            public stack() {
                this.size = 30;
                op = new String[size];
            }

            // Parameterized Constructor to initialize stack size as given by user
            public stack(int size) {
                this.size = size;
                op = new String[size];
            }

            // Method to push the value into the stack
            public void push(String val) {
                if (top >= 100) {
                    System.out.println(RED + "Stack Overflow..." + RESET);
                    return;
                }
                top++;
                this.op[top] = val;
            }

            // Method to pop the top element from the stack and return the popped value
            public String pop() {
                if (top < 0) {
                    System.out.println(RED + "X  Error: Are You Sure Equation is Correct?" + RESET);
                    throw new ArithmeticException(RED + "Incorrect Equation..." + RESET);
                }
                top--;
                return op[top + 1];
            }

            // Checks Whether the given input is operator or not
            boolean isOperator() {
                if (op[top].charAt(0) == '+' || op[top].charAt(0) == '-' || op[top].charAt(0) == '*'
                        || op[top].charAt(0) == '/')
                    return true;
                return false;
            }

            // Returns the value at the top of stack
            char stackTop() {
                return op[top].charAt(0);
            }

            // Checks whether stack is empty or not
            boolean isEmpty() {
                if (top == -1) {
                    return true;
                }
                return false;
            }

            // Returns the 0 index element from the stack
            String stackBottom() {
                return op[0];
            }
        }
        // Stack class ends

        // Calculating total
        stack operand = new stack(); // Stores the operand into the stack
        stack operator = new stack(10); // Stores the operator into the stack
        float total = 0; // Stores total of current tow operand
        for (int i = 0; i < eqn.size(); i++) { // Loop through the eqn Vector
            if (operand.isEmpty() || operator.isEmpty()) { // Checks whether operand or operator stack is empty or not
                try { // Pushes Operands and Operators into their respective stack if either one of
                      // them is empty
                    Float.parseFloat(eqn.get(i));
                    operand.push(eqn.get(i));
                } catch (NumberFormatException e) {
                    operator.push(eqn.get(i));
                }
            } else if (eqn.get(i).charAt(0) == '+' || eqn.get(i).charAt(0) == '-') {
                if (operator.isOperator()) // Runs if operator stack is not empty
                {
                    // If Top of Operator stack is '+' then pops and adds the top two elements from
                    // the stack and then pushes the result again into the stack
                    if (operator.stackTop() == '+') {
                        temp2 = operand.pop();
                        temp1 = operand.pop();
                        total = Float.parseFloat(temp1) + Float.parseFloat(temp2);
                        temp1 = String.valueOf(total);
                        operand.push(temp1);
                    } else if (operator.stackTop() == '-') {
                        // If Top of Operator stack is '-' then pops and substracts the top two elements
                        // from the stack and then pushes the result again into the stack
                        temp2 = operand.pop();
                        temp1 = operand.pop();
                        total = Float.parseFloat(temp1) - Float.parseFloat(temp2);
                        temp1 = String.valueOf(total);
                        operand.push(temp1);
                    } else if (operator.stackTop() == '*') {
                        // If Top of Operator stack is '*' then pops and multiplies the top two elements
                        // from the stack and then pushes the result again into the stack
                        int j = 0;
                        while (!operator.isEmpty()) // If Top of stack is '*' than the operation is carried out till the
                                                    // stack not becomes empty
                        {
                            temp2 = operand.pop();
                            temp1 = operand.pop();
                            if (j >= 1) {
                                if (operator.stackTop() == '+') {
                                    total = Float.parseFloat(temp1) + Float.parseFloat(temp2);
                                    temp1 = String.valueOf(total);
                                } else if (operator.stackTop() == '-') {
                                    total = Float.parseFloat(temp1) - Float.parseFloat(temp2);
                                }
                            } else
                                total = Float.parseFloat(temp1) * Float.parseFloat(temp2);
                            temp1 = String.valueOf(total);
                            operand.push(temp1);
                            operator.pop();
                            j++;
                        }
                        operator.push(eqn.get(i)); // After carrying operation pushes the '+' or '-' into the stack
                        continue;
                    } else {
                        // If Top of Operator stack is '/' then pops and divides the top two elements
                        // from the stack and then pushes the result again into the stack
                        int k = 0;
                        while (!operator.isEmpty()) // If Top of stack is '/' than the operation is carried out till the
                                                    // stack not becomes empty
                        {
                            temp2 = operand.pop();
                            temp1 = operand.pop();
                            if (k >= 1) {
                                if (operator.stackTop() == '+') {
                                    total = Float.parseFloat(temp1) + Float.parseFloat(temp2);
                                    temp1 = String.valueOf(total);
                                } else if (operator.stackTop() == '-') {
                                    total = Float.parseFloat(temp1) - Float.parseFloat(temp2);
                                }
                            } else
                                total = Float.parseFloat(temp1) / Float.parseFloat(temp2);
                            temp1 = String.valueOf(total);
                            operand.push(temp1);
                            operator.pop();
                            k++;
                        }
                        operator.push(eqn.get(i)); // After carrying operation pushes the '+' or '-' into the stack
                        continue;
                    }
                }
                // Below two statements is available for '+' and '-' operators only after
                // carrying their respective operations
                operator.pop();
                operator.push(eqn.get(i));
            } else if (eqn.get(i).charAt(0) == '*') { // Carries the requied Operation and pushes '*' into the stack
                if (operator.stackTop() == '+' || operator.stackTop() == '-') { // If top of stack is '+' or '-' than
                                                                                // push '*' into the stack
                    operator.push("*");
                } else if (operator.stackTop() == '/') { // If top of stack is '/' than pop and divide top two elements
                                                         // from the Operand stack and push result into operand stack
                                                         // and than push the '*' into operator stack
                    temp2 = operand.pop();
                    temp1 = operand.pop();
                    total = Float.parseFloat(temp1) / Float.parseFloat(temp2);
                    temp1 = String.valueOf(total);
                    operator.pop();
                    operand.push(temp1);
                    operator.push("*");
                } else if (operator.stackTop() == '*') { // If top of stack is '*' than pop and multiply top two
                                                         // elements from the Operand stack and push result into operand
                                                         // stack and than push the '*' into operator stack
                    temp2 = operand.pop();
                    temp1 = operand.pop();
                    total = Float.parseFloat(temp1) * Float.parseFloat(temp2);
                    temp1 = String.valueOf(total);
                    operator.pop();
                    operand.push(temp1);
                    operator.push("*");
                }

            } else if (eqn.get(i).charAt(0) == '/') { // Carries required opeation and pushes '/' into the stack
                if (operator.stackTop() == '+' || operator.stackTop() == '-') { // If top of stack is '+' or '-' than
                                                                                // push '/' into the stack
                    operator.push("/");
                } else if (operator.stackTop() == '/') { // If top of stack is '/' than pop and divide top two elements
                                                         // from the Operand stack and push result into operand stack
                                                         // and than push the '/' into operator stack
                    temp2 = operand.pop();
                    temp1 = operand.pop();
                    total = Float.parseFloat(temp1) / Float.parseFloat(temp2);
                    temp1 = String.valueOf(total);
                    operator.pop();
                    operand.push(temp1);
                    operator.push("/");
                } else if (operator.stackTop() == '*') { // If top of stack is '*' than pop and multiply top two
                                                         // elements from the Operand stack and push result into operand
                                                         // stack and than push the '/' into operator stack
                    temp2 = operand.pop();
                    temp1 = operand.pop();
                    total = Float.parseFloat(temp1) * Float.parseFloat(temp2);
                    temp1 = String.valueOf(total);
                    operator.pop();
                    operand.push(temp1);
                    operator.push("/");
                }
            } else {
                operand.push(eqn.get(i)); // If None of above condition is true than the String at current position is
                                          // an operand so push it into the operand stack
            }
        }
        // Repeatedly Pop and carry required operation till the Operator stack becomes
        // empty
        while (!operator.isEmpty()) {
            temp2 = operand.pop();
            temp1 = operand.pop();
            if (operator.stackTop() == '+') {
                total = Float.parseFloat(temp1) + Float.parseFloat(temp2);
                temp1 = String.valueOf(total);
                operand.push(temp1);
            } else if (operator.stackTop() == '-') {
                total = Float.parseFloat(temp1) - Float.parseFloat(temp2);
                temp1 = String.valueOf(total);
                operand.push(temp1);
            } else if (operator.stackTop() == '*') {
                total = Float.parseFloat(temp1) * Float.parseFloat(temp2);
                temp1 = String.valueOf(total);
                operand.push(temp1);
            } else {
                total = Float.parseFloat(temp1) / Float.parseFloat(temp2);
                temp1 = String.valueOf(total);
                operand.push(temp1);
            }
            operator.pop();
        }
        // System.out.println("Total: " + operand.stackBottom()); // Prints the result
        return operand.stackBottom();
    }
}