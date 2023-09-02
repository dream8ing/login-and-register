public class Userdata {
    String userName;
    String userId;
    String userPwd;
    String userImgPath;
    public Userdata(String id,String name,String pwd,String path)
    {
        this.userId = id;
        this.userImgPath = path;
        this.userName = name;
        this.userPwd = pwd;

    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserImgPath() {
        return userImgPath;
    }

    public String getUserPwd() {
        return userPwd;
    }
}
