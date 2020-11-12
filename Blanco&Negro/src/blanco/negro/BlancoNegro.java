/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blanco.negro;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author alew_
 */
public class BlancoNegro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ruta = "C:/Users/alew_/Documents/NetBeansProjects/Blanco&Negro/src/cuphead.jpg";
        
        try {
            BufferedImage img = ImageIO.read(new File(ruta));
            int base = 128;
            Color Negro = new Color(0,0,0);
            Color Blanco = new Color(255,255,255);
            
            //Ancho
            for(int x=0; x< img.getWidth(); x++){
            
                //alto
                for(int y=0; y< img.getHeight();y++){
                    int rgb=img.getRGB(x, y);
                    Color color=new Color(rgb);
                    
                    //Promedio de los colores
                    int gris=(color.getRed()+color.getGreen()+color.getBlue())/3;

                    if(gris<base){
                        img.setRGB(x,y,Negro.getRGB());
                    }else{
                        img.setRGB(x,y,Blanco.getRGB());
                    }
                }
            }
            ImageIO.write(img, "jpeg",
            new File("C:/Users/alew_/Documents/NetBeansProjects/Blanco&Negro/src/cuphead2.jpg"));
        
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
