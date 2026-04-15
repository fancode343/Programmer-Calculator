package Calculator;

public class Debug{
    void main(String[] Args) {
        Solve Solve = new Solve();
        AI AI = new AI();
        //System.out.println(NewPEMDAS("5(3x3)"I));

        String problem = "5(8x(5(400-200x9x9x9x9x9(2+2))x5(5-2)÷4))";
        String MyAlgo = Solve.PEMDAS(problem);
        String Ai = AI.PEMDAS(problem);
        System.out.println("My Algo Answer: "+MyAlgo);
        System.out.println("AI "+Ai);
    }
}
