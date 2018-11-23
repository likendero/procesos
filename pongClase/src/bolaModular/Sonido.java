/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolaModular;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class Sonido {
    public static AudioClip SOUNDPELOTA = Applet.newAudioClip(Sonido.class.getResource("/sound/ball.wav"));
    public static AudioClip SOUNDGAMEOVER = Applet.newAudioClip(Sonido.class.getResource("/sound/gameover.wav"));
            
}
