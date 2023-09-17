/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

/**
 *
 * @author ASC
 */
public class code {
    int l ;
    String[][] xxx = new String[l][4];
code(int l)
{
    this.l=l;
}
void displaycode()
   {
      System.out.println("Location \t Label \t Operation \t Operand ");
          for (int i=0;i<l;i++)
          {
               System.out.println(xxx[i][0]+"\t"+xxx[i][1]+"\t"+xxx[i][2]+"\t"+xxx[i][3]);
          }
   }
}

