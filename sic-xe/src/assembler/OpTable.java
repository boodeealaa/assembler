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
public class OpTable {
    
     String [][]oppcode = new String[][]
        {
            {"14", "STL"},
            
            {"48", "JSUB"},
            
            {"00", "LDA"},
            
            {"28", "COMP"},
            
            {"30", "JEQ"},
            
            {"3C", "J"},
            
            {"0C", "STA"},
            
            {"08", "LDL"},
            
            {"4C", "RSUB"},
            
            {"    ","BYTE"}};
   
}
