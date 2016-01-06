package Kata7v5.application;

import Kata7v5.control.Command;
import Kata7v5.model.Attribute;
import Kata7v5.view.AttributeDialog;
import Kata7v5.view.PopulationDialog;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements PopulationDialog, AttributeDialog {

    private final Map <String,Command> commands;
    private final List <Attribute> attributes = new ArrayList <>();
    private JComboBox combo;
    
    public Toolbar(Map<String, Command> commands) {
        super (new FlowLayout());
        this.commands = commands;
        this.add(mailDomainsAttribute());
        this.add(firstChartAttribute());
        this.add(comboBox());
        this.add(calculateButton());
    }
    
    @Override
    public List population() {
        try{
            return MailReader.read("C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata7\\DATA\\emails.txt");
        }catch( IOException ex ){
            return new ArrayList();
        }
    }
    
    @Override
    public Attribute attribute() {
        return attributes.get(combo.getSelectedIndex());
    }

    private String[] options(String... options) {
        return options;
    }
    
    private void add (Attribute attribute){
        attributes.add(attribute);
    }
    
    private Attribute mailDomainsAttribute() {
        return new Attribute<Person,String>(){

            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        };
    }

    private Attribute firstChartAttribute() {
        return new Attribute<Person,Character>(){

            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        };
    }

    private JComboBox comboBox() {
        combo = new JComboBox(options("Mail domains","First char"));
        return combo;
    }

    private JButton calculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("calculate").execute();
            }
        });
        return button;
    }
    
}
