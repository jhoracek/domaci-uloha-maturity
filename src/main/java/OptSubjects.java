public enum OptSubjects {
    MAT("Math"),
    PHY("Physics"),
    HIS("History"),
    GEO("Geography");

    private String description;

    OptSubjects(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}
