package kr.or.yi.java_web_male.ui;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import javax.swing.text.Position;
import javax.swing.text.Segment;

class BoundDocument extends PlainDocument {
protected int charLimit;
protected JTextComponent textComp;
public BoundDocument(int charLimit) { this.charLimit = charLimit; }
public BoundDocument(int charLimit, JTextComponent textComp) { this.charLimit = charLimit; this.textComp = textComp; }

public void insertString (int offs, String str, AttributeSet a) throws BadLocationException
{
	
if (textComp.getText().getBytes().length + str.getBytes().length <= charLimit) { super.insertString(offs, str, a); }

}

}