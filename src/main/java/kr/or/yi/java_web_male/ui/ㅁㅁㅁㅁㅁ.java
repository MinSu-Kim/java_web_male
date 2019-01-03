package kr.or.yi.java_web_female.ui.list;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Event;

@SuppressWarnings("serial")
public class CustomerList extends AbstractListPanel<Customer> {

   public CustomerList() {

   }

   @Override
   protected void setAlignWidth() {
//      tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4,5, 6,7, 8, 9, 10,11);
//      tableCellAlignment(SwingConstants.LEFT,  4, 7, 11);
      tableSetWidth(75, 120, 80, 80, 380, 155, 120, 210, 90, 100, 80, 180);
      for (int i = 0; i < getColumnNames().length; i++) {
         table.getColumnModel().getColumn(i).setCellRenderer(new ReturnTableCellRenderer());
      }

   }

   @Override
   protected String[] getColumnNames() {
      return new String[] { "고객코드", "아이디", "고객이름", "우편번호", "주소", "연락처", "생년월일", "이메일", "면허종류", "등급명", "대여횟수", "쿠폰" };
   }

   @Override
   protected Object[] getItemRows(Customer item) {
      StringBuilder events = new StringBuilder();
      if (item.getEvents().size() > 0) {
         for (CustomEvent e : item.getEvents()) {
            for (Event subE : e.getEvents()) {
               events.append(subE.getName().substring(0, subE.getName().length()-2) + ", ");
            }
         }
         events.replace(events.length() - 2, events.length() - 1, "");
      }
      return new Object[] { item.getCode(), item.getId(), item.getName(), item.getZipCode(), item.getAddress(),
            item.getPhone(), String.format("%tF", item.getDob()), item.getEmail(), item.getLicense(),
            item.getGradeCode(), item.getRentCnt(), events };
   }

   @Override
   protected Customer getItem(int selectedIndex) {
      return list.get(selectedIndex);
   }

   public class ReturnTableCellRenderer extends JLabel implements TableCellRenderer {
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
         setText(value.toString());
         if(column==4||column==7||column==11) {
            setHorizontalAlignment(JLabel.LEFT);
         }else {
            setHorizontalAlignment(JLabel.CENTER);
         }
/*         if(column==11) {
            setFont(new Font("굴림", Font.PLAIN, 11) );
         }*/
         setOpaque(true);
         /*
          * if (value.toString().equals("블랙리스트")) { setBackground(new Color(255, 0, 0,
          * 20)); }else { setBackground(Color.WHITE); }
          */

         if (table.getValueAt(row, 9).toString().equals("블랙리스트")) {
            setBackground(new Color(255, 0, 0, 40));
         } else {
            setBackground(Color.WHITE);
         }
         return this;
      }
   }
}