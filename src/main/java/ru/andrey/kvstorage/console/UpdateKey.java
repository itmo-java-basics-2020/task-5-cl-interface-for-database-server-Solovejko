package ru.andrey.kvstorage.console;

public class UpdateKey implements DatabaseCommand {
    private final ExecutionEnvironment environment;
    private final String databaseName;
    private final String tableName;
    private final String key;
    private final String value;

    public UpdateKey(ExecutionEnvironment environment, String... arg) {
        this.environment = environment;
        this.databaseName = arg[0];
        this.tableName = arg[1];
        this.key = arg[2];
        this.value = arg[3];
    }

    @Override
    public DatabaseCommandResult execute() {
        try {
            environment.getDatabase(databaseName).get().write(tableName, key, value);
            return DatabaseCommandResult.success("Key updated");
        } catch (Exception error) {
            return DatabaseCommandResult.error(error.getMessage());
        }
    }
}