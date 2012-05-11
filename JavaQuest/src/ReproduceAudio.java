

import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Ejemplo de reproducción de ficheros de sonido.
 * @author chuidiang
 * http://www.chuidiang.com
 */
public class ReproduceAudio {

    /**
     * Abre un fichero de sonido wav y lo reproduce
     * @param args
     */
    public static void main(String[] args) {
        try {
            
            // Se obtiene un Clip de sonido
            Clip sonido = AudioSystem.getClip();
            
            // Se carga con un fichero wav
            sonido.open(AudioSystem.getAudioInputStream(new File("musica.wav")));
            
            // Comienza la reproducción
            sonido.start();
            
            // Espera mientras se esté reproduciendo.
            while (sonido.isRunning())
                Thread.sleep(1000);
            
            // Se cierra el clip.
            sonido.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }

 
    }

}

