package com.github.mrcaoyc.database.document.service.impl;

import com.github.mrcaoyc.database.document.model.dto.ColumnDTO;
import com.github.mrcaoyc.database.document.model.dto.TableDTO;
import com.github.mrcaoyc.database.document.service.ColumnService;
import com.github.mrcaoyc.database.document.service.DocumentService;
import com.github.mrcaoyc.database.document.service.TableService;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author caoyongcheng
 */
@Service
public class DocumentServiceImpl implements DocumentService {
    private final TableService tableService;
    private final ColumnService columnService;

    public DocumentServiceImpl(TableService tableService, ColumnService columnService) {
        this.tableService = tableService;
        this.columnService = columnService;
    }

    @Override
    public void generateDatabaseDocumentWord(Long dataSourceConfigurationId, OutputStream outputStream) {
        List<TableDTO> tables = tableService.listTables(dataSourceConfigurationId);
        XWPFDocument document = new XWPFDocument();
        createStyle(document);
        AtomicInteger number = new AtomicInteger(1);
        tables.forEach(tableDTO -> {
            drawTitle(document, tableDTO, number);
            drawTable(document, tableDTO, dataSourceConfigurationId);
        });
        try {
            document.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createStyle(XWPFDocument document) {
        addCustomHeadingStyle(document, document.createStyles(), "标题1", 1, 20, "000000");
    }

    private void drawTitle(XWPFDocument document, TableDTO tableDTO, AtomicInteger number) {
        XWPFParagraph paragraph = document.createParagraph();
        // 需要和addCustomHeadingStyle配合使用才有效果
        paragraph.setStyle("标题1");
        paragraph.setSpacingBefore(200);

        XWPFRun run = paragraph.createRun();
        String tableName = StringUtils.hasText(tableDTO.getDescription()) ?
                number.getAndIncrement() + "." + tableDTO.getName() + "(" + tableDTO.getDescription() + ")" :
                number.getAndIncrement() + "." + tableDTO.getName();
        run.setText(tableName);
        run.setFontSize(20);
    }


    private void drawTable(XWPFDocument document, TableDTO tableDTO, Long dataSourceConfigurationId) {
        XWPFTable xTable = document.createTable();
        fillColumnTitle(xTable);
        fillColumns(xTable, dataSourceConfigurationId, tableDTO.getName());
        xTable.setWidth("100%");
    }

    /**
     * 填充列头，如果列名，列类型，默认值，描述
     *
     * @param xTable xTable
     */
    private void fillColumnTitle(XWPFTable xTable) {
        XWPFTableRow row = xTable.getRow(0);
        row.setHeight(400);
        XWPFTableCell cellColumnName = row.getCell(0);
        XWPFTableCell cellColumnType = row.createCell();
        XWPFTableCell cellColumnAllowNull = row.createCell();
        XWPFTableCell cellColumnDefault = row.createCell();
        XWPFTableCell cellColumnComment = row.createCell();

        cellColumnName.setText("列名");
        cellColumnType.setText("列类型");
        cellColumnAllowNull.setText("允许为空");
        cellColumnDefault.setText("默认值");
        cellColumnComment.setText("描述");

        cellColumnName.setWidth("20%");
        cellColumnType.setWidth("20%");
        cellColumnAllowNull.setWidth("20%");
        cellColumnDefault.setWidth("20%");
        cellColumnComment.setWidth("20%");

        cellColumnName.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        cellColumnType.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        cellColumnAllowNull.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        cellColumnDefault.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        cellColumnComment.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
    }

    private void fillColumns(XWPFTable xTable, Long dataSourceConfigurationId, String tableName) {
        List<ColumnDTO> columns = columnService.listColumns(dataSourceConfigurationId, tableName);
        if (CollectionUtils.isEmpty(columns)) {
            return;
        }
        columns.forEach(column -> {
            XWPFTableRow row = xTable.createRow();

            XWPFTableCell cellColumnName = row.getCell(0);
            XWPFTableCell cellColumnType = row.getCell(1);
            XWPFTableCell cellColumnAllowNull = row.getCell(2);
            XWPFTableCell cellColumnDefault = row.getCell(3);
            XWPFTableCell cellColumnComment = row.getCell(4);

            row.setHeight(400);


            cellColumnName.setText(column.getColumnName());
            cellColumnType.setText(column.getColumnType());
            cellColumnAllowNull.setText(column.getIsNullable());
            cellColumnDefault.setText(Objects.isNull(column.getColumnDefault()) ? null : column.getColumnDefault().toString());
            cellColumnComment.setText(column.getColumnComment());

            cellColumnName.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
            cellColumnType.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
            cellColumnAllowNull.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
            cellColumnDefault.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
            cellColumnComment.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        });
    }

    /**
     * word单元格列合并
     *
     * @param table     表格
     * @param row       合并列所在行
     * @param startCell 开始列
     * @param endCell   结束列
     * @date 2020年4月8日 下午4:43:54
     */
    public static void mergeCellsHorizontal(XWPFTable table, int row, int startCell, int endCell) {
        for (int i = startCell; i <= endCell; i++) {
            XWPFTableCell cell = table.getRow(row).getCell(i);
            if (i == startCell) {
                // The first merged cell is set with RESTART merge value
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    private static void addCustomHeadingStyle(XWPFDocument docxDocument, XWPFStyles styles, String strStyleId, int headingLevel, int pointSize, String hexColor) {

        CTStyle ctStyle = CTStyle.Factory.newInstance();
        ctStyle.setStyleId(strStyleId);


        CTString styleName = CTString.Factory.newInstance();
        styleName.setVal(strStyleId);
        ctStyle.setName(styleName);

        CTDecimalNumber indentNumber = CTDecimalNumber.Factory.newInstance();
        indentNumber.setVal(BigInteger.valueOf(headingLevel));

        // lower number > style is more prominent in the formats bar
        ctStyle.setUiPriority(indentNumber);

        CTOnOff onoffnull = CTOnOff.Factory.newInstance();
        ctStyle.setUnhideWhenUsed(onoffnull);

        // style shows up in the formats bar
        ctStyle.setQFormat(onoffnull);

        // style defines a heading of the given level
        CTPPr ppr = CTPPr.Factory.newInstance();
        ppr.setOutlineLvl(indentNumber);
        ctStyle.setPPr(ppr);

        XWPFStyle style = new XWPFStyle(ctStyle);

        CTHpsMeasure size = CTHpsMeasure.Factory.newInstance();
        size.setVal(new BigInteger(String.valueOf(pointSize)));
        CTHpsMeasure size2 = CTHpsMeasure.Factory.newInstance();
        size2.setVal(new BigInteger("24"));

        CTFonts fonts = CTFonts.Factory.newInstance();
        fonts.setAscii("Loma");

        CTRPr rpr = CTRPr.Factory.newInstance();
        rpr.setRFonts(fonts);
        rpr.setSz(size);
        rpr.setSzCs(size2);

        CTColor color = CTColor.Factory.newInstance();
        color.setVal(hexToBytes(hexColor));
        rpr.setColor(color);
        style.getCTStyle().setRPr(rpr);
        // is a null op if already defined

        style.setType(STStyleType.PARAGRAPH);
        styles.addStyle(style);

    }

    public static byte[] hexToBytes(String hexString) {
        HexBinaryAdapter adapter = new HexBinaryAdapter();
        byte[] bytes = adapter.unmarshal(hexString);
        return bytes;
    }
}
