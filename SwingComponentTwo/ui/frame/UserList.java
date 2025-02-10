package SwingComponentTwo.ui.frame;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserList extends JInternalFrame {
    public UserList() {

        setSize(590, 500);
        setTitle("User List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setClosable(true);
        // dummy user
        String columns[] = { "ID", "Full Name", "Email", "Contact" };
        Object data[][] = {
                { "1", "John Doe", "John@example.com", "11231412" },
                { "2", "Jane Doe", "Jane@example.com", "11231414" },
                { "3", "Joe Doe", "Joe@example.com", "11231416" },
                { "4", "Jill Doe", "Jill@example.com", "11231418" },
                { "5", "Jack Doe", "Jack@example.com", "11231410" },

        };
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable user_table = new JTable(model);
        add(user_table);
        JScrollPane scrollPane = new JScrollPane(user_table);
        setContentPane(scrollPane);
    }
}
