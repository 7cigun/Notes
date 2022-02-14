package ru.gb.notes;

import android.os.Parcel;
import android.os.Parcelable;

public class NotesStore implements Parcelable {
    private String noteName;
    private String noteDescription;
    private String noteDate;

    protected NotesStore(Parcel in) {
        noteName = in.readString();
        noteDescription = in.readString();
        noteDate = in.readString();
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

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(noteName);
        parcel.writeString(noteDescription);
        parcel.writeString(noteDate);
    }
}
