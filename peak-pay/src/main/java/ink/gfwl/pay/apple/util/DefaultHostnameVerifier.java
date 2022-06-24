package ink.gfwl.pay.apple.util;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * DefaultHostnameVerifier
 * @author jianpòlan
 * @version 1.0
 **/
public final class DefaultHostnameVerifier implements HostnameVerifier {
    public DefaultHostnameVerifier() {
    }

    @Override
    public boolean verify(String var1, SSLSession var2) {
        return false;
    }
}
