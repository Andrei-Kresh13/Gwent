package com.example.gwent.logic_game.cards.commands.hooks;

import com.example.gwent.logic_game.cards.commands.SessionCommand;

public interface CommandHook<H extends SessionCommand> {
    /**
     * Defines a class , superclass or interface of the command that represents a hook trigger.
     * Every time hook trigger command is checked , the hook will be triggered.
     */
    Class<H> getHookTriggerCommandClass();

    /**
     * Called when hook is triggered
     *
     * @param hookCommand is a command that triggered the hook
     */
    void onHookTrigger(H hookCommand);
}
