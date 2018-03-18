package xx.com.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by GHOST on 2017/1/24.
 */
public class Check_Model implements Parcelable {
    private int ID;
    private String CHECKNO ;
    private String CHECKTYPE ;
    private String CHECKDESC ;
    private String CHECKSTATUS ;
    private Date CBEGINTIME ;
    private Date CDONETIME ;
    private String REMARKS ;
    private int ISDEL ;
    private String CREATER ;
    private Date CREATETIME ;
    private String begintime ;
    private String endtime ;
    private Boolean ischeck ;

    public int getISDEL() {
        return ISDEL;
    }

    public void setISDEL(int ISDEL) {
        this.ISDEL = ISDEL;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public Date getCBEGINTIME() {
        return CBEGINTIME;
    }

    public void setCBEGINTIME(Date CBEGINTIME) {
        this.CBEGINTIME = CBEGINTIME;
    }

    public Date getCDONETIME() {
        return CDONETIME;
    }

    public void setCDONETIME(Date CDONETIME) {
        this.CDONETIME = CDONETIME;
    }

    public String getCHECKDESC() {
        return CHECKDESC;
    }

    public void setCHECKDESC(String CHECKDESC) {
        this.CHECKDESC = CHECKDESC;
    }

    public String getCHECKNO() {
        return CHECKNO;
    }

    public void setCHECKNO(String CHECKNO) {
        this.CHECKNO = CHECKNO;
    }

    public String getCHECKSTATUS() {
        return CHECKSTATUS;
    }

    public void setCHECKSTATUS(String CHECKSTATUS) {
        this.CHECKSTATUS = CHECKSTATUS;
    }

    public String getCHECKTYPE() {
        return CHECKTYPE;
    }

    public void setCHECKTYPE(String CHECKTYPE) {
        this.CHECKTYPE = CHECKTYPE;
    }

    public String getCREATER() {
        return CREATER;
    }

    public void setCREATER(String CREATER) {
        this.CREATER = CREATER;
    }

    public Date getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(Date CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Boolean getIscheck() {
        return ischeck;
    }

    public void setIscheck(Boolean ischeck) {
        this.ischeck = ischeck;
    }

    public String getREMARKS() {
        return REMARKS;
    }

    public void setREMARKS(String REMARKS) {
        this.REMARKS = REMARKS;
    }


    public Check_Model() {
    }

    public Check_Model(String CHECKNO){
        this.CHECKNO=CHECKNO;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Check_Model that = (Check_Model) obj;

        return CHECKNO.equals(that.getCHECKNO());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ID);
        dest.writeString(this.CHECKNO);
        dest.writeString(this.CHECKTYPE);
        dest.writeString(this.CHECKDESC);
        dest.writeString(this.CHECKSTATUS);
        dest.writeLong(this.CBEGINTIME != null ? this.CBEGINTIME.getTime() : -1);
        dest.writeLong(this.CDONETIME != null ? this.CDONETIME.getTime() : -1);
        dest.writeString(this.REMARKS);
        dest.writeInt(this.ISDEL);
        dest.writeString(this.CREATER);
        dest.writeLong(this.CREATETIME != null ? this.CREATETIME.getTime() : -1);
        dest.writeString(this.begintime);
        dest.writeString(this.endtime);
        dest.writeValue(this.ischeck);
    }

    protected Check_Model(Parcel in) {
        this.ID = in.readInt();
        this.CHECKNO = in.readString();
        this.CHECKTYPE = in.readString();
        this.CHECKDESC = in.readString();
        this.CHECKSTATUS = in.readString();
        long tmpCBEGINTIME = in.readLong();
        this.CBEGINTIME = tmpCBEGINTIME == -1 ? null : new Date(tmpCBEGINTIME);
        long tmpCDONETIME = in.readLong();
        this.CDONETIME = tmpCDONETIME == -1 ? null : new Date(tmpCDONETIME);
        this.REMARKS = in.readString();
        this.ISDEL = in.readInt();
        this.CREATER = in.readString();
        long tmpCREATETIME = in.readLong();
        this.CREATETIME = tmpCREATETIME == -1 ? null : new Date(tmpCREATETIME);
        this.begintime = in.readString();
        this.endtime = in.readString();
        this.ischeck = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Creator<Check_Model> CREATOR = new Creator<Check_Model>() {
        @Override
        public Check_Model createFromParcel(Parcel source) {
            return new Check_Model(source);
        }

        @Override
        public Check_Model[] newArray(int size) {
            return new Check_Model[size];
        }
    };
}
