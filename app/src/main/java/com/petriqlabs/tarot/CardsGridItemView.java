package com.petriqlabs.tarot;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by Peter on 4. 4. 2015.
 */
public class CardsGridItemView extends ImageView {
    //region Fields

    private Card mCard;

    //endregion

    //region Constructors

    public CardsGridItemView(Context context, Card card) {
        super(context);
        setCard(card);
    }

    //endregion

    //region Getters

    public Card getCard() {
        return mCard;
    }

    //endregion

    //region Setters

    public void setCard(Card card) {
        this.mCard = card;
        this.setImageResource(card.getImageResourceId());
        this.setContentDescription(card.getName());
    }

    //endregion
}
