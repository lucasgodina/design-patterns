public class Ejercicio4 {

    public static void main(String[] args) {
        ReproductorMedia reproductor = new ReproductorMedia();

        reproductor.reproducir("cancion.mp3");
        reproductor.reproducir("pelicula.mp4");
        reproductor.reproducir("audio.wav");
        reproductor.reproducir("video.avi");
    }
}

class ReproductorMedia {
    public void reproducir(String nombreArchivo) {
        String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf('.') + 1);

        if (extension.equals("mp3")) {
            System.out.println("Reproduciendo MP3: " + nombreArchivo);
        } else if (extension.equals("wav")) {
            System.out.println("Reproduciendo WAV: " + nombreArchivo);
        } else {
            ReproductorMediaAvanzado reproductorAvanzado = new ReproductorMediaAvanzado();
            if (extension.equals("mp4")) {
                reproductorAvanzado.reproducirMp4(nombreArchivo);
            } else if (extension.equals("avi")) {
                reproductorAvanzado.reproducirAvi(nombreArchivo);
            } else {
                System.out.println("Formato " + extension + " no soportado");
            }
        }
    }
}

class ReproductorMediaAvanzado {
    public void reproducirMp4(String nombreArchivo) {
        System.out.println("Reproduciendo MP4: " + nombreArchivo);
    }

    public void reproducirAvi(String nombreArchivo) {
        System.out.println("Reproduciendo AVI: " + nombreArchivo);
    }
}