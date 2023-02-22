package serenityswag.authentication;
//
//        standard_user
//        locked_out_user
//        problem_user
//        performance_glitch_user

public enum User {
    STANDARD_USER("standard_user", "secret_sauce", "the standard user"),
    LOCKED_OUT_USER("locked_out_user", "secret_sauce", "the locked out user"),
    PROBLEM_USER("problem_user", "secret_sauce", "a problem user"),
    PERFORMANCE_GLITCH_USER("performance_glitch_user", "secret_sauce", "a performance glitch user");

    private final String username;
    private final String password;
    private final String definition;


    User(String username, String password, String definition) {
        this.username = username;
        this.password = password;
        this.definition = definition;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDefinition() {
        return definition;
    }

    @Override
    public String toString() {
        return definition;
    }
}
