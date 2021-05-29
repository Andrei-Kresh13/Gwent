package com.example.gwent.gamelogic.commands.composite;


import com.example.gwent.gamelogic.commands.BaseSessionCommand;
import com.example.gwent.gamelogic.utils.LogUtils;


/**
 * Created by Yan-Home on 12/21/2014.
 * <p/>
 * This is the last command that is going to be executed during the game
 */
public class FinishGameCommand extends BaseSessionCommand {

    private int mLoosingPlayerIndex;

    @Override
    public void execute() {
        LogUtils.log("GAME IS OVER !!! Losing player is " + mLoosingPlayerIndex);
        //TODO : any finishing operations can happen here...
    }


    public void setLoosingPlayerIndex(final int loosingPlayerIndex) {
        mLoosingPlayerIndex = loosingPlayerIndex;
    }

    public int getLoosingPlayerIndex() {
        return mLoosingPlayerIndex;
    }
}
