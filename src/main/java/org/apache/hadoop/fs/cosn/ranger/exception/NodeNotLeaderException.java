package org.apache.hadoop.fs.cosn.ranger.exception;

import java.io.IOException;

public class NodeNotLeaderException extends IOException {

    private static final long serialVersionUID = 2478768088505660805L;

    public NodeNotLeaderException() {
        super();
    }

    public NodeNotLeaderException(String message) {
        super(message);
    }
}
