public enum Languages {
    CZE("Czech language"),
    ENG("English language"),
    GER("German language"),
    FRE("French language");

    private String description;

    Languages(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}
