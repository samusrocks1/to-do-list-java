import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTask {

    public AddTask() {
    }

    public static void task() {

        JFrame jFrame = new JFrame("Add new task");
        jFrame.setBounds(50, 50, 450, 325);
        jFrame.setLayout(null);

        JLabel instruction = new JLabel();
        instruction.setBounds(5,5, 500, 25);
        instruction.setText("Please enter the information requested to add a new task to your to do list.");
        instruction.setVisible(true);
        jFrame.add(instruction);

        // This is the code for the user to add the project name.
        JLabel proj = new JLabel("Project Name");
        proj.setBounds(5,30,100,25);
        proj.setVisible(true);
        jFrame.add(proj);
        JTextField newProj = new JTextField(40);
        newProj.setBounds(105, 30, 150, 25);
        jFrame.add(newProj);

        // This is the code for the user to add the task name.
        JLabel title = new JLabel("Title");
        title.setBounds(5,60, 100, 25);
        title.setVisible(true);
        jFrame.add(title);
        JTextField newTitle = new JTextField();
        newTitle.setBounds(105, 60, 150, 25);
        jFrame.add(newTitle);

        // This is the code the user to add the description.
        JLabel description = new JLabel("Description");
        description.setBounds(5,90, 100, 25);
        description.setVisible(true);
        jFrame.add(description);
        JTextArea newDesc = new JTextArea();
        newDesc.setBounds(105, 90, 200, 75);
        newDesc.setWrapStyleWord(true);
        jFrame.add(newDesc);

        // This is the code for the user to add the due date.
        JLabel dueDate = new JLabel("Due date:");
        dueDate.setBounds(5, 170, 100, 25);
        dueDate.setVisible(true);
        jFrame.add(dueDate);
        JTextField date = new JTextField();
        date.setBounds(105 , 170, 150, 25);
        jFrame.add(date);

        // This is the code for the user to add the priority.
        JLabel priority = new JLabel("Priority:");
        priority.setBounds(5, 195, 100, 25);
        priority.setVisible(true);
        jFrame.add(priority);
        String[] priorityOptions = {"high", "medium", "low"};
        JComboBox priorityChoice = new JComboBox(priorityOptions);
        priorityChoice.setBounds(105, 195, 100, 25);
        jFrame.add(priorityChoice);

        //Submit Button
        JButton button = new JButton();
        button.setText("Submit");
        button.setBounds(25, 235, 100, 25);
        button.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i;
                if (priorityChoice.getSelectedItem() == "high") {
                    i = 0;
                }
                else if (priorityChoice.getSelectedItem() == "medium") {
                    i = 1;
                }
                else {
                    i = 2;
                }
                application.addTask(newProj.getText(), newTitle.getText(), newDesc.getText(), date.getText(), i );
                newProj.setText("");
                newTitle.setText("");
                newDesc.setText("");
                date.setText("");
            }
        });
        jFrame.add(button);

        //Reset Button
        JButton button1 = new JButton();
        button1.setText("Reset");
        button1.setBounds(135, 235, 100, 25);
        button1.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newProj.setText("");
                newTitle.setText("");
                newDesc.setText("");
                date.setText("");
            }
        });
        jFrame.add(button1);

        JButton button2 = new JButton();
        button2.setText("Return");
        button2.setBounds(245, 235, 100, 25);
        button2.setVisible(true);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                application.homePage();;
                jFrame.setVisible(false);
            }
        });
        jFrame.add(button2);
        jFrame.setVisible(true);
    }
}
