package com.example.gwent.gamelogic.commands.custom;


import com.example.gwent.gamelogic.cards.Card;
import com.example.gwent.gamelogic.commands.BaseSessionCommand;
import com.example.gwent.gamelogic.player.IPlayer;


/**
 * Created by Yan-Home on 12/21/2014.
 * <p/>
 * Player chooses one card to start the attack with.
 */
public class PlayerAttackRequestCommand extends BaseSessionCommand {

    private int mAttackingPlayerIndex;
    private int mDefendingPlayerIndex;
    private Card mChosenCardForAttack;

    @Override
    public void execute() {
        final IPlayer attackingPlayer = getGameSession().getPlayers().get(mAttackingPlayerIndex);

        //get from player the card he would like to attack with
        mChosenCardForAttack = attackingPlayer.getCardForAttack();

    }

    public void setAttackingPlayerIndex(final int attackingPlayerIndex) {
        mAttackingPlayerIndex = attackingPlayerIndex;
    }

    public void setDefendingPlayerIndex(final int defendingPlayerIndex) {
        mDefendingPlayerIndex = defendingPlayerIndex;
    }

    public Card getChosenCardForAttack() {
        return mChosenCardForAttack;
    }

    public int getDefendingPlayerIndex() {
        return mDefendingPlayerIndex;
    }

    public int getAttackingPlayerIndex() {
        return mAttackingPlayerIndex;
    }
}