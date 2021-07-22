package org.apache.hadoop.fs.cosn.ranger.protocol;

import org.apache.hadoop.fs.cosn.ranger.security.authorization.PermissionRequest;
import org.apache.hadoop.fs.cosn.ranger.security.authorization.PermissionResponse;
import org.apache.hadoop.fs.cosn.ranger.security.authorization.RangerAuthPolicyResponse;
import org.apache.hadoop.fs.cosn.ranger.security.sts.GetSTSRequest;
import org.apache.hadoop.fs.cosn.ranger.security.sts.GetSTSResponse;
import org.apache.hadoop.fs.cosn.ranger.security.token.DelegationTokenIdentifier;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.retry.Idempotent;
import org.apache.hadoop.security.token.Token;

import java.io.IOException;

public interface ClientQcloudObjectStorageProtocol {
    /**
     * Get a valid Delegation Token.
     *
     * @param renewer the designated renewer for the token
     * @throws IOException
     */
    @Idempotent
    Token<DelegationTokenIdentifier> getDelegationToken(Text renewer) throws IOException;

    /**
     * Renew an existing delegation token.
     *
     * @param token delegation token obtained earlier
     * @return the new expiration time
     * @throws IOException
     */
    @Idempotent
    long renewDelegationToken(Token<DelegationTokenIdentifier> token) throws IOException;

    /**
     * Cancel an existing delegation token.
     *
     * @param token delegation token
     * @throws IOException
     */
    @Idempotent
    void cancelDelegationToken(Token<DelegationTokenIdentifier> token) throws IOException;

    /**
     * Check Permission.
     *
     * @param request permission request
     * @return permission response, include allowed flag and real user name.
     * @throws IOException
     */
    @Idempotent
    PermissionResponse checkPermission(PermissionRequest request) throws IOException;

    /**
     * Check Permission.
     *
     * @param request get sts request
     * @return get sts response
     * @throws IOException
     */
    @Idempotent
    GetSTSResponse getSTS(GetSTSRequest request) throws IOException;

    /**
     * Get Ranger Auth And Policy URL
     *
     * @return get sts response
     * @throws IOException
     */
    @Idempotent
    RangerAuthPolicyResponse getRangerAuthPolicy() throws IOException;
}
