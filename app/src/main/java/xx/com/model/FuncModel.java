package xx.com.Model;

/**
 * Created by GHOST on 2018/2/19.
 */

public class FuncModel {

    private int ImgResID;

    private String TitleName;

    private String Action;

    public FuncModel(){

    }

    public FuncModel(int imgResID,String titleName,String Action){
        this.ImgResID=imgResID;
        this.TitleName=titleName;
        this.Action=Action;
    }

    public int getImgResID() {
        return ImgResID;
    }

    public void setImgResID(int imgResID) {
        ImgResID = imgResID;
    }

    public String getTitleName() {
        return TitleName;
    }

    public void setTitleName(String titleName) {
        TitleName = titleName;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }
}
