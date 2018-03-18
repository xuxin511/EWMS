package xx.com.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import xx.com.lib_common.Common_Model.Model.Base_Model;

/**
 * Created by GHOST on 2018/3/12.
 */

public class OutStockTaskInfo extends Base_Model implements Parcelable{

    private Float TaskType;
    private String SupcusName;
    private String AuditUserNo;
    private Date AuditDateTime;
    private Date TaskIssued;
    private String ReceiveUserNo;
    private String Remark;
    private String Reason;
    private String SupcusCode;
    private Float IsShelvePost;
    private Float IsQuality;
    private Float IsReceivePost;
    private String Plant;
    private String PlanName;
    private Float PostStatus;
    private String MoveType;
    private Float IsOutStockPost;
    private Float IsUnderShelvePost;
    private Float ReviewStatus;
    private String MoveReasonCode;
    private String MoveReasonDesc;
    private Float PrintQty;
    private Date PrintTime;
    private Date CloseDateTime;
    private String CloseUserNo;
    private String CloseReason;
    private Float IsOwe;
    private Float IsUrgent;
    private Date OutStockDate;
    private String TaskIsSueduser;
    private String MaterialNo;
    /// <summary>
    /// 是否指定批次
    /// </summary>
    private String IsSpcBatch;
    private int FloorType;
    private String FloorName;
    private String BatchNo;
    private String RowNoDel;
    private String PickLeaderUserNo;
    private String PickGroupNo;
    private String StrPickLeaderUserNo;
    private String PickUserNo;
    private String PickUserName;
    private int WareHouseID;
    private String WareHouseName;
    private String WareHouseNo;
    /// <summary>
    /// 1-不需要做有效期控制，2-需要做有效期控制
    /// </summary>
    private String IsEdate;
    private String HeightArea;
    private String HeightAreaName;
    private String IssueType;

    public Float getTaskType() {
        return TaskType;
    }

    public void setTaskType(Float taskType) {
        TaskType = taskType;
    }

    public String getSupcusName() {
        return SupcusName;
    }

    public void setSupcusName(String supcusName) {
        SupcusName = supcusName;
    }

    public String getAuditUserNo() {
        return AuditUserNo;
    }

    public void setAuditUserNo(String auditUserNo) {
        AuditUserNo = auditUserNo;
    }

    public Date getAuditDateTime() {
        return AuditDateTime;
    }

    public void setAuditDateTime(Date auditDateTime) {
        AuditDateTime = auditDateTime;
    }

    public Date getTaskIssued() {
        return TaskIssued;
    }

    public void setTaskIssued(Date taskIssued) {
        TaskIssued = taskIssued;
    }

    public String getReceiveUserNo() {
        return ReceiveUserNo;
    }

