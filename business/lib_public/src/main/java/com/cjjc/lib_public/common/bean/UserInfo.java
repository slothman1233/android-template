package com.cjjc.lib_public.common.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 用户信息
 */
public class UserInfo implements Parcelable {


    private String avatar;
    private String createTime;
    private String id;
    private String inviteCode;
    private String inviteUser;
    private String lastLoginIp;
    private Integer level;
    private String nickName;
    private String oldPhone;
    private String phone;
    private Integer registerSource;
    private String sex;
    private String status;
    private String token;
    private String tureName;
    private String androidAddress;
    private boolean payPassword;
    private Integer verifyStatus;


    protected UserInfo(Parcel in) {
        avatar = in.readString();
        createTime = in.readString();
        id = in.readString();
        inviteCode = in.readString();
        inviteUser = in.readString();
        lastLoginIp = in.readString();
        if (in.readByte() == 0) {
            level = null;
        } else {
            level = in.readInt();
        }
        nickName = in.readString();
        oldPhone = in.readString();
        phone = in.readString();
        if (in.readByte() == 0) {
            registerSource = null;
        } else {
            registerSource = in.readInt();
        }
        sex = in.readString();
        status = in.readString();
        token = in.readString();
        tureName = in.readString();
        androidAddress = in.readString();
        payPassword = in.readByte() != 0;
        if (in.readByte() == 0) {
            verifyStatus = null;
        } else {
            verifyStatus = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(avatar);
        dest.writeString(createTime);
        dest.writeString(id);
        dest.writeString(inviteCode);
        dest.writeString(inviteUser);
        dest.writeString(lastLoginIp);
        if (level == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(level);
        }
        dest.writeString(nickName);
        dest.writeString(oldPhone);
        dest.writeString(phone);
        if (registerSource == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(registerSource);
        }
        dest.writeString(sex);
        dest.writeString(status);
        dest.writeString(token);
        dest.writeString(tureName);
        dest.writeString(androidAddress);
        dest.writeByte((byte) (payPassword ? 1 : 0));
        if (verifyStatus == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(verifyStatus);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getInviteUser() {
        return inviteUser;
    }

    public void setInviteUser(String inviteUser) {
        this.inviteUser = inviteUser;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getOldPhone() {
        return oldPhone;
    }

    public void setOldPhone(String oldPhone) {
        this.oldPhone = oldPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRegisterSource() {
        return registerSource;
    }

    public void setRegisterSource(Integer registerSource) {
        this.registerSource = registerSource;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTureName() {
        return tureName;
    }

    public void setTureName(String tureName) {
        this.tureName = tureName;
    }

    public String getAndroidAddress() {
        return androidAddress;
    }

    public void setAndroidAddress(String androidAddress) {
        this.androidAddress = androidAddress;
    }

    public boolean isPayPassword() {
        return payPassword;
    }

    public void setPayPassword(boolean payPassword) {
        this.payPassword = payPassword;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }
}
