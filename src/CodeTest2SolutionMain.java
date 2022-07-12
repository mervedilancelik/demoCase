import java.util.*;


public class CodeTest2SolutionMain {

    public static void main(String[] args) {
        String data = "8\n" +
                "4 0 2\n" +
                "0 1 6\n" +
                "2 3 7\n" +
                "1 5\n" +
                "6 5\n" +
                "3 5\n" +
                "7 5";

        System.out.println(calculateLesson(data));
    }

    public static List<Integer> calculateLesson(String data) {
        String[] parsedData = data.split("\n");
        int lessonCount = Integer.parseInt(parsedData[0]);
        List<Lesson> lessons = generateLessons(lessonCount);
        relateLessons(parsedData, lessons);
        return takeLessons(lessons);

    }

    private static List<Lesson> generateLessons(int lessonCount) {
        List<Lesson> lessons = new ArrayList<>();
        for (int i = 0; i < lessonCount; i++) {
            lessons.add(new Lesson(i, new ArrayList<>(), false));
        }
        return lessons;
    }

    private static void relateLessons(String[] parsedData, List<Lesson> lessons) {
        for (String parsedDatum : parsedData) {
            String[] lessonsRel = parsedDatum.split(" ");
            if (lessonsRel.length >= 2) {
                Lesson lesson = lessons.stream()
                        .filter(l -> l.getIndex() == Integer.parseInt(lessonsRel[0]))
                        .findFirst()
                        .orElseThrow();

                List<Integer> dependencies = new ArrayList<>();
                for (int i = 1; i < lessonsRel.length; i++) {
                    dependencies.add(Integer.parseInt(lessonsRel[i]));
                }

                lesson.setDependencies(dependencies);

            }
        }

    }

    public static List<Integer> takeLessons(List<Lesson> lessons) {

        List<Integer> takenLesson = new ArrayList<>();

        while (takenLesson.size() != lessons.size()) {
            List<Lesson> potantionalLesson = new ArrayList<>();

            for (Lesson lesson : lessons) {
                if (lesson.getDependencies().isEmpty() && !lesson.isTaken()) {
                    potantionalLesson.add(lesson);
                } else if (!lesson.getDependencies().isEmpty() && !lesson.isTaken() && takenLesson.containsAll(lesson.getDependencies())) {
                    potantionalLesson.add(lesson);
                }

            }
            Collections.sort(potantionalLesson);
            Lesson minLesson = potantionalLesson.stream().sorted().findFirst().orElseThrow();

            takenLesson.add(minLesson.getIndex());
            minLesson.setTaken(true);
        }

        return takenLesson;
    }
}
