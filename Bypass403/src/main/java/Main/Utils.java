package Main;

import burp.IBurpExtenderCallbacks;
import burp.IExtensionHelpers;

import java.io.PrintWriter;
import java.util.Arrays;
public class Utils {

    static boolean gotBurp = false;
    public static IBurpExtenderCallbacks callbacks;
    static IExtensionHelpers helpers;
    private static PrintWriter stdout;
    private static PrintWriter stderr;
    static MainPanel panel;

    public static void setBurpPresent(IBurpExtenderCallbacks incallbacks) {
        gotBurp = true;
        callbacks = incallbacks;
        helpers = callbacks.getHelpers();
        stdout = new PrintWriter(callbacks.getStdout(), true);
        stderr = new PrintWriter(callbacks.getStderr(), true);
    }

    public static void out(String message) {
        if (gotBurp) {
            stdout.println(message);
        }
        else {
            System.out.println(message);
        }

    }

    public static void setPanel(MainPanel inpanel) {
        panel = inpanel;
    }


}
