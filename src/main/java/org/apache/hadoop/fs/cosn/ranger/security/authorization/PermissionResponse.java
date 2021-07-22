package org.apache.hadoop.fs.cosn.ranger.security.authorization;

public class PermissionResponse {
    private boolean allowed;
    private String realUserName;

    public boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public String getRealUserName() {
        return realUserName;
    }

    public void setRealUserName(String realUserName) {
        this.realUserName = realUserName;
    }
}
