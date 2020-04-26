package ru.progwards.java2.lessons.Training.My;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;


public class Excel {

    /**Создание входного проверочного файла
     *
     * @param dirPath
     */

    static HSSFWorkbook inTown = new HSSFWorkbook();
    static int line = 0;


    private static void createInFile(String dirPath){
//        if (new File("C:\\Инвентаризация\\Исходящие\\Tmp\\InTown.xls").exists()) {

            inTown.createSheet();

            for (int i = 1; i < 13; i++) {

                String pathDirIn = dirPath + i + ".xls";
                try {
                    InputStream fileReg = new FileInputStream(pathDirIn);
                    Workbook inRegTmp = new HSSFWorkbook(fileReg);
                    inRegTmp.createSheet();
                    loadInReg(inRegTmp);
                } catch (FileNotFoundException e) {
                    System.out.println(pathDirIn + " - файл отстутвует");
                    continue;
                } catch (IOException e) {
                    System.out.println(pathDirIn + " - файл не загружен");
                    continue;
                }

            }

//            for (Row row : inTown.getSheetAt(0)){
//                System.out.println(row.getCell(0) + " | " + row.getCell(1) + " | " + row.getCell(2));
//            }

            try {
                OutputStream inRegFileTmp = new FileOutputStream("C:\\Инвентаризация\\Исходящие\\Tmp\\inTownTmp.xls");
                inTown.write(inRegFileTmp);
            } catch (FileNotFoundException e) {
                System.out.println("Не могу создать файл!");
            } catch (IOException e) {
                System.out.println("Не могу записать файл inTown.xls");
            }
//        }


    }

    private static void loadInReg(Workbook inRegTmp){
        Sheet inTownSheet = inTown.getSheetAt(0);
        Sheet sheetInRegTmp = inRegTmp.getSheetAt(0);
        CreationHelper helper = inTown.getCreationHelper();
        HSSFCellStyle styleDate = inTown.createCellStyle();
        //02-апр.-2019
        styleDate.setDataFormat(helper.createDataFormat().getFormat("dd-mmm.-yyyy"));
        int sum = 0;

        for (Row row : sheetInRegTmp) {
            if (row.getCell(5).toString().length() > 0 && row.getCell(3).toString().length() > 0) {
                Row row1 = inTownSheet.createRow(line);
            String fio = String.valueOf(row.getCell(3)).toLowerCase().replaceAll("ooo", "").trim();

            try {
                sum = (int) Float.parseFloat(row.getCell(5).toString());
            }catch (Exception e){
                System.out.println("Пролетел");
                continue;
            }

                row1.createCell(0).setCellValue(fio);
                row1.createCell(1, CellType.NUMERIC).setCellValue(sum);
                Cell cell = row1.createCell(2);
                cell.setCellStyle(styleDate);
                cell.setCellValue(row.getCell(1).toString());
                line++;
            }
            continue;
        }

    }

    public static void main(String[] args) {
        createInFile("C:\\Инвентаризация\\Входящие\\Город\\Регистрация\\");
    }

//    public static void main(String[] args) throws IOException {
//
//        Long start = System.currentTimeMillis();
//
//        InputStream inStream = new FileInputStream("C:\\in.xls");
//        InputStream outStream = new FileInputStream("C:\\out.xls");
//
//        Workbook bookOut = new HSSFWorkbook(outStream);
//        Workbook bookIn = new HSSFWorkbook(inStream);
//
//
//        Sheet sheetIn = bookIn.getSheetAt(0);
//        Sheet sheetOut = bookOut.getSheetAt(0);
//        int countTrue = 0;
//        int countOut = 0;
//        int countIn = 0;
//
//
//
//
//        for (Row rowOut : sheetOut) {
//            String outFIO = rowOut.getCell(7).getStringCellValue().toLowerCase();
//            countOut++;
//
//            if (rowOut.getCell(4).getCellType() == null || rowOut.getCell(4).getCellType() != CellType.NUMERIC){
//                continue;
//            }
//
//            if (outFIO.contains("Богачев Владимир".toLowerCase()) ||
//                    outFIO.contains("телицын алексей владимирович") ||
//                    outFIO.contains("анисимова юлия ивановна") ||
//                    outFIO.contains("канева ольга леонидовна") ||
//                    outFIO.contains("веснина людмила николаевна") ||
//                    outFIO.contains("необердина ольга") ||
//                    outFIO.contains("моданова ольга владимировна")){
//                rowOut.createCell(9).setCellValue("Совпадение");
//            }
//
//
//            for (Row rowIn : sheetIn) {
//                String inFIO = rowIn.getCell(3).getStringCellValue().toLowerCase().replaceAll("ООО", " ").trim();
//
//
//                if (outFIO.contains(inFIO) && rowOut.getCell(4).getNumericCellValue() == rowIn.getCell(5).getNumericCellValue()) {
//                    rowOut.createCell(9).setCellValue("Совпадение");
//                    countTrue ++;
//                    sheetIn.removeRow(rowIn);
//                    break;
//                }
//            }
//        }
//
//        OutputStream out = new FileOutputStream("C:\\out_new.xls");
//        bookOut.write(out);
//        OutputStream in = new FileOutputStream("C:\\in_new.xls");
//        bookIn.write(in);
//        System.out.println("Обработано " + countOut + " строк");
//        System.out.println("Найдено " + countTrue + " совпаденй");
//        System.out.println("Время обработки " + (System.currentTimeMillis() - start) / 1000 + " секунд");
//    }

}
