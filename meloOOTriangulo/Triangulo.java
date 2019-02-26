/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meloOOTriangulo;

/**
 *
 * @author aluno
 */
public class Triangulo {
    
    public int ladoA;
    public int ladoB;
    public int ladoC;
    
    public String getMessage(){
        
        if (formaTriangulo() == true){
            return retornaTipoTriangulo();
        }
        
    
    }
    
    private String retornaTipoTriangulo(){
    return "";
    }
    
    private boolean formaTriangulo(){
    return true;
    }
    
    private String retornaProblemaTriangulo(){
    return "";
    }
    
    
}
