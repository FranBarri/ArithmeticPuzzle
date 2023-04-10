package audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {

	public static void sonidoGano() {
		try {
			String rutaDelDirectorio = System.getProperty("user.dir");
			String rutaConCarpeta = rutaDelDirectorio + "/sonidos/";
			String rutaCarpetaYAudio = rutaConCarpeta+"victoria.wav";			
			reproducirArchivoDeSonido(rutaCarpetaYAudio);
		} catch (Exception a) {
			a.printStackTrace();
		}
	}

	public static void sonidoPerdio() {
		try {
			String rutaDelDirectorio = System.getProperty("user.dir");
			String rutaConCarpeta = rutaDelDirectorio + "/sonidos/";
			String rutaCarpetaYAudio = rutaConCarpeta+"derrota.wav";			
			reproducirArchivoDeSonido(rutaCarpetaYAudio);
		} catch (Exception a) {
			a.printStackTrace();
		}
	}

	public static void sonidoInicio() {
		try {
			String rutaDelDirectorio = System.getProperty("user.dir");
			String rutaConCarpeta = rutaDelDirectorio + "/sonidos/";
			String rutaCarpetaYAudio = rutaConCarpeta+"start.wav";			
			reproducirArchivoDeSonido(rutaCarpetaYAudio);
		} catch (Exception a) {
			a.printStackTrace();
		}
	}
	public static void sonidoClick() {
		try {
			String rutaDelDirectorio = System.getProperty("user.dir");
			String rutaConCarpeta = rutaDelDirectorio + "/sonidos/";
			String rutaCarpetaYAudio = rutaConCarpeta+"click.wav";			
			reproducirArchivoDeSonido(rutaCarpetaYAudio);
		} catch (Exception a) {
			a.printStackTrace();
		}
	}
	public static void sonidoBorrar() {
		try {
			String rutaDelDirectorio = System.getProperty("user.dir");
			String rutaConCarpeta = rutaDelDirectorio + "/sonidos/";
			String rutaCarpetaYAudio = rutaConCarpeta+"borrar.wav";			
			reproducirArchivoDeSonido(rutaCarpetaYAudio);
		} catch (Exception a) {
			a.printStackTrace();
		}
	}
	
	private static void reproducirArchivoDeSonido(String rutaCarpetaYAudio)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File archivoDeAudio = new File(rutaCarpetaYAudio);
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		Clip clip;

		stream = AudioSystem.getAudioInputStream(archivoDeAudio);
		format = stream.getFormat();
		info = new DataLine.Info(Clip.class, format);
		clip = (Clip) AudioSystem.getLine(info);
		clip.open(stream);
		clip.start();
	}
}