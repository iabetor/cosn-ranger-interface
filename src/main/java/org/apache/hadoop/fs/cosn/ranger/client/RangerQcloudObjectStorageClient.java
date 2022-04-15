package org.apache.hadoop.fs.cosn.ranger.client;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.cosn.ranger.security.authorization.PermissionRequest;
import org.apache.hadoop.fs.cosn.ranger.security.authorization.PermissionResponse;
import org.apache.hadoop.fs.cosn.ranger.security.authorization.RangerAuthPolicyResponse;
import org.apache.hadoop.fs.cosn.ranger.security.sts.GetSTSResponse;
import org.apache.hadoop.security.token.Token;

import java.io.IOException;

public interface RangerQcloudObjectStorageClient {
    void init(Configuration conf) throws IOException;

    String getCanonicalServiceName();

    PermissionResponse checkPermission(PermissionRequest permissionRequest) throws IOException;

    Token<?> getDelegationToken(String renewer) throws IOException;

    /**
     * Renew the given token.
     *
     * @return the new expiration time
     * @throws IOException
     * @throws InterruptedException
     */
    long renew(Token<?> token, Configuration conf) throws IOException, InterruptedException;

    /**
     * Cancel the given token
     *
     * @throws IOException
     * @throws InterruptedException
     */

    void cancel(Token<?> token, Configuration configuration) throws IOException, InterruptedException;

    GetSTSResponse getSTS(String bucketRegion, String bucketName) throws IOException;

    RangerAuthPolicyResponse getRangerAuthPolicy() throws IOException;

    void close();
}