import java.util.List;
import java.util.Arrays;

class Project {
    private final String name;
    private final String description;
    private final List<String> participants;
    private final String deadline;

    private Project(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.participants = builder.participants;
        this.deadline = builder.deadline;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public String getDeadline() {
        return deadline;
    }

    public static class Builder {
        private String name;
        private String description;
        private List<String> participants;
        private String deadline;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setParticipants(List<String> participants) {
            this.participants = participants;
            return this;
        }

        public Builder setDeadline(String deadline) {
            this.deadline = deadline;
            return this;
        }

        Project build() {
            return new Project(this);
        }
    }
}

public class Builder {
    public static void main(String[] args) {
        Project project = new Project.Builder()
                .setName("Новый проект")
                .setDescription("Описание проекта")
                .setParticipants(Arrays.asList("Участник1", "Участник2"))
                .setDeadline("31.12.2023")
                .build();

        System.out.println("Проект: " + project.getName());
        System.out.println("Описание: " + project.getDescription());
        System.out.println("Участники: " + String.join(", ", project.getParticipants()));
        System.out.println("Дедлайн: " + project.getDeadline());
    }
}