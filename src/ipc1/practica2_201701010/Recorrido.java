package ipc1.practica2_201701010;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Recorrido extends Thread{
    JLabel vehiculo;
    int distancia;
    boolean regreso;
    
    //VerRecorrido vr = new VerRecorrido();
    final int posDestino = VerRecorrido.DestinoLbl.getLocation().x;

    public Recorrido(JLabel vehiculo, int distancia) {
        this.vehiculo = vehiculo;
        this.distancia = distancia;
        this.regreso = false;
    }
    
    @Override
    public void run(){
        while(true){
            try
            {
                //Delay
                sleep(10 * distancia);
                
                //Obtener posición del vehículo
                int vehiculoPosX = vehiculo.getLocation().x;
                
                //si va de ida
                if(!regreso){
                    //Si no ha llegado al destino
                    if (vehiculoPosX < posDestino - 145){
                        //Avanzar Vehículo
                        vehiculo.setLocation(vehiculoPosX + 10, vehiculo.getLocation().y);
                    }else{
                        regreso = true;
                    }
                }else{
                    //De regreso
                    //Si no ha llegado al inicio
                    if (vehiculoPosX > 100){
                        //Retroceder Vehículo
                        vehiculo.setLocation(vehiculoPosX - 10, vehiculo.getLocation().y);
                    }else{
                        break;
                    }
                }
                
            } catch (Exception e){
                System.out.println(e);
            }
            
            
        }
    }
    
    
    
}
