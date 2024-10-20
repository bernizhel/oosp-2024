abstract class Camera {
    protected Recorder recorder;

    public Camera(Recorder recorder) {
        this.recorder = recorder;
    }

    public abstract void startRecording();
    public abstract void stopRecording();
}

class FrontCamera extends Camera {
    public FrontCamera(Recorder recorder) {
        super(recorder);
    }

    @Override
    public void startRecording() {
        System.out.println("Фронтальная камера: начало записи");
        recorder.startRecording();
    }

    @Override
    public void stopRecording() {
        System.out.println("Фронтальная камера: остановка записи");
        recorder.stopRecording();
    }
}

class BackCamera extends Camera {
    public BackCamera(Recorder recorder) {
        super(recorder);
    }

    @Override
    public void startRecording() {
        System.out.println("Задняя камера: начало записи");
        recorder.startRecording();
    }

    @Override
    public void stopRecording() {
        System.out.println("Задняя камера: остановка записи");
        recorder.stopRecording();
    }
}

class Camera3D extends Camera {
    public Camera3D(Recorder recorder) {
        super(recorder);
    }

    @Override
    public void startRecording() {
        System.out.println("3D-камера: начало записи");
        recorder.startRecording();
    }

    @Override
    public void stopRecording() {
        System.out.println("3D-камера: остановка записи");
        recorder.stopRecording();
    }
}

abstract class Recorder {
    public abstract void startRecording();
    public abstract void stopRecording();
}

class MP4Recorder extends Recorder {
    @Override
    public void startRecording() {
        System.out.println("Начало записи в формате MP4");
    }

    @Override
    public void stopRecording() {
        System.out.println("Остановка записи в формате MP4");
    }
}

class AVIRecorder extends Recorder {
    @Override
    public void startRecording() {
        System.out.println("Начало записи в формате AVI");
    }

    @Override
    public void stopRecording() {
        System.out.println("Остановка записи в формате AVI");
    }
}

public class Bridge {
    public static void main(String[] args) {
        Recorder mp4Recorder = new MP4Recorder();
        Recorder aviRecorder = new AVIRecorder();

        Camera frontCameraMP4 = new FrontCamera(mp4Recorder);
        Camera backCameraAVI = new BackCamera(aviRecorder);
        Camera camera3DMP4 = new Camera3D(mp4Recorder);

        frontCameraMP4.startRecording();
        frontCameraMP4.stopRecording();

        backCameraAVI.startRecording();
        backCameraAVI.stopRecording();

        camera3DMP4.startRecording();
        camera3DMP4.stopRecording();
    }
}