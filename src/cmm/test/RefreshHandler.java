package cmm.test;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.javascript.host.URL;

import java.io.IOException;

/**
 * Created by 598470 on 6/21/2017.
 */
public class RefreshHandler implements com.gargoylesoftware.htmlunit.RefreshHandler {
    public RefreshHandler() { }
    public void handleRefresh(final Page page, final URL url, final int secods) { }

    @Override
    public void handleRefresh(Page page, java.net.URL url, int i) throws IOException {

    }
}
