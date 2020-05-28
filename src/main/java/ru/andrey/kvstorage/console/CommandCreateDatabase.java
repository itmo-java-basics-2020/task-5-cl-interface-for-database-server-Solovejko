package ru.andrey.kvstorage.console;

public class CommandCreateDatabase implements DatabaseCommand {
    private final ExecutionEnvironment environment;
    private final String name;

    public CommandCreateDatabase(ExecutionEnvironment environment, String name) {
        this.environment = environment;
        this.name = name;
    }

    @Override
    public DatabaseCommandResult execute() {
        if (environment.getDatabase(name).isPresent()){
            return DatabaseCommandResult.error("Database if already exists");
        } else {
            environment.addDatabase(null);
            return DatabaseCommandResult.success("Database was created");
        }
    }
}