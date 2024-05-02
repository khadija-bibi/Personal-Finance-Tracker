package personalfinancemanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class dashboard implements ActionListener{
    JFrame dashboard;
    JLabel title;
    JButton incomeTracking, expenseTracking, budgetTracking, billpayment, transactionHistory, loanManagement;
    
    dashboard(){
        dashboard = new JFrame();
        
        title = new JLabel("Dashboard");
        title.setBounds(130,100,300,60);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        dashboard.add(title);
        
        incomeTracking = new JButton("Income Tracker");
        incomeTracking.setBounds(250, 210, 180, 30);
        dashboard.add(incomeTracking);
        incomeTracking.addActionListener(this);
        
        expenseTracking = new JButton("Expense Tracker");
        expenseTracking.setBounds(170, 260, 180, 30);
        dashboard.add(expenseTracking);
        expenseTracking.addActionListener(this);
        
        budgetTracking = new JButton("Budget Tracker");
        budgetTracking.setBounds(170, 310, 180, 30);
        dashboard.add(budgetTracking);
        budgetTracking.addActionListener(this);
        
        billpayment = new JButton("Bill Management");
        billpayment.setBounds(170, 360, 180, 30);
        dashboard.add(billpayment);
        billpayment.addActionListener(this);
        
        transactionHistory = new JButton("Transaction History");
        transactionHistory.setBounds(170, 410, 180, 30);
        dashboard.add(transactionHistory);
        transactionHistory.addActionListener(this);
        
        loanManagement = new JButton("Loan Management");
        loanManagement.setBounds(170, 460, 180, 30);
        dashboard.add(loanManagement);
        loanManagement.addActionListener(this);
        
        
        
        dashboard.setTitle("User Login");
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setSize(900, 700);
        dashboard.setResizable(false);
        dashboard.setLocationRelativeTo(null);
        dashboard.setLayout(null);
        
        dashboard.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(incomeTracking)){
            IncomeTracker incomeTrackerFrame = new IncomeTracker();
            dashboard.dispose(); // Dispose the Dashboard frame
        }
    }
}
