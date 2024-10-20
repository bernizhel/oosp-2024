abstract class Slide {
    protected String name;

    public Slide(String name) {
        this.name = name;
    }

    public abstract void display();
}

class TextSlide extends Slide {
    private final String text;

    public TextSlide(String name, String text) {
        super(name);
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println("Текстовый слайд: " + name);
        System.out.println("Текст: " + text);
    }
}

class GraphicSlide extends Slide {
    private final String imagePath;

    public GraphicSlide(String name, String imagePath) {
        super(name);
        this.imagePath = imagePath;
    }

    @Override
    public void display() {
        System.out.println("Графический слайд: " + name);
        System.out.println("Изображение: " + imagePath);
    }
}

class VideoSlide extends Slide {
    private final String videoPath;

    public VideoSlide(String name, String videoPath) {
        super(name);
        this.videoPath = videoPath;
    }

    @Override
    public void display() {
        System.out.println("Видео-слайд: " + name);
        System.out.println("Видео: " + videoPath);
    }
}

abstract class SlideFactory {
    public abstract Slide createSlide(String name, String content);
}

class TextSlideFactory extends SlideFactory {
    @Override
    public Slide createSlide(String name, String content) {
        return new TextSlide(name, content);
    }
}

class GraphicSlideFactory extends SlideFactory {
    @Override
    public Slide createSlide(String name, String content) {
        return new GraphicSlide(name, content);
    }
}

class VideoSlideFactory extends SlideFactory {
    @Override
    public Slide createSlide(String name, String content) {
        return new VideoSlide(name, content);
    }
}

class Presentation {
    private final Slide[] slides;

    public Presentation(int size) {
        this.slides = new Slide[size];
    }

    public void addSlide(Slide slide, int index) {
        if (index >= 0 && index < slides.length) {
            slides[index] = slide;
        }
    }

    public void display() {
        for (Slide slide : slides) {
            if (slide != null) {
                slide.display();
            }
        }
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        SlideFactory textFactory = new TextSlideFactory();
        SlideFactory graphicFactory = new GraphicSlideFactory();
        SlideFactory videoFactory = new VideoSlideFactory();

        Slide textSlide = textFactory.createSlide("Текстовый слайд", "Это текстовый слайд");
        Slide graphicSlide = graphicFactory.createSlide("Графический слайд", "path_to_image.jpg");
        Slide videoSlide = videoFactory.createSlide("Видео-слайд", "path_to_video.mp4");

        Presentation presentation = new Presentation(3);
        presentation.addSlide(textSlide, 0);
        presentation.addSlide(graphicSlide, 1);
        presentation.addSlide(videoSlide, 2);

        presentation.display();
    }
}