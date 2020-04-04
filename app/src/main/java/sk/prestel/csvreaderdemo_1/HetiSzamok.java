package sk.prestel.csvreaderdemo_1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

class HetiSzamok implements Parcelable, Comparable {
    private int elso;
    private int masodik;
    private int harmadik;
    private int negyedik;
    private int otodik;
    private int elsoPot;
    private int masodikPot;

    protected HetiSzamok(Parcel in) {
        elso = in.readInt();
        masodik = in.readInt();
        harmadik = in.readInt();
        negyedik = in.readInt();
        otodik = in.readInt();
        elsoPot = in.readInt();
        masodikPot = in.readInt();
    }

    public static final Creator<HetiSzamok> CREATOR = new Creator<HetiSzamok>() {
        @Override
        public HetiSzamok createFromParcel(Parcel in) {
            return new HetiSzamok(in);
        }

        @Override
        public HetiSzamok[] newArray(int size) {
            return new HetiSzamok[size];
        }
    };

    public HetiSzamok() {

    }

    public int getElso() {
        return elso;
    }

    public void setElso(int elso) {
        this.elso = elso;
    }

    public int getMasodik() {
        return masodik;
    }

    public void setMasodik(int masodik) {
        this.masodik = masodik;
    }

    public int getHarmadik() {
        return harmadik;
    }

    public void setHarmadik(int harmadik) {
        this.harmadik = harmadik;
    }

    public int getNegyedik() {
        return negyedik;
    }

    public void setNegyedik(int negyedik) {
        this.negyedik = negyedik;
    }

    public int getOtodik() {
        return otodik;
    }

    public void setOtodik(int otodik) {
        this.otodik = otodik;
    }

    public int getElsoPot() {
        return elsoPot;
    }

    public void setElsoPot(int elsoPot) {
        this.elsoPot = elsoPot;
    }

    public int getMasodikPot() {
        return masodikPot;
    }

    public void setMasodikPot(int masodikPot) {
        this.masodikPot = masodikPot;
    }

    @Override
    public String toString() {
        return "HetiSzamok{" +
                "elso=" + elso +
                ", masodik=" + masodik +
                ", harmadik=" + harmadik +
                ", negyedik=" + negyedik +
                ", otodik=" + otodik +
                ", elsoPot=" + elsoPot +
                ", masodikPot=" + masodikPot +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(elso);
        dest.writeInt(masodik);
        dest.writeInt(harmadik);
        dest.writeInt(negyedik);
        dest.writeInt(otodik);
        dest.writeInt(elsoPot);
        dest.writeInt(masodikPot);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
