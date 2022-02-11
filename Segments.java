    import java.util.ArrayList;
    import java.util.Comparator;
    import java.util.HashSet;
    import java.util.Scanner;
     
    public class Segments {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int numSeg = sc.nextInt();
            ArrayList<Endpoint> endpoints = new ArrayList<>(numSeg * 2);
            for(int i = 0; i < numSeg; i++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                endpoints.add(new Endpoint(i, Math.min(n1, n2), 0));
                endpoints.add(new Endpoint(i, Math.max(n1, n2), 1));
            }
            endpoints.sort( (a, b) -> 10 * (a.loc - b.loc) + a.oc - b.oc );
            HashSet<Integer> opened = new HashSet<>();
            HashSet<Integer> closed = new HashSet<>();
            ArrayList<Integer> nails = new ArrayList<>();
            for(int i = 0; i < endpoints.size(); i++){
                Endpoint curEP = endpoints.get(i);
                //if(curEP.oc == 1 && !closed.contains(curEP)){
                if(curEP.oc == 0){
                    opened.add(curEP.id);
                }else{
                    if(!closed.contains(curEP.id)) {
                        nails.add(curEP.loc);
                        for (int id : opened)
                            closed.add(id);
                        opened.clear();
                    }
                }
            }
            System.out.println(nails.size());
            String r = "";
            for (int n: nails) r += n + " ";
            System.out.println(r);
        }
    }
    class Endpoint{
        int id;
        int loc;
        int oc;
        Endpoint(int id, int loc, int oc){
            this.id = id;
            this.loc = loc;
            this.oc = oc;
        }
    }
