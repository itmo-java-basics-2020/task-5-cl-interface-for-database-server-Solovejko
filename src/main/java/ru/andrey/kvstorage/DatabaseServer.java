package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.DatabaseCommands;
import ru.andrey.kvstorage.console.ExecutionEnvironment;

import java.util.Arrays;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        if (commandText == null) {
            return DatabaseCommandResult.error("Empty command");
        }

        String[] args = commandText.split(" ");

        try {
            return DatabaseCommands.valueOf(args[0]).getCommand(env, Arrays.copyOfRange(args, 1, args.length)).execute();
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}