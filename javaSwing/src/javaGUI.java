import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class javaGUI extends JFrame{
    private JTextField tfFirstname;
    private JTextField tfLastname;

    private JTextField tfEmail;
    private JRadioButton rbMale;
    private JRadioButton rbFemale;
    private JButton SUBMITButton;
    private JTextArea textArea1;
    private JPanel Main;
    private JPanel jpCalendar;
    Calendar calendar = Calendar.getInstance();
    JDateChooser dateChooser = new JDateChooser(calendar.getTime());
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");

    public javaGUI() {
        setContentPane(Main);
        setTitle("JAVA SWING GUI");
        setSize(500,500);
        setVisible(true) ;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        jpCalendar.add(dateChooser);

        //Radio group
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rbMale);
        btnGroup.add(rbFemale);

        SUBMITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                //Format Date
                String formattedDate = dateFormat.format(dateChooser.getDate());


                //Get values
                String firstName = tfFirstname.getText();
                String lastName = tfLastname.getText();
                String date = formattedDate;
                String email = tfEmail.getText();
                String gender = "";
                if (rbMale.isSelected()){
                    gender = "Male";
                } else if(rbFemale.isSelected()) {
                    gender = "Female";
                }
                if (firstName.isEmpty() || lastName.isEmpty() ||email.isEmpty() || gender.isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "Please fill out all fields.");

                } else {
                    //Display values
                    String info = "=======OUTPUT======\n" +
                            firstName+" "+lastName+" ("+gender+")\n"+
                            "Born on "+date+"\n"+
                             email + "\n";
                    textArea1.append(info);


                    // Clear fields after submission
                    tfFirstname.setText("");
                    tfLastname.setText("");
                    dateChooser.setDate(calendar.getTime());
                    tfEmail.setText("");
                    btnGroup.clearSelection();
                    // Proceed with further actions

                }






            }
        });
    }


    public static void main(String[] args){
      javaGUI j = new javaGUI();

  }
}
