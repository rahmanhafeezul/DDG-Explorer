package laser.ddg.visualizer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import laser.ddg.visualizer.PrefuseGraphBuilder.tupleElement;

public class DDGSearchGUI extends JPanel{

  JList searchList;
  DefaultListModel model; 

  
  public DDGSearchGUI(ArrayList <tupleElement> nodesList, JPanel ddgPanel){
	  generateSearchList(nodesList, ddgPanel);
  }

  public void generateSearchList(ArrayList <tupleElement> nodesList, JPanel ddgPanel){  
	//Checks if search results were already created so that multiple JPanels will not be created
    if(searchList == null){
    	JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
    	
    	model = new DefaultListModel();
    	for(tupleElement entry : nodesList)
    		model.addElement(entry);
    	
    	searchList = new JList(model);
        searchList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        searchList.setCellRenderer(new NodeCellRenderer());
        searchList.setVisibleRowCount(-1);

        searchList.addListSelectionListener(new ListSelectionListener(){
        	public void valueChanged(ListSelectionEvent listener){
        		tupleElement entry = (tupleElement) searchList.getSelectedValue();
        		if(entry != null)
        			entry.updateNodeFocus();
        	}
        });
        
        JScrollPane pane = new JScrollPane(searchList);
        pane.setPreferredSize(new Dimension(150, 200));

        panel.add(pane);
        
        ddgPanel.add(panel, BorderLayout.WEST);
        ddgPanel.validate();
    }
  }

  //updates the JList if a new search is done
  public void updateSearchList(ArrayList <tupleElement> nodesList){
  	model.clear();

  	for(tupleElement entry : nodesList)
  		model.addElement(entry);
  }
  
  

  //Customizes the JList to be colorized and display information about the Nodes
  class NodeCellRenderer extends JLabel implements ListCellRenderer {
    Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

    public NodeCellRenderer() {
      setOpaque(true);
      setIconTextGap(12);
    }

    public java.awt.Component getListCellRendererComponent(JList list, Object value,
      int index, boolean isSelected, boolean cellHasFocus) {
      tupleElement entry = (tupleElement) value;
      setText(entry.getName());
      
      if (isSelected) {
        setBackground(HIGHLIGHT_COLOR);
        setForeground(Color.white);
      } else {
        setBackground(entry.getColor());
        //Sets text to be black for contrast
        if(entry.getColor() != Color.BLACK)
            setForeground(Color.BLACK);
        else
            setForeground(Color.WHITE);
      }
      return this;
    }

  }
}