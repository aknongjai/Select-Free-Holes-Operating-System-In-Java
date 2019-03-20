import java.util.Scanner;
class data{
    public int n=5;//holes
    public int m=4;//process;
    public Scanner s=new Scanner(System.in);
    public int holeSize[]=new int[10];
    public static int backup[]=new int[10];
    public int processSize[]=new int[10];
    public void getHoleSize(){
        System.out.println("Enter holes");
        for(int i=0;i<n;i++){
            holeSize[i]=s.nextInt();
            backup[i]=holeSize[i];
        }
    }
    public void getProcessSize(){
        System.out.println("Enter process");
        for(int i=0;i<m;i++)
        processSize[i]=s.nextInt();
    }
}
public class FreeHoleStrategies {
    private static data d=new data();
    static void holes(){
        d.getHoleSize();
        d.getProcessSize();
    }
    static void firstFit(){
        for (int i=0;i<d.m;i++){
            for(int k=0;k<d.n;k++){
            if((d.processSize[i]<=d.holeSize[k])){
                System.out.println(d.processSize[i]+" allocated at "+d.holeSize[k]);
                d.holeSize[k]=(d.holeSize[k]-d.processSize[i]);
                break;
//                d.processSize[i]=0;
//                for(int j=0;j<d.n;j++){
//                    if((d.holeSize[j]>=d.processSize[j])&&(d.processSize[j]!=0)){
//                        System.out.println(j+"th process fitting and allocated at "+d.holeSize[j]);
//                        d.holeSize[j]=(d.holeSize[j]-d.processSize[j]);
//                        d.processSize[j]=0;
//                    }
//                }
            }
            }
        }
    }

    static void worstFit(){
        for(int i=0;i<d.m;i++){
            for(int u=0;u<5;u++){
                int temp;
                for(int v=u+1;v<5;v++){
                    if(d.backup[u]<d.backup[v]){
                        temp=d.backup[u];
                        d.backup[u]=d.backup[v];
                        d.backup[v]=temp;
                    }
                }
            }
        for(int j=0;j<d.n;j++){
            System.out.println("\n value "+d.backup[j]);
            if(d.processSize[i]<=d.backup[j]){
                System.out.println(d.processSize[i]+" at"+d.backup[j]);
                d.backup[j]=d.backup[j]-d.processSize[i];
                break;
            }
            break;
        }
        }
    }
    public static void main(String [] args){
        holes();
        firstFit();
        worstFit();

    }
}
/*All Rights Reserved
Nongjaimayum Annas khan
Husband of Ph Tabasum Sahani
*/