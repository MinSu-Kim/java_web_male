package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookBest10;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

public class BestUIBookTablePanel extends JPanel {
	private JTable table;
	private List<BookBest10> lists;
	private NonEditableModel model;
	private JScrollPane scrollPane;
	private int rank =0;
	/**
	 * Create the panel.
	 */
	public BestUIBookTablePanel() {
		setBorder(new TitledBorder(null, "\uC774\uBC88\uB2EC Best10!", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한 row만 선택가능
		table.setPreferredScrollableViewportSize(table.getPreferredSize());

		scrollPane.setViewportView(table);	
	}
	public void loadDatas() {
		model = new NonEditableModel(getDatas(), getColumnNames());
		table.setModel(model);
		setAlignWith();
	}

	public void setLists(List<BookBest10> lists) {
		this.lists = lists;
		rank = 0;
	}

	public Object[][] getDatas() {
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = getBookBest10Array(lists.get(i));
		}
		return datas;
		
	}

	private Object[] getBookBest10Array(BookBest10 bb10) {
		rank = rank + 1;
		bb10.getAuthor().getAuthor();
		return new Object[] { rank, bb10.getBookCode().getBookCode(),bb10.getTitle().getTitle(), bb10.getAuthor().getAuthor(), bb10.getPubName().getPubName(),bb10.getRanking() };
	}

	public String[] getColumnNames() {
		return new String[] { "순위", "책코드", "제목", "저자", "출판사", "대여횟수"};
	}

	public void setPopMenu(JPopupMenu popup) {
		scrollPane.setComponentPopupMenu(popup);
		table.setComponentPopupMenu(popup);
	}

	public Book getSelectedBookBest() throws Exception{
		int selectedIndex = table.getSelectedRow();
		String bookCode = (String) table.getValueAt(selectedIndex, 1);
		Book book = new Book();
		book.setBookCode(bookCode);				
		return book;
	}

	public JTable getTable() {
		return table;
	}

	// ---컬럼 설정
	protected void setAlignWith() {
		/*tableCellAlignment(SwingConstants.CENTER, 0, 1);
		tableCellAlignment(SwingConstants.RIGHT, 2, 3, 4, 5, 6);*/
		/*tableSetWidth(50, 180, 180, 100, 180, 100);*/
	}

	// 각 컬럼별 정렬설정
	protected void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	// 각 컬럼별 사이즈 설정
	protected void tableSetWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

}
