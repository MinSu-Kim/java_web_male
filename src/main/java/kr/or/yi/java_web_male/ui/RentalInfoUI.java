package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.OverduePopup;
import kr.or.yi.java_web_male.service.LibraryUIService;
import kr.or.yi.java_web_male.service.OverduePopUpUIService;


public class RentalInfoUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private NonEditableModel model;
	private JScrollPane scrollPane;
	private JTable table;
	private int rank = 0;
	private List<OverduePopup> lists;
	private OverduePopUpUIService service;
	private JButton btnClose;
	private JCheckBox chckbxToday;
	private LibraryUIService serviceBook;
	private BookDetailUI bookDetailUI;
	private MemberSearchDetail memberDetailUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentalInfoUI frame = new RentalInfoUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RentalInfoUI() {
		serviceBook= new LibraryUIService();
		setTitle("대여 중정보");
		service = new OverduePopUpUIService();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		lists = service.selectAllRentInfo();

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
								{ null, null, null, null, null, null }, { null, null, null, null, null, null },
								{ null, null, null, null, null, null }, { null, null, null, null, null, null },
								{ null, null, null, null, null, null }, { null, null, null, null, null, null },
								{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "이름", "도서명", "대여일자", "반납예정일", "연체일수", "전화번호" }));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한 row만 선택가능
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPopupMenu popupMenu = new JPopupMenu();

		JMenuItem mntmAddBook = new JMenuItem("도서정보보기");
		JMenuItem mntmAddMember = new JMenuItem("회원정보보기");
		mntmAddBook.addActionListener(this);
		mntmAddMember.addActionListener(this);
		popupMenu.add(mntmAddBook);
		popupMenu.add(mntmAddMember);
		scrollPane.setComponentPopupMenu(popupMenu);
		table.setComponentPopupMenu(popupMenu);


		loadDatas();
	}
	public void loadDatas() {
		model = new NonEditableModel(getDatas(), getColumnNames());
		/**/
		table.setModel(model);
		setAlignWidth();
	}

	public Object[][] getDatas() {
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = getOverduePopupArray(lists.get(i));
		}
		return datas;

	}
	protected void setAlignWidth() {
		
     for (int i = 0; i < getColumnNames().length; i++) {
         table.getColumnModel().getColumn(i).setCellRenderer(new ReturnTableCellRenderer());
      }

   }

	public String[] getColumnNames() {
		return new String[] { "이름","회원번호", "도서명","도서코드", "대여일자", "반납예정일", "전화번호","연체일수" };
	}

	private Object[] getOverduePopupArray(OverduePopup overduePopup) {

		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		
		int overday = overduePopup.overday;
		
		return new Object[] { overduePopup.korName.getKorName(),overduePopup.memberNo.getMemberNo() ,overduePopup.title.getTitle(),overduePopup.bookCode.getBookCode(),
				date.format(overduePopup.rentalDate.getRentalDate()),
				date.format(overduePopup.returnSchedule.getReturnSchedule()),
				overduePopup.phone.getPhone(), overday};
	}

	public Member getSelectedMember() throws Exception{
		int selectedIndex = table.getSelectedRow();
		String MemNo = (String) table.getValueAt(selectedIndex,1);
		Member member = new Member();
		member.setMemberNo(MemNo);			
		return member;
	}

	public Book getSelectedBook() throws Exception{
		int selectedIndex = table.getSelectedRow();
		String bookCode = (String) table.getValueAt(selectedIndex,3);
		Book book = new Book();
		book.setBookCode(bookCode);			
		return book;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("도서정보보기")) {
			do_Bookdtail_actionPerformed(e);
		}
		if (e.getActionCommand().equals("회원정보보기")) {
			do_Memberdtail_actionPerformed(e);
		}
		
	}

	private void do_Memberdtail_actionPerformed(ActionEvent e) {
		try {
			Member member  = getSelectedMember();
			JOptionPane.showMessageDialog(null, member.getMemberNo());
			member = serviceBook.selectMemberbyNo(member.getMemberNo());
			JOptionPane.showMessageDialog(null, member.getKorName());
			memberDetailUI = new MemberSearchDetail();
			memberDetailUI.setInfo(member);
			memberDetailUI.setVisible(true);
			memberDetailUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private void do_Bookdtail_actionPerformed(ActionEvent e) {
		
		try {
			Book book = getSelectedBook();
			
			List<Book> listBook = serviceBook.selectbookbybookCode(book);
			JOptionPane.showMessageDialog(null,listBook);
			String bookCode = "";
			boolean RentalPossible = false;
			int totalBook = lists.size();
			if (lists.size() > 1) {
				for (Book books : listBook) {
					if (books.isRentalPossible()) {
						RentalPossible = true;
					}
					bookCode = bookCode + books.getBookCode();
					book = books;
				}
			} else {
				for (Book books : listBook) {
					if (books.isRentalPossible()) {
						RentalPossible = true;
					}
					bookCode = bookCode + books.getBookCode();
					book = books;
				}
			}
			book.setBookCode(bookCode);
			book.setRentalPossible(RentalPossible);
			bookDetailUI = new BookDetailUI();
			bookDetailUI.setBookInfo(book, totalBook, listBook);
			bookDetailUI.loadTable();
			bookDetailUI.btnbookRentalInfoHide();
			bookDetailUI.setVisible(true);
			bookDetailUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "선택하신정보가 없습니다.");
		}
		
		
	}
	
	public class ReturnTableCellRenderer extends JLabel implements TableCellRenderer {
	      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {
	         setText(value.toString());
	         setOpaque(true);
	         int a = (int) table.getValueAt(row, 7);
	         if (a>0) {
	        	 setBackground(new Color(255, 0, 0, 40));
	        	 
	         } else {
	        	 setBackground(Color.WHITE);
	           
	         }
	         return this;
	      }
	   }

}
