package Main;

import burp.BurpExtender;
import burp.ITab;
import org.apache.commons.lang3.StringUtils;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 * Main display panel
 */
public class MainPanel extends JPanel implements ITab {

    private BypassTableModel bypassTableModel;
    private JTextField threadNumText;
    private JTextField allRequestNumberText;
    private JTextField finishRequestNumberText;
    private JTextField errorRequestNumText;

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


        JLabel threadNumLabel = new JLabel("Thread Num:");
        controlPanel.add(threadNumLabel);

        threadNumText = new JTextField(10);
        threadNumText.setText("5");
        controlPanel.add(threadNumText);


        JLabel allRequestNumberLabel = new JLabel("AllRequest Num:");
        controlPanel.add(allRequestNumberLabel);
        allRequestNumberText = new JTextField(5);
        allRequestNumberText.setText("0");
        allRequestNumberText.setEditable(false);
        controlPanel.add(allRequestNumberText);

        JLabel finishNumberLabel = new JLabel("Finish Num:");
        controlPanel.add(finishNumberLabel);
        finishRequestNumberText = new JTextField(5);
        finishRequestNumberText.setText("0");
        finishRequestNumberText.setEditable(false);
        controlPanel.add(finishRequestNumberText);


        JLabel errorRequestNumLabel = new JLabel("Error Num:");
        controlPanel.add(errorRequestNumLabel);
        errorRequestNumText = new JTextField(5);
        errorRequestNumText.setText("0");
        errorRequestNumText.setEditable(false);
        controlPanel.add(errorRequestNumText);


        JButton clearButton = new JButton("Clear");

        controlPanel.add(clearButton);

        clearButton.addActionListener(e -> {
            bypassTableModel.getBypassArray().clear();
            bypassTableModel.fireTableDataChanged();
            allRequestNumberText.setText("0");
            finishRequestNumberText.setText("0");
            errorRequestNumText.setText("0");
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

    public int getThreadNum() {

        if(StringUtils.isBlank(threadNumText.getText())) {
            return 5;
        }

        return Integer.parseInt(threadNumText.getText());
    }

    public BypassTableModel getBypassTableModel() {

        return bypassTableModel;
    }

    public void setAllRequestNumberText(int num) {
        allRequestNumberText.setText(String.valueOf(num));
    }

    public void addAllRequestNum(int num) {
        setAllRequestNumberText(Integer.parseInt(allRequestNumberText.getText()) + num);
    }

    public void addFinishRequestNum(int num) {
        finishRequestNumberText.setText(String.valueOf(Integer.parseInt(finishRequestNumberText.getText()) + num));
    }

    public void addErrorRequestNum(int num) {
        errorRequestNumText.setText(String.valueOf(Integer.parseInt(errorRequestNumText.getText()) + num));
    }

}
