package Main;

import burp.BurpExtender;
import burp.ITab;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

/**
 * Main display panel
 */
public class MainPanel extends JPanel implements ITab {

    private BypassTableModel bypassTableModel;

    public MainPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // main split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        // table of log entries
        bypassTableModel = new BypassTableModel();
        BypassTable bypassTable = new BypassTable(bypassTableModel);

        JScrollPane scrollPane = new JScrollPane(bypassTable);

        splitPane.setLeftComponent(scrollPane);

        // tabs with request/response viewers
        JTabbedPane tabs = new JTabbedPane();
        tabs.setBorder(BorderFactory.createLineBorder(Color.black));
        tabs.addTab("Request", bypassTable.getRequestViewer().getComponent());
        tabs.addTab("Response", bypassTable.getResponseViewer().getComponent());
        splitPane.setRightComponent(tabs);

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel toolLabel = new JLabel("Select tool: ");
        controlPanel.add(toolLabel);

        JButton clearButton = new JButton("Clear");

        controlPanel.add(clearButton);

        clearButton.addActionListener(e -> {
            bypassTableModel.getBypassArray().clear();
            bypassTableModel.fireTableDataChanged();
        });

        controlPanel.setAlignmentX(0);
        add(controlPanel);
        add(splitPane);

        BurpExtender.callbacks.customizeUiComponent(this);
    }

    public String getTabCaption() {

        return "Bypass 403";
    }

    public Component getUiComponent() {

        return this;
    }

    public BypassTableModel getBypassTableModel() {

        return bypassTableModel;
    }

}
