package ru.andrey.kvstorage.console;

public class CreateTable implements DatabaseCommand {
    private final ExecutionEnvironment environment;
    private final String databaseName;
    private final String tableName;

    public CreateTable(ExecutionEnvironment environment, String [] arg) {
        this.environment = environment;
        this.databaseName = arg[0];
        this.tableName = arg[1];
    }

    @Override
    public DatabaseCommandResult execute() {
        try {
            environment.getDatabase(databaseName).get().createTableIfNotExists(tableName);
            return DatabaseCommandResult.success("Table was created");
        } catch (Exception error) {
            return DatabaseCommandResult.error(error.getMessage());
        }
    }
}