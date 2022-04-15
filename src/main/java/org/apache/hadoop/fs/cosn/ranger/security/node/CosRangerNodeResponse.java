package org.apache.hadoop.fs.cosn.ranger.security.node;

import java.util.List;

public class CosRangerNodeResponse {

    // leader address
    private String cosRangerLeader;

    // all cos-ranger-service address include leader address
    private List<String> allCosRangers;

    public String getCosRangerLeader() {
        return cosRangerLeader;
    }

    public void setCosRangerLeader(String cosRangerLeader) {
        this.cosRangerLeader = cosRangerLeader;
    }

    public List<String> getAllCosRangers() {
        return allCosRangers;
    }

    public void setAllCosRangers(List<String> allCosRangers) {
        this.allCosRangers = allCosRangers;
    }
}
