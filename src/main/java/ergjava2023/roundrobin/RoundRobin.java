/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ergjava2023.roundrobin;

import static java.lang.Math.random;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author frag.pel
 */
public class RoundRobin {
    public static final int kvanto_xronou=5;
    public static void main(String[] args) {
        int ar_dierg = 10 ;
        Scanner scanner = new Scanner(System.in);
        //int pinakas [][] = new int[ar_dierg][4];
// dhmiourgw enan pinaka o opoios einai disdiasastos , kathe grammh einai kai mia diaforetikh diergasia enw kathe stilh einai o xronos afikshs, o xronos kataigismou kai h protaireothta ths diergasias.
//0h sthlh to id ths diergasias
//1h sthlh to arrival time
//2h sthlh to burst time ths diergasias
//3h sthkh to priority ths diergasia
//4h sthlh to remaining burst time.
//5h to total response time
//6h to completed 0= oxi completed , 1= completed
//7h pote oloklhrwthike , poia xronikh stigmh.


System.out.print("Eisigage ton arithmo twn diergasiwn: ");
ar_dierg=scanner.nextInt();
int pinakas[][]=new int[ar_dierg][8];

//int pinakas [][] = {
//            {1,0,6,7,6,99,0,101},
//            {2,4,6,4,6,99,0,101},
//            {3,7,10,3,10,99,0,101},
//            {4,12,3,5,3,99,0,101},
//            {5,12,9,2,9,99,0,101},
//            {6,0,4,2,4,99,0,101}};
        Random random = new Random();
        
        for(int i=0;i< pinakas.length;i++)
        {
           
                pinakas[i][0]=i+1;
                pinakas[i][1]=random.nextInt(20);
                pinakas[i][2]=random.nextInt(20)+1;
                pinakas[i][3]=random.nextInt(7)+1;
                pinakas[i][4]=pinakas[i][2];
                pinakas[i][5]=99;
                pinakas[i][6]=0;
                pinakas[i][7]=101;
            
        }
        //gemisma pinaka
       
       
       
        
        System.out.println("Process ID\tArrival Time\tBurst Time\tPriority");
        for (int i = 0; i < pinakas.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(pinakas[i][j] + "\t\t");
            }
            System.out.println();  // Move to the next line after each row
        }
        
        Queue running = new Queue(55);
        Queue[] queues = new Queue[8];

        // Initializing each queue in the array
       
             queues[0] = new Queue(10);
             queues[1] = new Queue(10);
             queues[2] = new Queue(10);
             queues[3] = new Queue(10);
             queues[4] = new Queue(10);
             queues[5] = new Queue(10);
             queues[6] = new Queue(10);
             queues[7] = new Queue(10);
             
             
             

        
        boolean oloklhrwsh=true;
        int xronos=0;
        FindMin findMinInstance = new FindMin();
         int minimumInSecondColumn = findMinInstance.findMinimumInSecondColumn(pinakas);
         System.out.println("min="+minimumInSecondColumn);
         
        
      for (int j = 0; j < 7; j++) {
            System.out.println("Queue " + (j + 1) + " elements: ");
            queues[j].queueDisplay();
            System.out.println();
        }
         
         boolean monomiadiergasia=true;
         int id_mikroterhs_prot;
         
        while(oloklhrwsh && xronos<200)
        {
            System.out.println("\nGia Xrono "+xronos);
            if(xronos>=minimumInSecondColumn)
            {
                    for (int i = 0; i < pinakas.length; i++) 
                    {
                    if (pinakas[i][1]/*art*/ <= xronos)
                        {
                        boolean idExists = Exists.doesIdExist(queues[pinakas[i][3]], pinakas[i][0]);
                        if (!idExists && pinakas[i][6]==0) 
                            {
                            queues[pinakas[i][3]].queueEnqueue(pinakas[i][0]);
                            System.out.print("\nUpdated queue " + pinakas[i][3] + " elements: ");
                            queues[pinakas[i][3]].queueDisplay();
                            }
                        }
                    }
                    for(int i=1;i<8;i++) //edw elegxoume kathe mia oura 
                    {
                        if(!queues[i].isEmpty() && monomiadiergasia)
                        {
                            monomiadiergasia=false;
                            id_mikroterhs_prot = queues[i].queueDequeue();
                            if(pinakas[id_mikroterhs_prot-1][6]==0)//ama den exei oloklhrwthei
                            {
                                running.queueEnqueue(id_mikroterhs_prot);//tote vazoume sthn oura running to id ths diergasias
                                System.out.println("\nCPU");
                                running.queueDisplay();
                                queues[i].queueDequeue();
                                
                                if(pinakas[id_mikroterhs_prot-1][2]==pinakas[id_mikroterhs_prot-1][4])
                                    {
                                    pinakas[id_mikroterhs_prot-1][5]=xronos-pinakas[id_mikroterhs_prot-1][1];
                                    pinakas[id_mikroterhs_prot-1][4]=pinakas[id_mikroterhs_prot-1][4]-kvanto_xronou;
                                    }
                                else
                                    {
                                    pinakas[id_mikroterhs_prot-1][4]=pinakas[id_mikroterhs_prot-1][4]-kvanto_xronou;
                                    }
                                if(pinakas[id_mikroterhs_prot-1][4]<=0)
                                {
                                     pinakas[id_mikroterhs_prot-1][6]=1; // H diergasia exei oloklhrwthei.
                                     pinakas[id_mikroterhs_prot-1][7]=xronos-pinakas[id_mikroterhs_prot-1][1];
                                     System.out.println("H diergasia me id "+id_mikroterhs_prot+" molis oloklhrwtike.");
                                     if(add_column6(pinakas)==ar_dierg)
                                         oloklhrwsh=false;
                                     //queues[i].deleteX(6);
                                }

                            }
                        }
                
            }
            }
            xronos=xronos+kvanto_xronou;
            monomiadiergasia=true;
            
        }
        System.out.println("");
        
        //System.out.println("Response Time: "+pinakas[6-1][5]);
        System.out.println("\nCPU:");;
        running.queueDisplay();
        
              for (int j = 1; j < 8; j++)
                {
                    System.out.println("Queue " + (j) + " elements: ");
                    queues[j].queueDisplay();
                    System.out.println();
                }
     
              
              
        double avgrt=0.0;
        int totalresponsetime=0;
        for(int i=0;i<pinakas.length;i++)
        {
            totalresponsetime= totalresponsetime+pinakas[i][5];
            //System.out.println("\n\t"+pinakas[i][5]);
        }
        
        double sumOfTurnAroundTime=0.0;
        for(int i=0;i<pinakas.length;i++)
        {
            sumOfTurnAroundTime=sumOfTurnAroundTime+pinakas[i][7];
            //System.out.println("\n\t"+pinakas[i][7]);
        }
        double avrgtat=0.0;
        avrgtat=sumOfTurnAroundTime/ar_dierg;
            
        avgrt=(double)totalresponsetime/ar_dierg;
        System.out.println("Average Response Time ="+avgrt);
        System.out.println("Average Turnaround Time ="+avrgtat);
        // Close the Scanner to avoid resource leaks
        scanner.close();
        
        //System.out.println(""+add_column6(pinakas)); 
    }
    
    public static int add_column6(int pin[][])
    {
        int sum=0;
        for(int i=0;i<pin.length;i++)
        {
            sum=sum+pin[i][6];
        }
        return sum;
    }
}
