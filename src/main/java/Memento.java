import java.util.ArrayList;
import java.util.List;

class Document {
    private String text;
    private String font;
    private int fontSize;

    public Document(String text, String font, int fontSize) {
        this.text = text;
        this.font = font;
        this.fontSize = fontSize;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public IMemento createMemento() {
        return new IMemento(text, font, fontSize);
    }

    public void restore(IMemento IMemento) {
        this.text = IMemento.text();
        this.font = IMemento.font();
        this.fontSize = IMemento.fontSize();
    }

    public record IMemento(String text, String font, int fontSize) {
    }
}

class DocumentHistory {
    private final List<Document.IMemento> mementos;
    private int currentIndex;

    public DocumentHistory() {
        this.mementos = new ArrayList<>();
        this.currentIndex = -1;
    }

    public void addMemento(Document.IMemento IMemento) {
        mementos.add(IMemento);
        currentIndex++;
    }

    public Document.IMemento getMemento(int index) {
        if (index < 0 || index >= mementos.size()) {
            return null;
        }
        return mementos.get(index);
    }

    public Document.IMemento undo() {
        if (currentIndex > 0) {
            currentIndex--;
            return mementos.get(currentIndex);
        }
        return null;
    }

    public Document.IMemento redo() {
        if (currentIndex < mementos.size() - 1) {
            currentIndex++;
            return mementos.get(currentIndex);
        }
        return null;
    }
}

public class Memento {
    public static void main(String[] args) {
        Document document = new Document("Текст документа", "Arial", 12);

        DocumentHistory history = new DocumentHistory();
        history.addMemento(document.createMemento());

        document.setText("Новый текст документа");
        history.addMemento(document.createMemento());

        document.setFont("Times New Roman");
        history.addMemento(document.createMemento());

        System.out.println("Текущее состояние документа:");
        System.out.println("Текст: " + document.getText());
        System.out.println("Шрифт: " + document.getFont());
        System.out.println("Размер шрифта: " + document.getFontSize());

        document.restore(history.undo());
        System.out.println("Состояние документа после Undo:");
        System.out.println("Текст: " + document.getText());
        System.out.println("Шрифт: " + document.getFont());
        System.out.println("Размер шрифта: " + document.getFontSize());

        document.restore(history.redo());
        System.out.println("Состояние документа после Redo:");
        System.out.println("Текст: " + document.getText());
        System.out.println("Шрифт: " + document.getFont());
        System.out.println("Размер шрифта: " + document.getFontSize());
    }
}