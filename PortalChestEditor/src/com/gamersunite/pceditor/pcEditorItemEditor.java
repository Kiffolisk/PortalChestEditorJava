package com.gamersunite.pceditor;

import com.dd.plist.*;

import java.awt.AWTEvent;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class pcEditorItemEditor extends JFrame {
	
	public int setterID = 0;
	public int w = 300;
	public int h = 300;
	private JLabel countLabel;
	
	public int finalCount = 1;
	public String finalItem = "";
	
	public pcEditorItemEditor(int theID, int theCount, String theItem) {
		setterID = theID;
		if (theCount > 0) {
			finalCount = theCount;
		}
		finalItem = theItem;
		System.out.println(theItem);
		setResizable(false);
		setLayout(null);
		JLabel title = new JLabel("Set Item " + String.valueOf(setterID+1), SwingConstants.CENTER);
		title.setBounds(0, 4, w, 10);
		add(title);
		JButton b = new JButton("Save");
		int bW = w/3;
		b.setBounds((w/2)-(bW/2), h-81, bW, 24);
		b.addActionListener(e ->
		{
			JButton jbref = pcEditorMain.my.idButtons.get(setterID);
			jbref.setText(String.valueOf(finalCount));
			System.out.println(finalItem);
			PortalChestItem biref = pcEditorMain.my.items.get(setterID);
			biref.itemName = finalItem;
			biref.count = finalCount;
			biref.BlockheadsItemData();
			pcEditorMain.my.items.set(setterID, biref);
			setVisible(false);
			dispose();
		});
		add(b);
		JButton clearButton = new JButton("Clear");
		clearButton.setBounds((w/2)-(bW/2), h-55, bW, 24);
		clearButton.addActionListener(e ->
		{
			finalCount = 0;
			JButton jbref = pcEditorMain.my.idButtons.get(setterID);
			jbref.setText(String.valueOf(finalCount));
			PortalChestItem biref = pcEditorMain.my.items.get(setterID);
			biref.itemName = "CLOTHING";
			biref.count = 0;
			pcEditorMain.my.items.set(setterID, biref);
			setVisible(false);
			dispose();
		});
		add(b);
		add(clearButton);
		JSlider countSlider = new JSlider(JSlider.HORIZONTAL, 1, 99, 1);
		countSlider.setBounds(5, 48, w-10, 24);
		countSlider.addChangeListener(new SliderListener());
		countSlider.setValue(finalCount);
		add(countSlider);
		countLabel = new JLabel("Count (" + String.valueOf(finalCount) + ")", SwingConstants.CENTER);
		countLabel.setBounds(0, 80, w, 10);
		add(countLabel);
		JComboBox itemSelector = new JComboBox(pcEditorMain.my.normals);
		itemSelector.addActionListener(e ->
		{
			JComboBox cb = (JComboBox)e.getSource();
			if (cb.getSelectedItem() != finalItem) {
				String itemName = (String)cb.getSelectedItem();
				System.out.println("Just selected item " + itemName + " for ID " + String.valueOf(setterID));
				finalItem = itemName;
			}
		});
		itemSelector.setBounds(5, 100, w-10, 24);
		itemSelector.setSelectedItem(finalItem);
		add(itemSelector);
		setTitle("Set item");
		setSize(w, h);
		setVisible(true);
	}
	
	class SliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();
			int count = (int)source.getValue();
			if (finalCount != count) {
				finalCount = count;
				countLabel.setText("Count (" + String.valueOf(count) + ")");
			}
		}
	}
}
