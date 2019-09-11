import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

class Solution{
    public static boolean a11(String s){
        Hashtable <Character,Character> hashtable=
                new Hashtable <Character,Character>();

        for (int i=0; i<s.length();i++){
            if (hashtable.contains(s.charAt(i))){return false;}
            else{hashtable.put(s.charAt(i),s.charAt(i));}
        }
        return true;
    }
    public static boolean a12(String s1, String s2){
        if(s1.length()!=s2.length())return false;
        Hashtable<Character,Integer> h1=new Hashtable();
        Hashtable<Character,Integer> h2=new Hashtable();
        for( int i=0; i<s1.length();i++){

            if (h1.containsKey(s1.charAt(i))) {

                h1.put(s1.charAt(i), h1.get(s1.charAt(i) )+1);
            }else{
                h1.put(s1.charAt(i), 1);
            }
        }
        for( int i=0; i<s2.length();i++){

            if (h2.containsKey(s2.charAt(i))) {

                h2.put(s2.charAt(i), h2.get(s2.charAt(i) )+1);
            }else{
                h2.put(s2.charAt(i), 1);
            }
        }
        System.out.println(h1);
        System.out.println(h2);

        for( Character key: h1.keySet())if (h1.get(key)!=h2.get(key))return false;


        return true;
    }
    public static String a13(String s){
        String r="";
        for(int i=0;i<s.length();i++){
            String t=s.charAt(i)+"";
            if(s.charAt(i)==' ') t="%20";
            r=r+t;
        }
        return r;
    }
    public static boolean a14(String s){
        Hashtable<Character,Integer> h=new Hashtable<>();
        int index=0;
        for (int i=0; i<s.length();i++){
            if(s.charAt(i)!=' '){
                if (!h.containsKey(s.charAt(i))){
                    h.put(s.charAt(i), 1);
                }
                else {
                    h.put(s.charAt(i), h.get(s.charAt(i)) + 1);
                }
            }
        }
        for (Character key: h.keySet()){
            if (index>1) return false;
            if (h.get(key)==1) index++;
            else if(h.get(key)%2==1) return false;
        }
        return true;

    }
    public static boolean a15(String s1, String s2){

        if(Math.abs(s1.length()-s2.length())>1) return false;
        int i=0,j=0,l,err=0;
        if(s1.length()>=s2.length())l=s1.length();
        else l=s2.length();

        for(int a =0;a<l;a++){

            if(err>1)return false;
            System.out.println(i+" "+j+" "+err);
            System.out.println(s1.charAt(i)+" "+s2.charAt(j));
            if(s1.charAt(i)!=s2.charAt(j)){
                err++;
                if(s1.length()>s2.length())i++;
                else if(s1.length()==s2.length()){ i++;j++;}
                else j++;
            }else {
                i++;
                j++;
            }

        }
        return true;
    }
    public static String a16(String s){
        Hashtable<Character,Integer> h=new Hashtable<>();
        int count=0;
        String r="";
        for (int i=0;i<s.length();i++){
            if(!h.containsKey(s.charAt(i)))h.put(s.charAt(i),1);
            else h.put((s.charAt(i)),h.get(s.charAt(i))+1);
        }
        for(Character key : h.keySet()){
            if(count>s.length()-2)return s;
            if(h.get(key)==1)count++;
            r=r+key+h.get(key);
        }
        return r;
    }
    public static void a17(String[][] m){
        String [][]r=new String [m.length][m.length];
        for (int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                r[i][j]=m[m.length-j-1][i];

            }

        }
        for (int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){

                System.out.print(r[i][j]+",");
            }
            System.out.println("");

    }


}
    public static void a18(int[][] m) {
        boolean [] rows=new boolean[m.length];
        boolean [] columns=new boolean[m[0].length];


        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if(m[i][j]==0){rows[i]=true;columns[j]=true;}
            }
        }
        for(int i=0;i< rows.length;i++){
            if(rows[i]){
                for(int j=0;j<m[0].length;j++){
                    m[i][j]=0;
                }
            }
        }
        for(int i=0;i< columns.length;i++){
            if(rows[i]){
                for(int j=0;j<m.length;j++){
                    m[j][i]=0;
                }
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

                System.out.print(m[i][j] + ",");
            }
            System.out.println("");
        }


    }
    public static void a18(String s1,String s2){
        //isSubstring(s1+s1+"",s1);
    }
    public static LinkedList<Object>  a21(LinkedList<Object>l){
        Hashtable<Object,Integer>h=new Hashtable<>();
        Iterator<Object> it=l.iterator();
        /*while(it.hasNext()){
            Object el=it.next();
            if(!h.containsKey(el)){h.put(el,1);}
            else{l.remove(el);}

        }*/
        //buffer not allowed

        while(it.hasNext()){
            Object el=it.next();
            Iterator<Object> it2=l.iterator();
            while(it2.hasNext()){
                Object el2=it2.next();
                if(el==el2)l.remove(el2);
            }

        }
        return l;
    }

}
public class Main {
    public static void main(String[] args) {
        //Arrays and Strings
        /*String a11_test1="ciao";//output true

        String a11_test2="ciaoo";//output false
        //System.out.println(Solution.a11(a11_test2));
        String a12_s1="aba";
        String a12_s2="abc";
        String a12_s3="bac";
        System.out.println(Solution.a12(a12_s2,a12_s3));
        // s1+s2= false s1+s3=true
        String a13_s1="ciao ciao ciao";
        //System.out.println(Solution.a13(a13_s1));
        String a14_s1="tact coa";
        String a14_s2="ossso";
        //System.out.println(Solution.a14(a14_s2));
        String a15_s1="pale";
        String a15_s2="ple";
        String a15_s3="bale";
        String a15_s4="plea";
        //System.out.println(Solution.a15(a15_s1,a15_s4));
        String a16_s1="aabcccccaaa";
        String a16_s2="abc";
        //System.out.println(Solution.a16(a16_s1));
        String[][] a17_s1={
                {"a","b","c"},
                {"d","e","f"},
                {"g","h","i"}
        };
        //Solution.a17(a17_s1);
        int[][] a18_s1={
                {1,2},
                {3,0},
                {5,6}
        };
        //Solution.a18(a18_s1);
        */
        //Linked Lists
        LinkedList<Object> a21_s1=new LinkedList<>();
        a21_s1.add("a");
        a21_s1.add("b");
        a21_s1.add("c");
        a21_s1.add("a");
        a21_s1.add("b");
        //System.out.println(Solution.a21(a21_s1));

    }
}
