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
	public final static String url = "jdbc:mysql://localhost:3306/bookmanage?useSSL=false"; // 数据库URL
    public final static String user = "root"; // 数据库用户名
    public final static String password = "148729"; // 数据库密码

    // 把数据库单张表信息导入到Excel表中
    public static void main_export() throws Exception {
        // 架子啊数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 连接数据库
        Connection con = (Connection) DriverManager.getConnection(url, user,
                password);
        // 创建Excel表。
        Workbook book = new HSSFWorkbook();
        // DatabaseMetaData dbmt = con.getMetaData();
        // 获得blog数据库
        //TODO 需要将blog修改为你指定的数据库
        // ResultSet rs = dbmt.getTables("blog", "blog", null, new String[] {
        // "TABLE", "VIEW" });
        // 设置要转化为Excel的表
        //TODO 需要将Table_Name修改为当前数据库中你想导出的数据表
        String purchase = "销售账款信息表";
        
        // 在当前Excel创建一个子表
        Sheet sheet = book.createSheet(purchase);

        Statement st = (Statement) con.createStatement();
        // 创建sql语句，对team进行查询所有数据
        String sql = "select * from t_sellbook";
        ResultSet rs = st.executeQuery(sql);
        // 设置表头信息（写入Excel左上角是从(0,0)开始的）
        Row row1 = sheet.createRow(0);
        ResultSetMetaData rsmd = rs.getMetaData();
        int colnum = rsmd.getColumnCount();
        for (int i = 1; i <= colnum; i++) {
            String name = rsmd.getColumnName(i);
            // 单元格
            Cell cell = row1.createCell(i - 1);
            // 写入数据
            cell.setCellValue(name);
        }
        // 设置表格信息
        int idx = 1;
        while (rs.next()) {
            // 行
            Row row = sheet.createRow(idx++);
            for (int i = 1; i <= colnum; i++) {
                String str = rs.getString(i);
                // 单元格
                Cell cell = row.createCell(i - 1);
                // 写入数据
                cell.setCellValue(str);
            }
        }
        // 保存
        book.write(new FileOutputStream("D://" + purchase + ".xls"));

    }
}
