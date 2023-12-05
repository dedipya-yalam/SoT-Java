import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] leftvals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightvals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];
        if (args.length == 0) {
            for (int i = 0; i < opCodes.length; i++) {
                results[i] = execute(opCodes[i],leftvals[i], rightvals[i]);
            }

            for (double CurrentResult : results) {
                System.out.println(CurrentResult);
            }
        }
        else if(args.length==1 && args[0].equals("interactive"))
            executeInteractively();
        else if (args.length == 3)
            handleCommandLine(args);
        else
            System.out.println("Please provide an operation code and 2 numeric values ");

    }
    static void executeInteractively(){
        System.out.println("Enter an operation name and two numbers :");
        Scanner scanner=new Scanner(System.in);
        String userInput=scanner.nextLine();
        String[] parts=userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts){
        char opCode=opCodeFromString(parts[0]);
        if(opCode=='w')
            handleWhen(parts);
        else {
            double leftval = valueFromWord(parts[1]);
            double rightval = valueFromWord(parts[2]);
            double result = execute(opCode, leftval, rightval);
            dispalyResult(opCode, leftval, rightval, result);
        }
    }

    private static void handleWhen(String[] parts) {
        LocalDate startDate=LocalDate.parse(parts[1]);
        long daysToAdd= (long) valueFromWord(parts[2]);
        LocalDate newDate=startDate.plusDays(daysToAdd);
        String output=String.format("%s plus %d days is %s",startDate,daysToAdd,newDate);
        System.out.println(output);
    }

    private static void dispalyResult(char opCode, double leftval, double rightval, double result) {
        char symbol=symbolFromOpCode(opCode);
        String output=String.format("%.2f %c %.2f = %.2f",leftval,symbol,rightval,result);
        System.out.println(output);
    }

    private static char symbolFromOpCode(char opCode){
        char[] opCodes={'a','s','m','d'};
        char[] symbols={'+','-','*','/'};
        char symbol='i';
        for(int i=0;i<opCodes.length;i++){
            if(opCode==opCodes[i]){
                symbol=symbols[i];
                break;}
        }
        return symbol;
    }
    private static void handleCommandLine(String[] args) {
        char opCode=args[0].charAt(0);
        double leftval=Double.parseDouble(args[1]);
        double rightval=Double.parseDouble(args[2]);
        double result=execute(opCode,leftval,rightval);
        System.out.println(result);
    }

    static double execute(char opCode,double value1, double value2) {
        double result = 0.0d;
        switch (opCode) {
            case 'a':
                result = value1 + value2;
                break;
            case 's':
                result = value1 - value2;
                break;
            case 'm':
                result = value1 * value2;
                break;
            case 'd':
                result = (value2 != 0) ? (value1 / value2) : 0;
                break;
            default:
                System.out.println("invalid opcode:" + opCode + " try again!");
        }
        return result;
    }
    static char opCodeFromString(String operationName){
        return operationName.charAt(0);
    }

    static double valueFromWord(String word){
        String[] numberWords={"zero","one","two","three","four",
                "five","six","seven","eight","nine"};
        double value=-1d;
        for(int i=0;i<numberWords.length;i++){
            if(word.equals(numberWords[i])){
                value=i;
                break;
            }
        }
        if(value==-1d)
            value=Double.parseDouble(word);
        return value;
    }
}