package catfishfiles.MainPackage.FileOps;

import catfishfiles.MainPackage.Player;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import jxl.Cell;
import jxl.CellType;

import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelRW {

    private WritableCellFormat timesBoldUnderline;
    private WritableCellFormat times;
    private String inputFile;

    public void setOutputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void write(Player X) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("PlayerProfile", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createLabel(excelSheet);
        createContent(excelSheet, X);

        workbook.write();
        workbook.close();
    }

    public void read(Player P) throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);

            // Loop over all rows in column 2 of SAVE file which contain the attribute values of Player.             
            for (int i = 0; i < sheet.getRows(); i++) {
                Cell cell = sheet.getCell(1, i);
                CellType type = cell.getType();
                if (type == CellType.NUMBER) {
                    switch (i) {
                        case 0:
                            P.hp = Integer.parseInt(cell.getContents());
                            break;
                        case 1:
                            P.dmg = Integer.parseInt(cell.getContents());
                            break;
                        case 2:
                            P.lvl = Integer.parseInt(cell.getContents());
                            break;
                        case 3:
                            P.coins = Integer.parseInt(cell.getContents());
                            break;
                        case 4:
                            P.potions = Integer.parseInt(cell.getContents());
                            break;
                    }
                }
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    private void createLabel(WritableSheet sheet) throws WriteException {
        // Lets create a times font
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // Define the cell format
        times = new WritableCellFormat(times10pt);
        // Lets automatically wrap the cells
        times.setWrap(true);

        // create create a bold font with unterlines
        WritableFont times10ptBoldUnderline = new WritableFont(
                WritableFont.TIMES, 10, WritableFont.BOLD, false,
                UnderlineStyle.SINGLE);
        timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
        // Lets automatically wrap the cells
        timesBoldUnderline.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setAutosize(true);

        // Write a few headers
        addCaption(sheet, 0, 0, "HP");
        addCaption(sheet, 0, 1, "DMG");
        addCaption(sheet, 0, 2, "Lvl");
        addCaption(sheet, 0, 3, "Coins");
        addCaption(sheet, 0, 4, "Potions");
        addCaption(sheet, 0, 5, "Weapon");
    }

    private void createContent(WritableSheet sheet, Player X) throws WriteException, RowsExceededException {
        // Write numbers
        addNumber(sheet, 1, 0, X.hp);
        addNumber(sheet, 1, 1, X.dmg);
        addNumber(sheet, 1, 2, X.lvl);
        addNumber(sheet, 1, 3, X.coins);
        addNumber(sheet, 1, 4, X.potions);
    }

    private void addNumber(WritableSheet sheet, int column, int row, Integer integer) throws WriteException, RowsExceededException {
        Number number;
        number = new Number(column, row, integer, times);
        sheet.addCell(number);
    }

    private void addLabel(WritableSheet sheet, int column, int row, String s) throws WriteException, RowsExceededException {
        Label label;
        label = new Label(column, row, s, times);
        sheet.addCell(label);
    }

    private void addCaption(WritableSheet sheet, int column, int row, String s) throws RowsExceededException, WriteException {
        Label label;
        label = new Label(column, row, s, timesBoldUnderline);
        sheet.addCell(label);
    }
}
