interface CloudStorage {
    void uploadFile(String fileName);
    void downloadFile(String fileName);
    void deleteFile(String fileName);
}

class GoogleDriveAdapter implements CloudStorage {
    private final GoogleDriveAPI googleDriveAPI;

    public GoogleDriveAdapter(GoogleDriveAPI googleDriveAPI) {
        this.googleDriveAPI = googleDriveAPI;
    }

    @Override
    public void uploadFile(String fileName) {
        googleDriveAPI.uploadFileToGoogleDrive(fileName);
    }

    @Override
    public void downloadFile(String fileName) {
        googleDriveAPI.downloadFileFromGoogleDrive(fileName);
    }

    @Override
    public void deleteFile(String fileName) {
        googleDriveAPI.deleteFileFromGoogleDrive(fileName);
    }
}

class DropboxAdapter implements CloudStorage {
    private final DropboxAPI dropboxAPI;

    public DropboxAdapter(DropboxAPI dropboxAPI) {
        this.dropboxAPI = dropboxAPI;
    }

    @Override
    public void uploadFile(String fileName) {
        dropboxAPI.uploadFileToDropbox(fileName);
    }

    @Override
    public void downloadFile(String fileName) {
        dropboxAPI.downloadFileFromDropbox(fileName);
    }

    @Override
    public void deleteFile(String fileName) {
        dropboxAPI.deleteFileFromDropbox(fileName);
    }
}

class OneDriveAdapter implements CloudStorage {
    private final OneDriveAPI oneDriveAPI;

    public OneDriveAdapter(OneDriveAPI oneDriveAPI) {
        this.oneDriveAPI = oneDriveAPI;
    }

    @Override
    public void uploadFile(String fileName) {
        oneDriveAPI.uploadFileToOneDrive(fileName);
    }

    @Override
    public void downloadFile(String fileName) {
        oneDriveAPI.downloadFileFromOneDrive(fileName);
    }

    @Override
    public void deleteFile(String fileName) {
        oneDriveAPI.deleteFileFromOneDrive(fileName);
    }
}

class GoogleDriveAPI {
    public void uploadFileToGoogleDrive(String fileName) {
        System.out.println("Загрузка файла " + fileName + " в Google Drive");
    }

    public void downloadFileFromGoogleDrive(String fileName) {
        System.out.println("Скачивание файла " + fileName + " из Google Drive");
    }

    public void deleteFileFromGoogleDrive(String fileName) {
        System.out.println("Удаление файла " + fileName + " из Google Drive");
    }
}

class DropboxAPI {
    public void uploadFileToDropbox(String fileName) {
        System.out.println("Загрузка файла " + fileName + " в Dropbox");
    }

    public void downloadFileFromDropbox(String fileName) {
        System.out.println("Скачивание файла " + fileName + " из Dropbox");
    }

    public void deleteFileFromDropbox(String fileName) {
        System.out.println("Удаление файла " + fileName + " из Dropbox");
    }
}

class OneDriveAPI {
    public void uploadFileToOneDrive(String fileName) {
        System.out.println("Загрузка файла " + fileName + " в OneDrive");
    }

    public void downloadFileFromOneDrive(String fileName) {
        System.out.println("Скачивание файла " + fileName + " из OneDrive");
    }

    public void deleteFileFromOneDrive(String fileName) {
        System.out.println("Удаление файла " + fileName + " из OneDrive");
    }
}

public class Adapter {
    public static void main(String[] args) {
        CloudStorage googleDriveAdapter = new GoogleDriveAdapter(new GoogleDriveAPI());
        CloudStorage dropboxAdapter = new DropboxAdapter(new DropboxAPI());
        CloudStorage oneDriveAdapter = new OneDriveAdapter(new OneDriveAPI());

        googleDriveAdapter.uploadFile("file.txt");
        dropboxAdapter.uploadFile("file.txt");
        oneDriveAdapter.uploadFile("file.txt");

        googleDriveAdapter.downloadFile("file.txt");
        dropboxAdapter.downloadFile("file.txt");
        oneDriveAdapter.downloadFile("file.txt");

        googleDriveAdapter.deleteFile("file.txt");
        dropboxAdapter.deleteFile("file.txt");
        oneDriveAdapter.deleteFile("file.txt");
    }
}