/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Fabrizio
 */
public class DatabaseNOSQL {

    //Programacion de conexion aqui:
    public static MongoDatabase conectar() {

        String uri = "mongodb://localhost:27017";

        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("dbproyectobasededatosii");

        System.out.println("Conexion exitosa");

        return mongoDatabase;
    }

}
