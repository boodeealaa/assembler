/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;
import java.util.*;


/**
 *
 * @author ASC
 */
public class Assembler {

  
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        
        
        int inttloc=0;
    
       Scanner read =new Scanner(System.in);
       System.out.println("enter the nuber of line of the code");
       int l=read.nextInt();
      OpTable  op=new OpTable();
       String[][] readableArray = new String[l][6];
       int decimal = 0;
        
       for (int i=0;i<l;i++){
      System.out.println("enter the lable line"+(i+1));
      readableArray[i][1]=read.next();
      System.out.println("enter the Operation line"+(i+1));
      readableArray[i][2]=read.next();
      System.out.println("enter the Operand line"+(i+1));
      readableArray[i][3]=read.next();
       
     }
        for (int i=0;i<l;i++){
      
           String loc = null;
           if(readableArray[i][2].equals("RESB"))
           { 
            int e;
            e = Integer.parseInt(readableArray[i][3]); 
            loc=Integer.toHexString(inttloc);
           readableArray[i][0]=loc;
            inttloc=inttloc+e;
            }
           else if(readableArray[i][2].equals("BYTE"))
           {
               int length = readableArray[i][3].length();
                loc=Integer.toHexString(inttloc);
                readableArray[i][0]=loc;
                inttloc=inttloc+length;
           }
           else if (readableArray[i][2].equals("RESW"))
           {
               int e;
                e = Integer.parseInt(readableArray[i][3].trim()); 
                loc=Integer.toHexString(inttloc);
                readableArray[i][0]=loc;
                inttloc=inttloc+(3*e);
           }
           else{
              
            loc=Integer.toHexString(inttloc);
            readableArray[i][0]=loc;
             inttloc=inttloc+3;
            } 
        }
          for(int i=0;i<l;i++)
          {
              int length = readableArray[i][0].length();
              if(length==1)
              readableArray[i][0]="000"+readableArray[i][0];
               if(length==2)
              readableArray[i][0]="00"+readableArray[i][0];
                if(length==3)
              readableArray[i][0]="0"+readableArray[i][0];
              
          }
      
      for(int i=0;i<l;i++)
      {
     if(readableArray[i][3].contains(",x"))
           readableArray[i][4]=",x";
     else
         readableArray[i][4]="  ";
        String[] arrx = readableArray[i][3].split(",x", 2); 
            readableArray[i][3]=arrx[0];
          }
          

      
         
      for (int i=0; i<l ; i++)
      { for(int j=0;j<9;j++){
       if(readableArray[i][2].equals(op.oppcode[j][1])){
      readableArray[i][5]=op.oppcode[j][0];}}
     
      for(int j=0;j<l;j++)
      { if(readableArray[i][3].equals(readableArray[j][1]))
      readableArray[i][5]=readableArray[i][5]+readableArray[j][0];
      }
            }
       for (int i=0;i<l;i++){
        if(readableArray[i][4].equals(",x"))
        {
       decimal=Integer.parseInt(readableArray[i][5],16);
       decimal= decimal +32768;
       readableArray[i][5]=Integer.toHexString(decimal);
        }
       }
      System.out.println("Loc\tLabel\tOperation  Operand   opcode ");
          
      for (int i=0;i<l;i++)
          {
              if(readableArray[i][4].equals(",x"))
               System.out.println(readableArray[i][0]+"\t"+readableArray[i][1]+" \t  "+readableArray[i][2]+"    \t  "+readableArray[i][3]+readableArray[i][4]+" \t "+readableArray[i][5]);
          else
                  System.out.println(readableArray[i][0]+"\t"+readableArray[i][1]+" \t  "+readableArray[i][2]+"    \t  "+readableArray[i][3]+" \t "+readableArray[i][5]);
          }
     
       
    }  
}
          

   
