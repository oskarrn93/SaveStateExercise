package se.umu.cs.johane.savestateexercise;

import java.util.Random;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by johane on 2018-01-09.
 * A representation of a 6 sided Die
 */

public class Die implements Parcelable {
    private int value;
    private Random rand;

    public Die() {
        rand=new Random();
        roll();
    }

    public int getValue() {
        return value;
    }

    public void roll() {
        value=rand.nextInt(6)+1;
    }

    protected Die(Parcel in) {
        value = in.readInt();
    }

    public static final Creator<Die> CREATOR = new Creator<Die>() {
        @Override
        public Die createFromParcel(Parcel in) {
            return new Die(in);
        }

        @Override
        public Die[] newArray(int size) {
            return new Die[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(value);
    }
}
