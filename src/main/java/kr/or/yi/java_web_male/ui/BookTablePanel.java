package kr.or.yi.java_web_male.ui;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;


import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.Publisher;
import kr.or.yi.java_web_male.service.LibraryUIService;

import java.awt.BorderLayout;
import java.util.List;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class BookTablePanel extends JPanel {
	
	private JTable table;	
	private List<Book> lists;
	private NonEditableModel model;
	private JScrollPane scrollPane;
	private LibraryUIService service;
	private Publisher publishers;
	
	
	public BookTablePanel() {
		service = new LibraryUIService();
		setBorder(new TitledBorder(null, "\uAC80\uC0C9\uACB0\uACFC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(table);
	}
	
	public void loadDatas() {
		model = new NonEditableModel(getDatas(), getColumnNames());
		table.setModel(model);
	}

	public void setLists(List<Book> lists) {
		this.lists = lists;
	}


	private Object[] getColumnNames() {
		return new String[] { "도서코드","제목", "저자", "출판사","대여가능여부"};
	}

	private Object[][] getDatas() {
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = getBookArray(lists.get(i));
		}
		return datas;
	}

	private Object[] getBookArray(Book book) {
		String bookCode = book.getBookCode();
		String title = book.getTitle();
		
		
		String PubNo = book.getPubNo().getPubNo();
		/*JOptionPane.showMessageDialog(null, PubNo);*/
		publishers = new Publisher();
		JOptionPane.showMessageDialog(null, book.getPubNo());
		publishers = service.selectPublisherByNo(book.getPubNo());
		JOptionPane.showMessageDialog(null, publishers);
		String publisher = publishers.getPubName();
		String author = book.getAuthor();
		boolean rentalPossible = book.isRentalPossible();
		String canPossible;
		if(rentalPossible==false) {
			canPossible="대여가능";
		}else {
			canPossible="대여불가능";
		}
		return new Object[] { bookCode,title,author,publisher,canPossible};
	}
	/*public void setPopMenu(JPopupMenu popup) {
		scrollPane.setComponentPopupMenu(popup);
		table.setComponentPopupMenu(popup);
	}*/


	/*public Book getSelectedEmployee() {
		int selectedIndex = table.getSelectedRow();
		String empno = (String) table.getValueAt(selectedIndex, 0);
		return new Book(empno);
	}*/

	
}
