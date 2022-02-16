package ru.gb.notes;

import android.os.Parcel;
import android.os.Parcelable;

public class NotesStore implements Parcelable {

    private int index;

    public NotesStore(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static Creator<NotesStore> getCREATOR() {
        return CREATOR;
    }

    protected NotesStore(Parcel in) {
        index = in.readInt();
    }

    public static final Creator<NotesStore> CREATOR = new Creator<NotesStore>() {
        @Override
        public NotesStore createFromParcel(Parcel in) {
            return new NotesStore(in);
        }

        @Override
        public NotesStore[] newArray(int size) {
            return new NotesStore[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(index);
    }
}
