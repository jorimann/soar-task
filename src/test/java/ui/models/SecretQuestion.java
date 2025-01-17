package ui.models;

public enum SecretQuestion {
    MOTHERS_MAIDEN_NAME("Mother's maiden name?"),
    YOUR_FAVORITE_MOVIE("Your favorite movie?");

    private final String name;

    SecretQuestion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}