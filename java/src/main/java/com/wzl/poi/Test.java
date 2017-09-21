package com.wzl.poi;

import com.alibaba.fastjson.JSON;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

/**
 * Description :
 * Author: zhenglong
 * since 29 八月 2017
 */
public class Test {

    public static void main(String[] args) throws  Exception {
       // System.out.println(JSON.toJSONString(readXlsx("/Users/zhenglong/project/test/java/src/main/java/com/wzl/poi/test.xlsx")));
        insert("/Users/zhenglong/project/test/java/src/main/java/com/wzl/poi/test.xlsx");
    }

    private static DecimalFormat dfs = new DecimalFormat("0");

    @SuppressWarnings("All")
    public  static void insert(String path)throws  Exception{
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        for (XSSFSheet xssfSheet : xssfWorkbook) {
            if(xssfSheet.getSheetName().equals("运营目标")) {
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    int minColIx = xssfRow.getFirstCellNum();
                    int maxColIx = xssfRow.getLastCellNum();
                    StringBuilder sb=new StringBuilder();
                    java.util.Map<String,Object> map=new HashMap();
                    for (int colIx = minColIx+1; colIx <=maxColIx; colIx++) {
                        XSSFCell cell = xssfRow.getCell(colIx);
                        if (cell == null) {
                            continue;
                        }
                        sb.append(cell.toString()).append("-");
                    }
                    System.out.println(sb.toString());

                }
            }
        }
    }

    @SuppressWarnings("All")
    private static List<List<String>> readXlsx(String path) throws Exception {

        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        for (XSSFSheet xssfSheet : xssfWorkbook) {
            if(xssfSheet.getSheetName().equals("ofc")) {
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    int minColIx = xssfRow.getFirstCellNum();
                    for (int colIx = minColIx; colIx <=minColIx; colIx++) {
                            if(xssfRow.getCell(colIx).getNumericCellValue()!=0) {
                                JDBCOperation.insert(1,Integer.parseInt(dfs.format(xssfRow.getCell(colIx).getNumericCellValue())),rowNum);
                            }
                    }
                }
                System.out.println("ofo");
            }else if(xssfSheet.getSheetName().equals("soc")){
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    int minColIx = xssfRow.getFirstCellNum();
                    for (int colIx = minColIx; colIx <=minColIx; colIx++) {
                        if(xssfRow.getCell(colIx).getNumericCellValue()!=0) {
                            JDBCOperation.insert(6,Integer.parseInt(dfs.format(xssfRow.getCell(colIx).getNumericCellValue())),rowNum);
                        }
                    }
                }
                System.out.println("soc");
            }else if(xssfSheet.getSheetName().equals("内控")){
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    int minColIx = xssfRow.getFirstCellNum();
                    for (int colIx = minColIx; colIx <=minColIx; colIx++) {
                        if(xssfRow.getCell(colIx).getNumericCellValue()!=0) {
                            JDBCOperation.insert(5,Integer.parseInt(dfs.format(xssfRow.getCell(colIx).getNumericCellValue())),rowNum);
                        }
                    }
                }
                System.out.println("内控");
            }else if(xssfSheet.getSheetName().equals("内控-外卖")){
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    int minColIx = xssfRow.getFirstCellNum();
                    for (int colIx = minColIx; colIx <=minColIx; colIx++) {
                        if(xssfRow.getCell(colIx).getNumericCellValue()!=0) {
                            JDBCOperation.insert(9,Integer.parseInt(dfs.format(xssfRow.getCell(colIx).getNumericCellValue())),rowNum);
                        }

                    }
                }
                System.out.println("内控-外卖");
            }else if(xssfSheet.getSheetName().equals("GR")){
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    int minColIx = xssfRow.getFirstCellNum();
                    for (int colIx = minColIx; colIx <=minColIx; colIx++) {
                        if(xssfRow.getCell(colIx).getNumericCellValue()!=0) {
                            JDBCOperation.insert(4,Integer.parseInt(dfs.format(xssfRow.getCell(colIx).getNumericCellValue())),rowNum);
                        }
                    }
                }
                System.out.println("GR");
            }else if(xssfSheet.getSheetName().equals("神秘顾客")){
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    int minColIx = xssfRow.getFirstCellNum();
                    for (int colIx = minColIx; colIx <=minColIx; colIx++) {
                        if(xssfRow.getCell(colIx).getNumericCellValue()!=0) {
                             JDBCOperation.insert(7,Integer.parseInt(dfs.format(xssfRow.getCell(colIx).getNumericCellValue())),rowNum);
                        }
                    }
                }
                System.out.println("神秘顾客");
            } else if(xssfSheet.getSheetName().equals("门店自查")){
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    int minColIx = xssfRow.getFirstCellNum();
                    for (int colIx = minColIx; colIx <=minColIx; colIx++) {
                        if(xssfRow.getCell(colIx).getNumericCellValue()!=0) {
                            JDBCOperation.insert(2, Integer.parseInt(dfs.format(xssfRow.getCell(colIx).getNumericCellValue())),rowNum);
                        }
                    }
                }
                System.out.println("门店自查");
            }



        }
        return null;
    }


}
