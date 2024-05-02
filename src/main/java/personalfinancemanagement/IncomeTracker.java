package personalfinancemanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.text.SimpleDateFormat;

public class IncomeTracker {
    JFrame incomeTracker;
    JLabel title, subTitle, dateLabel, amountLabel, descriptionLabel;
    JFormattedTextField inputDate;
    JTextField inputAmount, inputDescription;
    JButton addEntryButton, submitIncomeButton;
    JPanel entriesPanel, headingsPanel;
    int entryCount = 0;

    // Constructor
    public IncomeTracker() {
        incomeTracker = new JFrame();
        incomeTracker.setTitle("Income Tracker");
        incomeTracker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        incomeTracker.setSize(900, 700);
        incomeTracker.setResizable(false);
        incomeTracker.setLocationRelativeTo(null);
        incomeTracker.setLayout(null);

        // Initialize components
        title = new JLabel("INCOME TRACKER");
        title.setBounds(350, 50, 200, 30);
        incomeTracker.add(title);

        subTitle = new JLabel("Track Your Income Transactions Here ");
        subTitle.setBounds(300, 100, 300, 20);
        incomeTracker.add(subTitle);

        dateLabel = new JLabel("Date: (dd-MM-yyyy)");
        dateLabel.setBounds(100, 200, 150, 30);
        incomeTracker.add(dateLabel);

        amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(100, 250, 80, 30);
        incomeTracker.add(amountLabel);

        descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(100, 300, 80, 30);
        incomeTracker.add(descriptionLabel);

        // Specify date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        inputDate = new JFormattedTextField(dateFormat);
        inputDate.setBounds(240, 200, 210, 30); 
        incomeTracker.add(inputDate);

        inputAmount = new JTextField();
        inputAmount.setBounds(240, 250, 210, 30);
        incomeTracker.add(inputAmount);

        inputDescription = new JTextField();
        inputDescription.setBounds(240, 300, 210, 30);
        incomeTracker.add(inputDescription);

        addEntryButton = new JButton("Add Entry");
        addEntryButton.setBounds(220, 340, 100, 30);
        incomeTracker.add(addEntryButton);
        addEntryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEntry();
            }
        });
        
        headingsPanel = new JPanel();
        headingsPanel.setLayout(new GridLayout(1, 3)); // 3 columns for headings
        headingsPanel.setBounds(100, 370, 700, 50);
        headingsPanel.add(new JLabel("Date"));
        headingsPanel.add(new JLabel("Amount"));
        headingsPanel.add(new JLabel("Description"));
        incomeTracker.add(headingsPanel);

        entriesPanel = new JPanel();
        entriesPanel.setLayout(new GridLayout(0, 3)); // 3 columns for Date, Amount, and Description
        entriesPanel.setBounds(100, 430, 700, 100);
        incomeTracker.add(entriesPanel);

        submitIncomeButton = new JButton("Submit Income");
        submitIncomeButton.setBounds(600, 550, 150, 30);
        incomeTracker.add(submitIncomeButton);
        submitIncomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitIncome();
            }
        });

        // Make the frame visible
        incomeTracker.setVisible(true);
    }

    private void addEntry() {
        // Get values from input fields
        String date = inputDate.getText();
        String amount = inputAmount.getText();
        String description = inputDescription.getText();

        // Create labels for values
        JLabel dateLabel = new JLabel(date);
        JLabel amountLabel = new JLabel(amount);
        JLabel descriptionLabel = new JLabel(description);

        // Add labels to entriesPanel
        if (entryCount < 4) {
            entriesPanel.add(dateLabel);
            entriesPanel.add(amountLabel);
            entriesPanel.add(descriptionLabel);

            // Update entry count
            entryCount++;
        } else {
            // Prompt user to submit income
            int option = JOptionPane.showConfirmDialog(incomeTracker, "You have added 4 entries. Please submit your income before adding further entries.", "Restriction", JOptionPane.OK_CANCEL_OPTION);
//            if (option == JOptionPane.OK_OPTION) {
//                // Clear input fields
//                inputDate.setText(null);
//                inputAmount.setText(null);
//                inputDescription.setText(null);
//
//               
//            }
        }
        inputDate.setText(null);
                inputAmount.setText(null);
                inputDescription.setText(null);


        // Refresh layout
        incomeTracker.revalidate();
        incomeTracker.repaint();
    }

    private void submitIncome() {
        // Perform actions when submitIncomeButton is clicked
        // For example, clear the entriesPanel and reset entry count
        entriesPanel.removeAll();
        entryCount = 0;
inputDate.setText(null);
                inputAmount.setText(null);
                inputDescription.setText(null);
        // Refresh layout
        incomeTracker.revalidate();
        incomeTracker.repaint();
    }
}
