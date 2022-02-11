    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Scanner;
     
    public class BerSU {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int numStud = sc.nextInt();
            int totTime = sc.nextInt();
            int timeLeft = totTime;
     
            int[] times = new int[numStud];
            int[] ret = new int[numStud];
            ArrayList<Integer> studs = new ArrayList<>(numStud);
            for(int i = 0; i < numStud; i++) {
                times[i] = sc.nextInt();
            }
            for(int i = 0; i < numStud; i++) {
                int numFailing = 0;
                int curStudTime = times[i];
                int j = studs.size() - 1;
                int timeSaved = 0;
                while(timeLeft - curStudTime + timeSaved < 0){
                    timeSaved += studs.get(j);
                    numFailing += 1;
                    j -= 1;
                }
                ret[i] = numFailing;
                timeLeft -= curStudTime;
                putInList(studs, curStudTime);
            }
            String r = "";
            for (int n: ret) r += n + " ";
            System.out.println(r);
        }
        static void putInList(ArrayList<Integer> list, int num){
            if(list.size() == 0) list.add(num);
            else{
                int l = -1;
                int r = list.size();
                while (r - l > 1){
                    int med = (r + l) / 2;
                    if(list.get(med) <= num)
                        l = med;
                    else
                        r = med;
                }
                list.add(r, num);
            }
        }
    }
