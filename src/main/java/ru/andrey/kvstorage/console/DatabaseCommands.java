package ru.andrey.kvstorage.console;

public enum DatabaseCommands {
    CREATE_DATABASE {
        public DatabaseCommand getCommand(ExecutionEnvironment environment, String... args) {
            if (args.length != 1) {
                throw new IllegalArgumentException("Requires 1 argument");
            }

            return new CreateDatabase(environment, args[0]);
        }
    }, CREATE_TABLE {
        public DatabaseCommand getCommand(ExecutionEnvironment environment, String... args) {
            if (args.length != 2) {
                throw new IllegalArgumentException("Requires 2 arguments");
            }

            return new CreateTable(environment, args);
        }
    }, UPDATE_KEY {
        public DatabaseCommand getCommand(ExecutionEnvironment environment, String... args) {
            if (args.length != 4) {
                throw new IllegalArgumentException("Requires 4 arguments");
            }

            return new UpdateKey(environment, args);
        }
    }, READ_KEY {
        public DatabaseCommand getCommand(ExecutionEnvironment environment, String... args) {
            if (args.length != 3) {
                throw new IllegalArgumentException("Requires 3 arguments");
            }

            return new ReadKey(environment, args);
        }
    };

    public abstract DatabaseCommand getCommand(ExecutionEnvironment environment, String... args);
}