import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;

public class application{
    public static ArrayList<task> listOfTasks = new ArrayList<task>();
    public static JFrame home = new JFrame("To Do List");
    public static JScrollPane taskView = new JScrollPane();

    public static void main (String[] args){
        ArrayList<task> listOfTasks = new ArrayList<task>();
        homePage();
    }

    // Shows all of the tasks.
    public static void homePage() {
        home.setBounds(25, 25, 420, 840);
        home.setLayout(null);
        taskView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        taskView.setBounds(0, 0, 400, 775);
        home.remove(taskView);
        taskView.removeAll();
        displayTasks();
        JButton addTask = new JButton();
        addTask.setText("Add a task");
        addTask.setBounds(135, 780, 150, 20);
        addTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.setVisible(false);
                AddTask.task();
            }
        });
        home.add(addTask);
        home.setVisible(true);
        home.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // Displays all of the properties of the selected task in a new window.
    public static void showTask(int index){
        JFrame taskDescription = new JFrame(listOfTasks.get(index).getTitle() + " Information");
        taskDescription.setBounds(25, 25, 450, 325);
        taskDescription.setLayout(null);

        JLabel project = new JLabel("This is a part of the " + listOfTasks.get(index).getProject() + " project");
        project.setBounds(5, 5, 500, 25);
        project.setVisible(true);
        taskDescription.add(project);

        JLabel title = new JLabel("Task: " + listOfTasks.get(index).getTitle());
        title.setBounds(5, 35, 500, 25);
        title.setVisible(true);
        taskDescription.add(title);

        JTextArea description = new JTextArea(listOfTasks.get(index).getDescription());
        description.setBounds(5, 65, 500, 75);
        description.setWrapStyleWord(true);
        description.setVisible(true);
        taskDescription.add(description);

        JLabel date = new JLabel("The due date is: " + listOfTasks.get(index).getDueDate());
        date.setBounds(5, 155, 500, 25);
        date.setVisible(true);
        taskDescription.add(date);

        JLabel priority = new JLabel();
        if (listOfTasks.get(index).getPriority() == 0){
            priority.setText("This is a high priority");
            priority.setBounds(5, 185, 500, 25);
            priority.setForeground(Color.RED);
            priority.setVisible(true);
        }
        else if (listOfTasks.get(index).getPriority() == 1) {
            priority.setText("This is a medium priority");
            priority.setBounds(5, 185, 500, 25);
            priority.setForeground(Color.orange);
            priority.setVisible(true);
        }
        else {
            priority.setText("This is a low priority");
            priority.setBounds(5, 185, 500, 25);
            priority.setVisible(true);
        }
        taskDescription.add(priority);
        JButton markComplete = new JButton();
        markComplete.setBounds(5, 245, 150, 25);
        markComplete.setText("Task Completed");
        markComplete.setVisible(true);
        markComplete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listOfTasks.remove(index);
                taskDescription.setVisible(false);
                taskView.removeAll();
                displayTasks();
                homePage();
            }
        });
        taskDescription.add(markComplete);

        JLabel completed = new JLabel("Completed: " + listOfTasks.get(index).isCompleted());
        completed.setBounds(5, 215, 100, 25);
        completed.setVisible(true);
        taskDescription.add(completed);
        taskDescription.setVisible(true);
    }

    // Allows a task to be added.
    public static void addTask(String project, String title, String description, String dueDate, int priority){
        task newTask = new task(project, title, description, dueDate, priority);
        listOfTasks.add(newTask);
    }

    // Returns the tasks.
    public static void displayTasks() {
        int x = 5;
        int y = 5;
        for (int i = 0; i < listOfTasks.size(); i++){
            JButton taskSum = new JButton();
            taskSum.setText(listOfTasks.get(i).getTitle());
            taskSum.setBounds(x, y, 395, 25);
            taskSum.setVisible(true);
            taskView.add(taskSum);
            if (listOfTasks.get(i).getPriority() == 0) {
                taskSum.setBackground(Color.RED);
            }
            else if (listOfTasks.get(i).getPriority() == 1) {
                taskSum.setBackground(Color.ORANGE);
            }
            int finalI = i;
            taskSum.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    final int z = finalI;
                    showTask(z);
                }
            });
            y += 30;
        }
        taskView.setVisible(true);
        home.add(taskView);
    }
}


