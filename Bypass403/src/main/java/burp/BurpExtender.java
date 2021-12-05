package burp;

import Main.*;
import java.io.PrintWriter;

public class BurpExtender implements IBurpExtender {
    private PrintWriter stdout;
    private IExtensionHelpers helpers;
    public static IBurpExtenderCallbacks callbacks;
    private MainPanel panel;
    private String NAME = "Bypass 403";
    private String VERSION = "1.2.0";

    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks)
    {


        this.callbacks = callbacks;
        Utils.setBurpPresent(callbacks);


        this.stdout = new PrintWriter(callbacks.getStdout(), true);
        callbacks.setExtensionName("Bypass403");
        this.helpers = callbacks.getHelpers();


        this.panel = new MainPanel();
        Utils.setPanel(this.panel);
        callbacks.addSuiteTab(this.panel);

        callbacks.registerContextMenuFactory(new BypassMain());

        banner();

    }

    private void banner() {
        this.stdout.println("===================================");
        this.stdout.println(String.format("%s loaded success", NAME));
        this.stdout.println(String.format("version: %s", VERSION));
        this.stdout.println("===================================");
    }

}