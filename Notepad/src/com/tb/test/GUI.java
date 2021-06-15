package com.tb.test;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
public class GUI implements ActionListener {
	
	JFrame window;
	// Text Area
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn=false;
	// Top Menu Bar
	JMenuBar menuBar;
	JMenu menuFile,menuEdit,menuFormat,menuColor;
	// File Menu
	JMenuItem menuNew,menuOpen,menuSave,menuSaveAs,menuExit;
	
	//Edit Menu
	JMenuItem iUndo, iRedo;
	
	//Format Menu
	JMenuItem iwordwrap,iFontArial,iFontCSMS,iFontINR,iFontSize8,iFontSize12,iFontSize14,iFontSize16,iFontSize18;
	JMenu menuFont,menuFontSize;
	
	
	// color menu
	JMenuItem icolor1,icolor2,icolor3;
	Function_File file=new Function_File(this);
	Function_Format format=new Function_Format(this);
	Function_Color color=new Function_Color(this);
	Function_Edit edit=new Function_Edit(this);
	
	UndoManager um= new UndoManager();

	public static void main(String[] args) {
		new GUI();
	}
	public  GUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createFormatMenu();
		createColorMenu();
		createEditMenu();
		format.selectedFont="Arial";
		format.createFont(16);
		format.wordWrap();
		color.changeColor("White");
		window.setVisible(true);
	}

	public void createWindow() {
		window=new JFrame("Notepad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void createTextArea() {
		textArea=new JTextArea();
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				// TODO Auto-generated method stub
				um.addEdit(e.getEdit());
				
			}
		});
		scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		window.add(scrollPane);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		
		}
	public void createMenuBar() {
		menuBar=new JMenuBar();
		window.setJMenuBar(menuBar);
		menuFile=new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit=new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat=new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuColor=new JMenu("Color");
		menuBar.add(menuColor);
		
	}
  public void createFileMenu() {
	menuNew=new JMenuItem("New");
	menuNew.addActionListener(this);
	menuNew.setActionCommand("New");
	menuFile.add(menuNew);
	
	menuOpen=new JMenuItem("Open");
	menuOpen.addActionListener(this);
	menuOpen.setActionCommand("Open");
	menuFile.add(menuOpen);
	
	menuSave=new JMenuItem("Save");
	menuSave.addActionListener(this);
	menuSave.setActionCommand("Save");
	menuFile.add(menuSave);
	
	menuSaveAs=new JMenuItem("SaveAs");
	menuSaveAs.addActionListener(this);
	menuSaveAs.setActionCommand("SaveAs");
	menuFile.add(menuSaveAs);
	
	menuExit=new JMenuItem("Exit");
	menuExit.addActionListener(this);
	menuExit.setActionCommand("Exit");
	menuFile.add(menuExit);
}
  
  public void createFormatMenu() {
	iwordwrap=new JMenuItem("Word Wrap: Off");
	iwordwrap.addActionListener(this);
	iwordwrap.setActionCommand("Word Wrap");
	menuFormat.add(iwordwrap);
	
	menuFont=new JMenu("Font");
	menuFormat.add(menuFont);
	
	iFontArial=new JMenuItem("Arial");
	iFontArial.addActionListener(this);
	iFontArial.setActionCommand("Arial");
	menuFont.add(iFontArial);
	
	iFontCSMS=new JMenuItem("Comic Sans MS");
	iFontCSMS.addActionListener(this);
	iFontCSMS.setActionCommand("Comic Sans MS");
	menuFont.add(iFontCSMS);
	
	iFontINR=new JMenuItem("Times New Roman");
	iFontINR.addActionListener(this);
	iFontINR.setActionCommand("Times New Roman");
	menuFont.add(iFontINR);
	
	menuFontSize=new JMenu("Font Size");
	menuFormat.add(menuFontSize);
	
	
	iFontSize8=new JMenuItem("8");
	iFontSize8.addActionListener(this);
	iFontSize8.setActionCommand("size8");
	menuFontSize.add(iFontSize8);
	
	
	iFontSize12=new JMenuItem("12");
	iFontSize12.addActionListener(this);
	iFontSize12.setActionCommand("size12");
	menuFontSize.add(iFontSize12);
	
	iFontSize14=new JMenuItem("14");
	iFontSize14.addActionListener(this);
	iFontSize14.setActionCommand("size14");
	menuFontSize.add(iFontSize14);
	
	iFontSize16=new JMenuItem("16");
	iFontSize16.addActionListener(this);
	iFontSize16.setActionCommand("size16");
	menuFontSize.add(iFontSize16);
	
	iFontSize18=new JMenuItem("18");
	iFontSize18.addActionListener(this);
	iFontSize18.setActionCommand("size18");
	menuFontSize.add(iFontSize18);
}
  
  public void createColorMenu() {
	icolor1=new JMenuItem("White");
	icolor1.addActionListener(this);
	icolor1.setActionCommand("White");
	menuColor.add(icolor1);
	
	icolor2=new JMenuItem("Blue");
	icolor2.addActionListener(this);
	icolor2.setActionCommand("Blue");
	menuColor.add(icolor2);
	
	icolor3=new JMenuItem("Red");
	icolor3.addActionListener(this);
	icolor1.setActionCommand("Red");
	menuColor.add(icolor3);
}
  
  public void createEditMenu() {
	  
	  iUndo=new JMenuItem("Undo");
	  iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		 iRedo=new JMenuItem("Redo");
		  iRedo.addActionListener(this);
			iRedo.setActionCommand("Redo");
			menuEdit.add(iRedo);
	
}
@Override
public void actionPerformed(ActionEvent e) {
	String command=e.getActionCommand();
	switch (command) {
	case "New":file.newFile();	
		break;
		
   case "Open":file.open();
   break;
   
   case "Save":file.save();
   break;
   
   case "SaveAs":file.saveAs();
   break;
   
   case "Exit":file.exit();
   break;
   
   case "Undo": edit.undo();
   break;
   case "Redo": edit.redo();
   break;
   case "Word Wrap":format.wordWrap();
   break;
   
   case "Arial":format.setFont(command);
   break;
   
   case "Comic Sans MS":format.setFont(command);
   break;
   
   case "Times New Roman":format.setFont(command);
   break;
   
   case "size8":format.createFont(8);
   break;
   
   case "size12":format.createFont(12);
   break;
   case "size14":format.createFont(14);
   break;
   case "size16":format.createFont(16);
   break;
   
   case "size18":format.createFont(18);
   break;
 
   case "White":color.changeColor(command);
   break;
   
   case "Blue":color.changeColor(command);
   break;
   
   case "Red":color.changeColor(command);
   break;
	}
	
}
}
