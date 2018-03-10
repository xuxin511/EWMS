package xx.com.lib_common.Common_Model.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by GHOST on 2016/12/13.
 */

public class Base_Model implements Parcelable {

    public Base_Model() {
        ID = 0;
        HeaderID = 0;
    }

    private int ID;
    private int HeaderID;
    private int Status;
    private String StrStatus;
    private String Creater;
    private String StrCreateTime;
    private String Modifyer;
    private String Auditor;
    private int TerminateReasonID;
    private String TerminateReason;
    private int LineStatus;
    private String DisplayID;
    private String DisplayName;
    private String InitFlag;
    private String StrModifyTime;
    private int VoucherType;
    private String StrVoucherType;
    private int MaterialNoID;
    private String StrongHoldCode;
    private String StrongHoldName;
    private String CompanyCode;
    private String ERPCreater ;
    private Date VouDate ;
    private Date EDate ;
    private String VouUser;
    private String DepartmentCode ;
    private String DepartmentName ;
    private String ERPStatus ;
    private String ERPNote ;
    private int ErpLineStatus ;
    private String ERPVoucherType;
    private String ErpVoucherNo;
    private String PrintIPAdress;
    private int UserID;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getERPVoucherType() {
        return ERPVoucherType;
    }

    public void setERPVoucherType(String ERPVoucherType) {
        this.ERPVoucherType = ERPVoucherType;
    }

    public String getErpVoucherType() {
        return ERPVoucherType;
    }

    public void setErpVoucherType(String erpVoucherType) {
        ERPVoucherType = erpVoucherType;
    }

    public String getPrintIPAdress() {
        return PrintIPAdress;
    }

    public void setPrintIPAdress(String printIPAdress) {
        PrintIPAdress = printIPAdress;
    }

    public String getErpVoucherNo() {
        return ErpVoucherNo;
    }

    public void setErpVoucherNo(String erpVoucherNo) {
        ErpVoucherNo = erpVoucherNo;
    }

    private int StockType;

    public int getStockType() {
        return StockType;
    }

    public void setStockType(int stockType) {
        StockType = stockType;
    }

    public Date getEDate() {
        return EDate;
    }

    public void setEDate(Date EDate) {
        this.EDate = EDate;
    }

    public String getERPCreater() {
        return ERPCreater;
    }

    public void setERPCreater(String ERPCreater) {
        this.ERPCreater = ERPCreater;
    }

    public Date getVouDate() {
        return VouDate;
    }

    public void setVouDate(Date vouDate) {
        VouDate = vouDate;
    }

    public String getVouUser() {
        return VouUser;
    }

    public void setVouUser(String vouUser) {
        VouUser = vouUser;
    }

