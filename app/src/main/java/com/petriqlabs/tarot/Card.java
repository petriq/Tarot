package com.petriqlabs.tarot;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Peter on 4. 4. 2015.
 */
public class Card implements Parcelable {

    //region Fields

    private final int cardNumber;
    private final int imageResourceId;
    private final String name;
    private final String positiveMeaning;
    private final String negativeMeaning;

    //endregion

    //region Constructors

    public Card(int cardNumber, int imageResourceId, String name, String positiveMeaning, String negativeMeaning) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.positiveMeaning = positiveMeaning;
        this.negativeMeaning = negativeMeaning;
    }

    public Card(Parcel src) {
        this.cardNumber = src.readInt();
        this.imageResourceId = src.readInt();
        this.name = src.readString();
        this.positiveMeaning = src.readString();
        this.negativeMeaning = src.readString();
    }

    //endregion

    //region Getters

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getPositiveMeaning() {
        return positiveMeaning;
    }

    public String getNegativeMeaning() {
        return negativeMeaning;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getName() {
        return name;
    }

    public String getCardRomanNumber(){
        return RN.toRoman(this.cardNumber);
    }

    //endregion

    //region Parcelable

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.cardNumber);
        dest.writeInt(this.imageResourceId);
        dest.writeString(this.name);
        dest.writeString(this.positiveMeaning);
        dest.writeString(this.negativeMeaning);
    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Card createFromParcel(Parcel source) {
            return new Card(source);
        }

        public Card[] newArray(int size) {
            return new Card[size];
        }
    };

    //endregion
}
