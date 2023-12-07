import javax.swing.SwingUtilities
import javax.swing.UIManager

class Main {
    static void main(String[] args) {
        SwingUtilities.invokeLater({
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
            } catch (Exception e) {
                e.printStackTrace()
            }

            def projeMenuForm = new ProjeMenuForm()
            projeMenuForm.show()
        })
    }
}
