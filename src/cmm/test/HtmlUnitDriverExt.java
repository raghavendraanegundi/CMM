package cmm.test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by 598470 on 6/21/2017.
 */
public class HtmlUnitDriverExt extends HtmlUnitDriver {
    public HtmlUnitDriverExt(BrowserVersion version) {
        super(version);
    }
    public HtmlUnitDriverExt(BrowserVersion version,Boolean javascriptEnabled) {
        super(version,javascriptEnabled);
    }
    @Override
    protected WebClient modifyWebClient(WebClient client) {
        client.setRefreshHandler(new RefreshHandler());
        return client;
    }
}
