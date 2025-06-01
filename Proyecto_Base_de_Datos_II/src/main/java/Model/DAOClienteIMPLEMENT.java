/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DatabaseModels.*;
import Interfaces.*;
import Database.*;


/**
 *
 * @author Fabrizio
 */
public class DAOClienteIMPLEMENT extends Cliente implements DAOCliente{

    //Constructor que invoca a los atributos de la clase en la carpeta 'DatabaseModels'
    public DAOClienteIMPLEMENT(int ID_Cliente, String Nombre_Cliente, int DNI_Cliente, String Correo_Cliente, int Telefono_Cliente) {
        super(ID_Cliente, Nombre_Cliente, DNI_Cliente, Correo_Cliente, Telefono_Cliente);
    }

    @Override
    public void registrar(Cliente cliente) throws Exception{
        try {
            
        } catch (Exception e) {
            
        }
    }
    
}
