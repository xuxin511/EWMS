package xx.com.lib_common.Common_Model.Model.User;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GHOST on 2017/2/6.
 */

public class MenuInfo implements Parcelable {
    private String MemuAbbName;
    private int MenuType;
    private String ProjectName;
    private Float SafeLevel;
    private Float IsDefault;
    private int MenuStatus;
    private String Description;
    private Float IsDel;
    private Float MenuStyle;
    private String StrMenuType;
    private String StrMenuStatus;
    private boolean BIsDefault;
    private boolean BIsChecked;
    private boolean BHaveParameter;
    private String StrMenuStyle;
    private String NodeUrl;

    public String getNodeUrl() {
        return NodeUrl;
    }

    public void setNodeUrl(String nodeUrl) {
        NodeUrl = nodeUrl;
    }

    public boolean isBHaveParameter() {
        return BHaveParameter;
    }

    public void setBHaveParameter(boolean BHaveParameter) {
        this.BHaveParameter = BHaveParameter;
    }

    public boolean isBIsChecked() {
        return BIsChecked;
    }

    public void setBIsChecked(boolean BIsChecked) {
        this.BIsChecked = BIsChecked;
    }

    public boolean isBIsDefault() {
        return BIsDefault;
    }

    public void setBIsDefault(boolean BIsDefault) {
        this.BIsDefault = BIsDefault;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Float getIsDefault() {
        return IsDefault;
    }

    public void setIsDefault(Float isDefault) {
        IsDefault = isDefault;
    }

    public Float getIsDel() {
        return IsDel;
    }

    public void setIsDel(Float isDel) {
        IsDel = isDel;
    }

    public String getMemuAbbName() {
        return MemuAbbName;
    }

    public void setMemuAbbName(String memuAbbName) {
        MemuAbbName = memuAbbName;
    }

    public int getMenuStatus() {
        return MenuStatus;
    }

    public void setMenuStatus(int menuStatus) {
        MenuStatus = menuStatus;
    }

    public Float getMenuStyle() {
        return MenuStyle;
    }

    public void setMenuStyle(Float menuStyle) {
        MenuStyle = menuStyle;
    }

    public int getMenuType() {
        return MenuType;
    }

    public void setMenuType(int menuType) {
        MenuType = menuType;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public Float getSafeLevel() {
        return SafeLevel;
    }

    public void setSafeLevel(Float safeLevel) {
        SafeLevel = safeLevel;
    }

    public String getStrMenuStatus() {
        return StrMenuStatus;
    }

    public void setStrMenuStatus(String strMenuStatus) {
        StrMenuStatus = strMenuStatus;
    }

    public String getStrMenuStyle() {
        return StrMenuStyle;
    }

    public void setStrMenuStyle(String strMenuStyle) {
        StrMenuStyle = strMenuStyle;
    }

    public String getStrMenuType() {
        return StrMenuType;
    }

    public void setStrMenuType(String strMenuType) {
        StrMenuType = strMenuType;
    }


    public MenuInfo() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.MemuAbbName);
        dest.writeInt(this.MenuType);
        dest.writeString(this.ProjectName);
        dest.writeValue(this.SafeLevel);
        dest.writeValue(this.IsDefault);
        dest.writeInt(this.MenuStatus);
        dest.writeString(this.Description);
        dest.writeValue(this.IsDel);
        dest.writeValue(this.MenuStyle);
        dest.writeString(this.StrMenuType);
        dest.writeString(this.StrMenuStatus);
        dest.writeByte(this.BIsDefault ? (byte) 1 : (byte) 0);
        dest.writeByte(this.BIsChecked ? (byte) 1 : (byte) 0);
        dest.writeByte(this.BHaveParameter ? (byte) 1 : (byte) 0);
        dest.writeString(this.StrMenuStyle);
        dest.writeString(this.NodeUrl);
    }

    protected MenuInfo(Parcel in) {
        this.MemuAbbName = in.readString();
        this.MenuType = in.readInt();
        this.ProjectName = in.readString();
        this.SafeLevel = (Float) in.readValue(Float.class.getClassLoader());
        this.IsDefault = (Float) in.readValue(Float.class.getClassLoader());
        this.MenuStatus = in.readInt();
        this.Description = in.readString();
        this.IsDel = (Float) in.readValue(Float.class.getClassLoader());
        this.MenuStyle = (Float) in.readValue(Float.class.getClassLoader());
        this.StrMenuType = in.readString();
        this.StrMenuStatus = in.readString();
        this.BIsDefault = in.readByte() != 0;
        this.BIsChecked = in.readByte() != 0;
        this.BHaveParameter = in.readByte() != 0;
        this.StrMenuStyle = in.readString();
        this.NodeUrl = in.readString();
    }

    public static final Creator<MenuInfo> CREATOR = new Creator<MenuInfo>() {
        @Override
        public MenuInfo createFromParcel(Parcel source) {
            return new MenuInfo(source);
        }

        @Override
        public MenuInfo[] newArray(int size) {
            return new MenuInfo[size];
        }
    };
}
