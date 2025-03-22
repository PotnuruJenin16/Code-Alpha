import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TravelItineraryPlanner extends JFrame {
    private JTextField destinationField;
    private JTextField dateField;
    private JTextArea preferencesArea;
    private JTextArea itineraryArea;
    private JTextField budgetField;
    private JButton addButton;
    private JButton generateButton;

    public TravelItineraryPlanner() {
        setTitle("Travel Itinerary Planner");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create UI components
        destinationField = new JTextField(20);
        dateField = new JTextField(20);
        preferencesArea = new JTextArea(5, 20);
        itineraryArea = new JTextArea(10, 40);
        budgetField = new JTextField(20);
        addButton = new JButton("Add Destination");
        generateButton = new JButton("Generate Itinerary");

        // Set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Destination:"), gbc);
        gbc.gridx = 1;
        add(destinationField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Date (dd-MM-yyyy):"), gbc);
        gbc.gridx = 1;
        add(dateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Preferences:"), gbc);
        gbc.gridx = 1;
        add(new JScrollPane(preferencesArea), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Budget (INR):"), gbc);
        gbc.gridx = 1;
        add(budgetField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(addButton, gbc);
        gbc.gridx = 1;
        add(generateButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(new JScrollPane(itineraryArea), gbc);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDestination();
            }
        });

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateItinerary();
            }
        });
    }

    private void addDestination() {
        String destination = destinationField.getText();
        String date = dateField.getText();
        String preferences = preferencesArea.getText();
        String budget = budgetField.getText();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date travelDate = sdf.parse(date);
            String itinerary = "Destination: " + destination + "\nDate: " + date + "\nPreferences: " + preferences + "\nBudget: INR " + budget + "\n\n";
            itineraryArea.append(itinerary);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date in the format dd-MM-yyyy", "Invalid Date", JOptionPane.ERROR_MESSAGE);
        }
        destinationField.setText("");
        dateField.setText("");
        preferencesArea.setText("");
        budgetField.setText("");
    }

    private void generateItinerary() {
        JOptionPane.showMessageDialog(this, "Itinerary generated:\n" + itineraryArea.getText(), "Itinerary", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TravelItineraryPlanner().setVisible(true);
            }
        });
    }
}