    public void setReceiveUserNo(String receiveUserNo) {
        ReceiveUserNo = receiveUserNo;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getSupcusCode() {
        return SupcusCode;
    }

    public void setSupcusCode(String supcusCode) {
        SupcusCode = supcusCode;
    }

    public Float getIsShelvePost() {
        return IsShelvePost;
    }

    public void setIsShelvePost(Float isShelvePost) {
        IsShelvePost = isShelvePost;
    }

    public Float getIsQuality() {
        return IsQuality;
    }

    public void setIsQuality(Float isQuality) {
        IsQuality = isQuality;
    }

    public Float getIsReceivePost() {
        return IsReceivePost;
    }

    public void setIsReceivePost(Float isReceivePost) {
        IsReceivePost = isReceivePost;
    }

    public String getPlant() {
        return Plant;
    }

    public void setPlant(String plant) {
        Plant = plant;
    }

    public String getPlanName() {
        return PlanName;
    }

    public void setPlanName(String planName) {
        PlanName = planName;
    }

    public Float getPostStatus() {
        return PostStatus;
    }

    public void setPostStatus(Float postStatus) {
        PostStatus = postStatus;
    }

    public String getMoveType() {
        return MoveType;
    }

    public void setMoveType(String moveType) {
        MoveType = moveType;
    }

    public Float getIsOutStockPost() {
        return IsOutStockPost;
    }

    public void setIsOutStockPost(Float isOutStockPost) {
        IsOutStockPost = isOutStockPost;
    }

    public Float getIsUnderShelvePost() {
        return IsUnderShelvePost;
    }

    public void setIsUnderShelvePost(Float isUnderShelvePost) {
        IsUnderShelvePost = isUnderShelvePost;
    }

    public Float getReviewStatus() {
        return ReviewStatus;
    }

    public void setReviewStatus(Float reviewStatus) {
        ReviewStatus = reviewStatus;
    }

    public String getMoveReasonCode() {
        return MoveReasonCode;
    }

    public void setMoveReasonCode(String moveReasonCode) {
        MoveReasonCode = moveReasonCode;
    }

    public String getMoveReasonDesc() {
        return MoveReasonDesc;
    }

    public void setMoveReasonDesc(String moveReasonDesc) {
        MoveReasonDesc = moveReasonDesc;
    }

    public Float getPrintQty() {
        return PrintQty;
    }

    public void setPrintQty(Float printQty) {
        PrintQty = printQty;
    }

    public Date getPrintTime() {
        return PrintTime;
    }

    public void setPrintTime(Date printTime) {
        PrintTime = printTime;
    }

    public Date getCloseDateTime() {
        return CloseDateTime;
    }

    public void setCloseDateTime(Date closeDateTime) {
        CloseDateTime = closeDateTime;
    }

    public String getCloseUserNo() {
        return CloseUserNo;
    }

    public void setCloseUserNo(String closeUserNo) {
        CloseUserNo = closeUserNo;
    }

    public String getCloseReason() {
        return CloseReason;
    }

    public void setCloseReason(String closeReason) {
        CloseReason = closeReason;
    }

    public Float getIsOwe() {
        return IsOwe;
    }

    public void setIsOwe(Float isOwe) {
        IsOwe = isOwe;
    }

    public Float getIsUrgent() {
        return IsUrgent;
    }

    public void setIsUrgent(Float isUrgent) {
        IsUrgent = isUrgent;
    }

    public Date getOutStockDate() {
        return OutStockDate;
    }

    public void setOutStockDate(Date outStockDate) {
        OutStockDate = outStockDate;
    }

    public String getTaskIsSueduser() {
        return TaskIsSueduser;
    }

    public void setTaskIsSueduser(String taskIsSueduser) {
        TaskIsSueduser = taskIsSueduser;
    }

    public String getMaterialNo() {
        return MaterialNo;
    }

    public void setMaterialNo(String materialNo) {
        MaterialNo = materialNo;
    }

    public String getIsSpcBatch() {
        return IsSpcBatch;
    }

    public void setIsSpcBatch(String isSpcBatch) {
        IsSpcBatch = isSpcBatch;
    }

    public int getFloorType() {
        return FloorType;
    }

    public void setFloorType(int floorType) {
        FloorType = floorType;
    }

    public String getFloorName() {
        return FloorName;
    }

    public void setFloorName(String floorName) {
        FloorName = floorName;
    }

    public String getBatchNo() {
        return BatchNo;
    }

    public void setBatchNo(String batchNo) {
        BatchNo = batchNo;
    }

    public String getRowNoDel() {
        return RowNoDel;
    }

    public void setRowNoDel(String rowNoDel) {
        RowNoDel = rowNoDel;
    }

    public String getPickLeaderUserNo() {
        return PickLeaderUserNo;
    }

    public void setPickLeaderUserNo(String pickLeaderUserNo) {
        PickLeaderUserNo = pickLeaderUserNo;
    }

    public String getPickGroupNo() {
        return PickGroupNo;
    }

    public void setPickGroupNo(String pickGroupNo) {
        PickGroupNo = pickGroupNo;
    }

    public String getStrPickLeaderUserNo() {
        return StrPickLeaderUserNo;
    }

    public void setStrPickLeaderUserNo(String strPickLeaderUserNo) {
        StrPickLeaderUserNo = strPickLeaderUserNo;
    }

    public String getPickUserNo() {
        return PickUserNo;
    }

    public void setPickUserNo(String pickUserNo) {
        PickUserNo = pickUserNo;
    }

    public String getPickUserName() {
        return PickUserName;
    }

    public void setPickUserName(String pickUserName) {
        PickUserName = pickUserName;
    }

    public int getWareHouseID() {
        return WareHouseID;
    }

    public void setWareHouseID(int wareHouseID) {
        WareHouseID = wareHouseID;
    }

    public String getWareHouseName() {
        return WareHouseName;
    }

    public void setWareHouseName(String wareHouseName) {
        WareHouseName = wareHouseName;
    }

    public String getWareHouseNo() {
        return WareHouseNo;
    }

    public void setWareHouseNo(String wareHouseNo) {
        WareHouseNo = wareHouseNo;
    }

    public String getIsEdate() {
        return IsEdate;
    }

    public void setIsEdate(String isEdate) {
        IsEdate = isEdate;
    }

    public String getHeightArea() {
        return HeightArea;
    }

    public void setHeightArea(String heightArea) {
        HeightArea = heightArea;
    }

    public String getHeightAreaName() {
        return HeightAreaName;
    }

    public void setHeightAreaName(String heightAreaName) {
        HeightAreaName = heightAreaName;
    }

    public String getIssueType() {
        return IssueType;
    }

    public void setIssueType(String issueType) {
        IssueType = issueType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeValue(this.TaskType);
        dest.writeString(this.SupcusName);
        dest.writeString(this.AuditUserNo);
        dest.writeLong(this.AuditDateTime != null ? this.AuditDateTime.getTime() : -1);
        dest.writeLong(this.TaskIssued != null ? this.TaskIssued.getTime() : -1);
        dest.writeString(this.ReceiveUserNo);
        dest.writeString(this.Remark);
        dest.writeString(this.Reason);
        dest.writeString(this.SupcusCode);
        dest.writeValue(this.IsShelvePost);
        dest.writeValue(this.IsQuality);
        dest.writeValue(this.IsReceivePost);
        dest.writeString(this.Plant);
        dest.writeString(this.PlanName);
        dest.writeValue(this.PostStatus);
        dest.writeString(this.MoveType);
        dest.writeValue(this.IsOutStockPost);
        dest.writeValue(this.IsUnderShelvePost);
        dest.writeValue(this.ReviewStatus);
        dest.writeString(this.MoveReasonCode);
        dest.writeString(this.MoveReasonDesc);
        dest.writeValue(this.PrintQty);
        dest.writeLong(this.PrintTime != null ? this.PrintTime.getTime() : -1);
        dest.writeLong(this.CloseDateTime != null ? this.CloseDateTime.getTime() : -1);
        dest.writeString(this.CloseUserNo);
        dest.writeString(this.CloseReason);
        dest.writeValue(this.IsOwe);
        dest.writeValue(this.IsUrgent);
        dest.writeLong(this.OutStockDate != null ? this.OutStockDate.getTime() : -1);
        dest.writeString(this.TaskIsSueduser);
        dest.writeString(this.MaterialNo);
        dest.writeString(this.IsSpcBatch);
        dest.writeInt(this.FloorType);
        dest.writeString(this.FloorName);
        dest.writeString(this.BatchNo);
        dest.writeString(this.RowNoDel);
        dest.writeString(this.PickLeaderUserNo);
        dest.writeString(this.PickGroupNo);
        dest.writeString(this.StrPickLeaderUserNo);
        dest.writeString(this.PickUserNo);
        dest.writeString(this.PickUserName);
        dest.writeInt(this.WareHouseID);
        dest.writeString(this.WareHouseName);
        dest.writeString(this.WareHouseNo);
        dest.writeString(this.IsEdate);
        dest.writeString(this.HeightArea);
        dest.writeString(this.HeightAreaName);
        dest.writeString(this.IssueType);
    }

    public OutStockTaskInfo() {
    }

    protected OutStockTaskInfo(Parcel in) {
        super(in);
        this.TaskType = (Float) in.readValue(Float.class.getClassLoader());
        this.SupcusName = in.readString();
        this.AuditUserNo = in.readString();
        long tmpAuditDateTime = in.readLong();
        this.AuditDateTime = tmpAuditDateTime == -1 ? null : new Date(tmpAuditDateTime);
        long tmpTaskIssued = in.readLong();
        this.TaskIssued = tmpTaskIssued == -1 ? null : new Date(tmpTaskIssued);
        this.ReceiveUserNo = in.readString();
        this.Remark = in.readString();
        this.Reason = in.readString();
        this.SupcusCode = in.readString();
        this.IsShelvePost = (Float) in.readValue(Float.class.getClassLoader());
        this.IsQuality = (Float) in.readValue(Float.class.getClassLoader());
        this.IsReceivePost = (Float) in.readValue(Float.class.getClassLoader());
        this.Plant = in.readString();
        this.PlanName = in.readString();
        this.PostStatus = (Float) in.readValue(Float.class.getClassLoader());
        this.MoveType = in.readString();
        this.IsOutStockPost = (Float) in.readValue(Float.class.getClassLoader());
        this.IsUnderShelvePost = (Float) in.readValue(Float.class.getClassLoader());
        this.ReviewStatus = (Float) in.readValue(Float.class.getClassLoader());
        this.MoveReasonCode = in.readString();
        this.MoveReasonDesc = in.readString();
        this.PrintQty = (Float) in.readValue(Float.class.getClassLoader());
        long tmpPrintTime = in.readLong();
        this.PrintTime = tmpPrintTime == -1 ? null : new Date(tmpPrintTime);
        long tmpCloseDateTime = in.readLong();
        this.CloseDateTime = tmpCloseDateTime == -1 ? null : new Date(tmpCloseDateTime);
        this.CloseUserNo = in.readString();
        this.CloseReason = in.readString();
        this.IsOwe = (Float) in.readValue(Float.class.getClassLoader());
        this.IsUrgent = (Float) in.readValue(Float.class.getClassLoader());
        long tmpOutStockDate = in.readLong();
        this.OutStockDate = tmpOutStockDate == -1 ? null : new Date(tmpOutStockDate);
        this.TaskIsSueduser = in.readString();
        this.MaterialNo = in.readString();
        this.IsSpcBatch = in.readString();
        this.FloorType = in.readInt();
        this.FloorName = in.readString();
        this.BatchNo = in.readString();
        this.RowNoDel = in.readString();
        this.PickLeaderUserNo = in.readString();
        this.PickGroupNo = in.readString();
        this.StrPickLeaderUserNo = in.readString();
        this.PickUserNo = in.readString();
        this.PickUserName = in.readString();
        this.WareHouseID = in.readInt();
        this.WareHouseName = in.readString();
        this.WareHouseNo = in.readString();
        this.IsEdate = in.readString();
        this.HeightArea = in.readString();
        this.HeightAreaName = in.readString();
        this.IssueType = in.readString();
    }

    public static final Creator<OutStockTaskInfo> CREATOR = new Creator<OutStockTaskInfo>() {
        @Override
        public OutStockTaskInfo createFromParcel(Parcel source) {
            return new OutStockTaskInfo(source);
        }

        @Override
        public OutStockTaskInfo[] newArray(int size) {
            return new OutStockTaskInfo[size];
        }
    };
}
