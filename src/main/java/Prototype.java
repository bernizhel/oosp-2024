import java.util.Random;

interface DocumentPrototype {
    DocumentPrototype cloneDocument();
}

class TextDocument implements DocumentPrototype {
    private String content;

    public TextDocument(String content) {
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public DocumentPrototype cloneDocument() {
        return new TextDocument(this.content);
    }
}

class RandomDocumentGenerator {
    private static final String[] SAMPLE_TEXTS = {
            "Пример текста номер один",
            "Другой пример текста",
            "Еще один примерный текст",
            "Текст для примера четыре",
            "Пример текста пять"
    };

    public static TextDocument generateRandomDocument(TextDocument prototype) {
        Random random = new Random();
        int rndIndex = random.nextInt(SAMPLE_TEXTS.length);
        TextDocument newDocument = (TextDocument) prototype.cloneDocument();
        newDocument.setContent(SAMPLE_TEXTS[rndIndex]);
        return newDocument;
    }

    public static void main(String[] args) {
        TextDocument prototype = new TextDocument("Исходный текст");
        System.out.println("Исходный документ: " + prototype.getContent());

        TextDocument document1 = generateRandomDocument(prototype);
        System.out.println("Документ 1: " + document1.getContent());

        TextDocument document2 = generateRandomDocument(prototype);
        System.out.println("Документ 2: " + document2.getContent());

        TextDocument document3 = generateRandomDocument(prototype);
        System.out.println("Документ 3: " + document3.getContent());
    }
}