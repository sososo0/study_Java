import java.util.Arrays;
import java.util.Scanner;

enum StringCommand{
    ADD,SORT,REMOVE,CLEAN,QUIT,INVALID
}
public class StringSetManager {
    public static void main(String[] args){

        final Scanner scnnaner = new Scanner(System.in);
        String[] stringSet = new String[100];

        while(true){

            String total = scnnaner.nextLine();
            String[] tots = total.split("\\s");

            if(tots.length == 1){
                String a0=total;
                String a = a0.toUpperCase();
                final StringCommand command = getCommand(a);
                if(command==StringCommand.QUIT){
                    System.out.println("BYE!");
                    break;
                }else if(command==StringCommand.CLEAN){
                    stringSet = clean();
                    print(stringSet);
                }else{
                    System.out.println("Invalid");
                }
            }else{
                String a0 = tots[0];
                String b = tots[1];
                String a = a0.toUpperCase();
                final StringCommand command = getCommand(a);

                switch (command){
                    case ADD: {
                        final String str = getString(b);
                        stringSet = add(stringSet,str);
                        print(stringSet);
                        break;
                    }
                    case SORT:{
                        final String order = getString(b);
                        stringSet = sort(stringSet,order);
                        print(stringSet);
                        break;
                    }
                    case REMOVE:{
                        final String str = getString(b);
                        stringSet = remove(stringSet,str);
                        print(stringSet);
                        break;
                    }
                }
            }
        }
    }
    private static StringCommand getCommand(String a){
        if(a.equals(StringCommand.ADD.name())){
            return StringCommand.ADD;
        }else if(a.equals(StringCommand.SORT.name())){
            return StringCommand.SORT;
        }else if(a.equals(StringCommand.REMOVE.name())){
            return StringCommand.REMOVE;
        }else if(a.equals(StringCommand.CLEAN.name())){
            return StringCommand.CLEAN;
        }else if(a.equals(StringCommand.QUIT.name())){
            return StringCommand.QUIT;
        }else return StringCommand.INVALID;
    }
    private static String getString(String b){
        return b;
    }
    private static String[] add(String[] a, String b){
        String[] a2 = new String[1];
        int aLength = a.length+a2.length;
        String[] aL = new String[aLength];

        int cnt = 0;
        for(int i =0;i<a.length;i++){
            if(a[i]!=null){
                cnt++;
            }
        }
        a2[0] = b;
        System.arraycopy(a,0,aL,0,cnt);
        System.arraycopy(a2,0,aL,cnt,a2.length);

        int cnt2 = 0;
        for(int i=0;i<aL.length;i++){
            if(aL[i]!=null){
                cnt2++;
            }
        }
        String[] a1 = Arrays.copyOfRange(aL,0,cnt2);

        if(a1.length>=1){
            int count = 0;
            for(int j=0; j<a1.length;j++){
                if(a1[j].equals(b)){
                    count++;
                }
            }
            if(count>=2){
                System.out.print("Element Size: "+a.length+", Values = ");
                return a;
            }else{
                System.out.print("Element Size: "+a1.length+", Values = ");
                return a1;
            }
        }return a1;
    }
    private static String[] sort(String[]a, String b){
        if(b.equals("ASC")){
            int n = a.length;
            String temp = a[0];
            a[0] = a[n-1];

            for(int i=n-2;i>=0;i--){
                a[i+1]=a[i];
            }
            a[1]=temp;
        }else if(b.equals("DESC")){
            int n = a.length;
            String temp = a[n-1];
            a[n-1] = a[0];

            for(int i=0;i<=n-2;i++){
                a[i]=a[i+1];
            }
            a[n-2] = temp;
        }
        System.out.print("Element Size: "+a.length+", Values = ");
        return a;
    }
    private static String[] remove(String[] a,String b){
        int index = Arrays.binarySearch(a,b);
        if(index>=0){
            int aLength = a.length+a.length;
            String[] aL = new String[aLength];
            System.arraycopy(a,0,aL,0,index);
            System.arraycopy(a,index+1,aL,index,a.length-index-1);

            int cnt2 = 0;
            for(int i =0;i<aL.length;i++){
                if(aL[i]!=null){
                    cnt2++;
                }
            }
            String[] a2 = Arrays.copyOfRange(aL,0,cnt2);
            System.out.print("Element Size: "+a2.length+", Values = ");
            return a2;
        }
        else{
            System.out.print("Element Size: "+a.length+", Values = ");
            return a;
        }
    }
    private static String[] clean(){
        String[] a1 = new String[0];
        System.out.print("Element Size: "+a1.length+", Values = ");
        return a1;
    }
    private static void print(String[] a){
        System.out.println(Arrays.toString(a));
    }
}