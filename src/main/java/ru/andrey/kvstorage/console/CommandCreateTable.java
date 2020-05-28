package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CommandCreateTable implements DatabaseCommand {
    private final ExecutionEnvironment environment;
    private final String databaseName;
    private final String tableName;

    public CommandCreateTable(ExecutionEnvironment environment, String [] arg) {
        this.environment = environment;
        this.databaseName = arg[0];
        this.tableName = arg[1];
    }

    @Override
    public DatabaseCommandResult execute() {
        Optional<Database> database = environment.getDatabase(databaseName);
        if (database.isPresent()) {
            try {
                environment.getDatabase(databaseName).get().createTableIfNotExists(tableName);
                return DatabaseCommandResult.success("Table was created");
            } catch (Exception error) {
                return DatabaseCommandResult.error(error.getMessage());
            }
        } else {
            return DatabaseCommandResult.error("No table with given name");
        }
    }
}