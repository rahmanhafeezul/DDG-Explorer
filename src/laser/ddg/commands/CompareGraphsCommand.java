package laser.ddg.commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import laser.ddg.ProvenanceData;
import laser.ddg.gui.DDGExplorer;
import laser.ddg.gui.GraphComp;
import laser.ddg.persist.JenaLoader;

/**
 * Command to load two DDGs and display the comparison result
 * The panel in which this is done is a tab in the DDG Explorer.
 * 
 * @author Hafeezul Rahman
 * @version June 28, 2016
 *
 */
public class CompareGraphsCommand implements ActionListener {
	/**
	 * Creates the window that allows the user to compare 2 DDGs
	 */
	private static void execute() {
		JenaLoader jenaLoader = JenaLoader.getInstance();
		DDGExplorer ddgExplorer = DDGExplorer.getInstance();
		JPanel diffPanel = new GraphComp(ddgExplorer, jenaLoader);
		ddgExplorer.addTab("Comparing DDGraphs", diffPanel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			execute();
		} catch (Exception e) {
			DDGExplorer ddgExplorer = DDGExplorer.getInstance();
			JOptionPane.showMessageDialog(ddgExplorer,
					"Unable to compare DDGs: ",
					"Error comparing DDGs",
					JOptionPane.ERROR_MESSAGE);
			//System.out.println();
		}
	}

}
