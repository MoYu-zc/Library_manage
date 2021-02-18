package my_excel;

import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Money_Sell_excel {
	public final static String url = "jdbc:mysql://localhost:3306/bookmanage?useSSL=false"; // ���ݿ�URL
    public final static String user = "root"; // ���ݿ��û���
    public final static String password = "148729"; // ���ݿ�����

    // �����ݿⵥ�ű���Ϣ���뵽Excel����
    public static void main_export() throws Exception {
        // ���Ӱ����ݿ�����
        Class.forName("com.mysql.jdbc.Driver");
        // �������ݿ�
        Connection con = (Connection) DriverManager.getConnection(url, user,
                password);
        // ����Excel��
        Workbook book = new HSSFWorkbook();
        // DatabaseMetaData dbmt = con.getMetaData();
        // ���blog���ݿ�
        //TODO ��Ҫ��blog�޸�Ϊ��ָ�������ݿ�
        // ResultSet rs = dbmt.getTables("blog", "blog", null, new String[] {
        // "TABLE", "VIEW" });
        // ����Ҫת��ΪExcel�ı�
        //TODO ��Ҫ��Table_Name�޸�Ϊ��ǰ���ݿ������뵼�������ݱ�
        String purchase = "�����˿���Ϣ��";
        
        // �ڵ�ǰExcel����һ���ӱ�
        Sheet sheet = book.createSheet(purchase);

        Statement st = (Statement) con.createStatement();
        // ����sql��䣬��team���в�ѯ��������
        String sql = "select * from t_sellbook";
        ResultSet rs = st.executeQuery(sql);
        // ���ñ�ͷ��Ϣ��д��Excel���Ͻ��Ǵ�(0,0)��ʼ�ģ�
        Row row1 = sheet.createRow(0);
        ResultSetMetaData rsmd = rs.getMetaData();
        int colnum = rsmd.getColumnCount();
        for (int i = 1; i <= colnum; i++) {
            String name = rsmd.getColumnName(i);
            // ��Ԫ��
            Cell cell = row1.createCell(i - 1);
            // д������
            cell.setCellValue(name);
        }
        // ���ñ����Ϣ
        int idx = 1;
        while (rs.next()) {
            // ��
            Row row = sheet.createRow(idx++);
            for (int i = 1; i <= colnum; i++) {
                String str = rs.getString(i);
                // ��Ԫ��
                Cell cell = row.createCell(i - 1);
                // д������
                cell.setCellValue(str);
            }
        }
        // ����
        book.write(new FileOutputStream("D://" + purchase + ".xls"));

    }
}
