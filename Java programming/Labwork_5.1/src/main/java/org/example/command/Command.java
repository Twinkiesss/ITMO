package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.OutputManager;

public interface Command {
    void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager);
}