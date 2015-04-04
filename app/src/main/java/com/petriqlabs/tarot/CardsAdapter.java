package com.petriqlabs.tarot;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Peter on 4. 4. 2015.
 */
public class CardsAdapter extends BaseAdapter {

    //region Fields

    private Context mContext;
    private Resources mRes;
    private final Card[] mCards;

    //endregion

    //region Constructors

    public CardsAdapter(Context c) {
        mContext = c;
        mRes = c.getResources();
        mCards = new Card[] {
            new Card( 0, R.drawable.card00, mRes.getString(R.string.card00_name), mRes.getString(R.string.card00_positive), mRes.getString(R.string.card00_negative)),
            new Card( 1, R.drawable.card01, mRes.getString(R.string.card01_name), mRes.getString(R.string.card01_positive), mRes.getString(R.string.card01_negative)),
            new Card( 2, R.drawable.card02, mRes.getString(R.string.card02_name), mRes.getString(R.string.card02_positive), mRes.getString(R.string.card02_negative)),
            new Card( 3, R.drawable.card03, mRes.getString(R.string.card03_name), mRes.getString(R.string.card03_positive), mRes.getString(R.string.card03_negative)),
            new Card( 4, R.drawable.card04, mRes.getString(R.string.card04_name), mRes.getString(R.string.card04_positive), mRes.getString(R.string.card04_negative)),
            new Card( 5, R.drawable.card05, mRes.getString(R.string.card05_name), mRes.getString(R.string.card05_positive), mRes.getString(R.string.card05_negative)),
            new Card( 6, R.drawable.card06, mRes.getString(R.string.card06_name), mRes.getString(R.string.card06_positive), mRes.getString(R.string.card06_negative)),
            new Card( 7, R.drawable.card07, mRes.getString(R.string.card07_name), mRes.getString(R.string.card07_positive), mRes.getString(R.string.card07_negative)),
            new Card( 8, R.drawable.card08, mRes.getString(R.string.card08_name), mRes.getString(R.string.card08_positive), mRes.getString(R.string.card08_negative)),
            new Card( 9, R.drawable.card09, mRes.getString(R.string.card09_name), mRes.getString(R.string.card09_positive), mRes.getString(R.string.card09_negative)),
            new Card(10, R.drawable.card10, mRes.getString(R.string.card10_name), mRes.getString(R.string.card10_positive), mRes.getString(R.string.card10_negative)),
            new Card(11, R.drawable.card11, mRes.getString(R.string.card11_name), mRes.getString(R.string.card11_positive), mRes.getString(R.string.card11_negative)),
            new Card(12, R.drawable.card12, mRes.getString(R.string.card12_name), mRes.getString(R.string.card12_positive), mRes.getString(R.string.card12_negative)),
            new Card(13, R.drawable.card13, mRes.getString(R.string.card13_name), mRes.getString(R.string.card13_positive), mRes.getString(R.string.card13_negative)),
            new Card(14, R.drawable.card14, mRes.getString(R.string.card14_name), mRes.getString(R.string.card14_positive), mRes.getString(R.string.card14_negative)),
            new Card(15, R.drawable.card15, mRes.getString(R.string.card15_name), mRes.getString(R.string.card15_positive), mRes.getString(R.string.card15_negative)),
            new Card(16, R.drawable.card16, mRes.getString(R.string.card16_name), mRes.getString(R.string.card16_positive), mRes.getString(R.string.card16_negative)),
            new Card(17, R.drawable.card17, mRes.getString(R.string.card17_name), mRes.getString(R.string.card17_positive), mRes.getString(R.string.card17_negative)),
            new Card(18, R.drawable.card18, mRes.getString(R.string.card18_name), mRes.getString(R.string.card18_positive), mRes.getString(R.string.card18_negative)),
            new Card(19, R.drawable.card19, mRes.getString(R.string.card19_name), mRes.getString(R.string.card19_positive), mRes.getString(R.string.card19_negative)),
            new Card(20, R.drawable.card20, mRes.getString(R.string.card20_name), mRes.getString(R.string.card20_positive), mRes.getString(R.string.card20_negative)),
            new Card(21, R.drawable.card21, mRes.getString(R.string.card21_name), mRes.getString(R.string.card21_positive), mRes.getString(R.string.card21_negative))
        };
    }

    //endregion

    //region Getters

    public int getCount() {
        return mCards.length;
    }

    public Object getItem(int position) {
        return mCards[position];
    }

    public Card[] getItems(){
        return mCards;
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        CardsGridItemView itemView;
        Card card = mCards[position];

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            itemView = new CardsGridItemView(mContext, card);
            //imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            itemView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            itemView.setMaxWidth(200);
            itemView.setPadding(20, 20, 20, 20);
            itemView.setAdjustViewBounds(true);
        } else {
            itemView = (CardsGridItemView) convertView;
            itemView.setCard(card);
        }

        //itemView.setImageResource(mCards[position].getImageResourceId());
        return itemView;
    }

    //endregion
}
