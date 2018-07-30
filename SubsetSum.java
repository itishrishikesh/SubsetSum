import java.util.*;
class State{
    int w; //weight
    int s; //sum
    int[] v = new int[]{0,0,0,0,0,0}; //visited array
    public State(int w, int s){
        this.w = w;
        this.s = s;
    }
    public boolean checkIfVisited(int i){
        if(v[i] == 1) return true;
        else return false;
    }
}
public class SubsetSum{
    public static State[] visited = new State[100];
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size, goal, sum = 0;
        int[] w = new int[100];

        System.out.print("\nEnter Size of array: ");
        size = scanner.nextInt();

        System.out.println("\nEnter weight of each element:\n");
        for(int i=0;i<size;i++){
            w[i] = scanner.nextInt();
            sum = w[i] + sum;
        }

        System.out.println("\nEnter the subset sum:");
        goal = scanner.nextInt();

        Stack st = new Stack();

        State startState = new State(0, sum);

        st.push(startState);

        while(!st.empty()){

            State s = (State) st.pop();

            System.out.print("-->("+s.w+","+s.s+")");

            if(s.s == goal) break;

            for(int i=size-1;i>=0;i--){

                if(!s.checkIfVisited(i) && s.s >= goal){
                    State ss = new State(w[i], s.s - w[i]);
                    st.push(ss);
                    ss.v[i] = 1;
                }
            }
        }    
    }
}