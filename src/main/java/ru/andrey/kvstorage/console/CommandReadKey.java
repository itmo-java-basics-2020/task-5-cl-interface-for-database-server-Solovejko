package ru.andrey.kvstorage.console;

public class CommandReadKey implements DatabaseCommand {
    private final ExecutionEnvironment environment;
    private final String databaseName;
    private final String tableName;
    private final String key;

    public CommandReadKey(ExecutionEnvironment environment, String... arg) {
        this.environment = environment;
        this.databaseName = arg[0];
        this.tableName = arg[1];
        this.key = arg[2];
    }

    @Override
    public DatabaseCommandResult execute() {
        try {
            String value = environment.getDatabase(databaseName).get().read(tableName, key);

            if (value == null) {
                return DatabaseCommandResult.error("Key not found");
            }

            return DatabaseCommandResult.success("Value = " + value);
        } catch (Exception error) {
            return DatabaseCommandResult.error(error.getMessage());
        }
    }

}