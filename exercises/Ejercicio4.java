public class Ejercicio4 {

    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();

        player.play("song.mp3");
        player.play("movie.mp4");
        player.play("audio.wav");
        player.play("video.avi");
    }
}

class MediaPlayer {
    public void play(String filename) {
        String extension = filename.substring(filename.lastIndexOf('.') + 1);

        if (extension.equals("mp3")) {
            System.out.println("Reproduciendo MP3: " + filename);
        } else if (extension.equals("wav")) {
            System.out.println("Reproduciendo WAV: " + filename);
        } else {
            AdvancedMediaPlayer advancedPlayer = new AdvancedMediaPlayer();
            if (extension.equals("mp4")) {
                advancedPlayer.playMp4(filename);
            } else if (extension.equals("avi")) {
                advancedPlayer.playAvi(filename);
            } else {
                System.out.println("Formato " + extension + " no soportado");
            }
        }
    }
}

class AdvancedMediaPlayer {
    public void playMp4(String filename) {
        System.out.println("Reproduciendo MP4: " + filename);
    }

    public void playAvi(String filename) {
        System.out.println("Reproduciendo AVI: " + filename);
    }
}