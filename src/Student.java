public class Student {
    private String name;
    private String id;
    private int mathScore;
    private int scienceScore;
    private int englishScore;

    public Student(String name, String id, int mathScore, int scienceScore, int englishScore) {
        this.name = name;
        this.id = id;
        this.mathScore = mathScore;
        this.scienceScore = scienceScore;
        this.englishScore = englishScore;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getScienceScore() {
        return scienceScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public double getAverage() {
        return (mathScore + scienceScore + englishScore) / 3.0;
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else return "F";
    }

    // Converts student data to a CSV line for saving to file
    public String toCsv() {
        return name + "," + id + "," + mathScore + "," + scienceScore + "," + englishScore;
    }

    // Creates a Student object from a CSV line read from file
    public static Student fromCsv(String csvLine) {
        String[] parts = csvLine.split(",");
        return new Student(parts[0], parts[1],
                Integer.parseInt(parts[2]),
                Integer.parseInt(parts[3]),
                Integer.parseInt(parts[4]));
    }
}