    public String getDepartmentCode() {
        return DepartmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        DepartmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getERPStatus() {
        return ERPStatus;
    }

    public void setERPStatus(String ERPStatus) {
        this.ERPStatus = ERPStatus;
    }

    public String getERPNote() {
        return ERPNote;
    }

    public void setERPNote(String ERPNote) {
        this.ERPNote = ERPNote;
    }

    public int getErpLineStatus() {
        return ErpLineStatus;
    }

    public void setErpLineStatus(int erpLineStatus) {
        ErpLineStatus = erpLineStatus;
    }

    public String getStrongHoldCode() {
        return StrongHoldCode;
    }

    public void setStrongHoldCode(String strongHoldCode) {
        StrongHoldCode = strongHoldCode;
    }

    public String getStrongHoldName() {
        return StrongHoldName;
    }

    public void setStrongHoldName(String strongHoldName) {
        StrongHoldName = strongHoldName;
    }

    public String getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(String companyCode) {
        CompanyCode = companyCode;
    }

    public String getStrVoucherType() {
        return StrVoucherType;
    }

    public void setStrVoucherType(String strVoucherType) {
        StrVoucherType = strVoucherType;
    }

    public int getMaterialNoID() {
        return MaterialNoID;
    }

    public void setMaterialNoID(int materialNoID) {
        MaterialNoID = materialNoID;
    }


    public String getAuditor() {
        return Auditor;
    }

    public void setAuditor(String auditor) {
        Auditor = auditor;
    }

    public String getCreater() {
        return Creater;
    }

    public void setCreater(String creater) {
        Creater = creater;
    }

    public String getDisplayID() {
        return DisplayID;
    }

    public void setDisplayID(String displayID) {
        DisplayID = displayID;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public int getHeaderID() {
        return HeaderID;
    }

    public void setHeaderID(int headerID) {
        HeaderID = headerID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getInitFlag() {
        return InitFlag;
    }

    public void setInitFlag(String initFlag) {
        InitFlag = initFlag;
    }

    public int getLineStatus() {
        return LineStatus;
    }

    public void setLineStatus(int lineStatus) {
        LineStatus = lineStatus;
    }

    public String getModifyer() {
        return Modifyer;
    }

    public void setModifyer(String modifyer) {
        Modifyer = modifyer;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getStrCreateTime() {
        return StrCreateTime;
    }

    public void setStrCreateTime(String strCreateTime) {
        StrCreateTime = strCreateTime;
    }

    public String getStrModifyTime() {
        return StrModifyTime;
    }

    public void setStrModifyTime(String strModifyTime) {
        StrModifyTime = strModifyTime;
    }

    public String getStrStatus() {
        return StrStatus;
    }

    public void setStrStatus(String strStatus) {
        StrStatus = strStatus;
    }

    public String getTerminateReason() {
        return TerminateReason;
    }

    public void setTerminateReason(String terminateReason) {
        TerminateReason = terminateReason;
    }

    public int getTerminateReasonID() {
        return TerminateReasonID;
    }

    public void setTerminateReasonID(int terminateReasonID) {
        TerminateReasonID = terminateReasonID;
    }

    public int getVoucherType() {
        return VoucherType;
    }

    public void setVoucherType(int voucherType) {
        VoucherType = voucherType;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ID);
        dest.writeInt(this.HeaderID);
        dest.writeInt(this.Status);
        dest.writeString(this.StrStatus);
        dest.writeString(this.Creater);
        dest.writeString(this.StrCreateTime);
        dest.writeString(this.Modifyer);
        dest.writeString(this.Auditor);
        dest.writeInt(this.TerminateReasonID);
        dest.writeString(this.TerminateReason);
        dest.writeInt(this.LineStatus);
        dest.writeString(this.DisplayID);
        dest.writeString(this.DisplayName);
        dest.writeString(this.InitFlag);
        dest.writeString(this.StrModifyTime);
        dest.writeInt(this.VoucherType);
        dest.writeString(this.StrVoucherType);
        dest.writeInt(this.MaterialNoID);
        dest.writeString(this.StrongHoldCode);
        dest.writeString(this.StrongHoldName);
        dest.writeString(this.CompanyCode);
        dest.writeString(this.ERPCreater);
        dest.writeLong(this.VouDate != null ? this.VouDate.getTime() : -1);
        dest.writeLong(this.EDate != null ? this.EDate.getTime() : -1);
        dest.writeString(this.VouUser);
        dest.writeString(this.DepartmentCode);
        dest.writeString(this.DepartmentName);
        dest.writeString(this.ERPStatus);
        dest.writeString(this.ERPNote);
        dest.writeInt(this.ErpLineStatus);
        dest.writeString(this.ERPVoucherType);
        dest.writeString(this.ErpVoucherNo);
        dest.writeString(this.PrintIPAdress);
        dest.writeInt(this.UserID);
        dest.writeInt(this.StockType);
    }

    protected Base_Model(Parcel in) {
        this.ID = in.readInt();
        this.HeaderID = in.readInt();
        this.Status = in.readInt();
        this.StrStatus = in.readString();
        this.Creater = in.readString();
        this.StrCreateTime = in.readString();
        this.Modifyer = in.readString();
        this.Auditor = in.readString();
        this.TerminateReasonID = in.readInt();
        this.TerminateReason = in.readString();
        this.LineStatus = in.readInt();
        this.DisplayID = in.readString();
        this.DisplayName = in.readString();
        this.InitFlag = in.readString();
        this.StrModifyTime = in.readString();
        this.VoucherType = in.readInt();
        this.StrVoucherType = in.readString();
        this.MaterialNoID = in.readInt();
        this.StrongHoldCode = in.readString();
        this.StrongHoldName = in.readString();
        this.CompanyCode = in.readString();
        this.ERPCreater = in.readString();
        long tmpVouDate = in.readLong();
        this.VouDate = tmpVouDate == -1 ? null : new Date(tmpVouDate);
        long tmpEDate = in.readLong();
        this.EDate = tmpEDate == -1 ? null : new Date(tmpEDate);
        this.VouUser = in.readString();
        this.DepartmentCode = in.readString();
        this.DepartmentName = in.readString();
        this.ERPStatus = in.readString();
        this.ERPNote = in.readString();
        this.ErpLineStatus = in.readInt();
        this.ERPVoucherType = in.readString();
        this.ErpVoucherNo = in.readString();
        this.PrintIPAdress = in.readString();
        this.UserID = in.readInt();
        this.StockType = in.readInt();
    }

    public static final Creator<Base_Model> CREATOR = new Creator<Base_Model>() {
        @Override
        public Base_Model createFromParcel(Parcel source) {
            return new Base_Model(source);
        }

        @Override
        public Base_Model[] newArray(int size) {
            return new Base_Model[size];
        }
    };
}
