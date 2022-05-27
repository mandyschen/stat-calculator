
import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;
import java.text.DecimalFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;  

	public class readCharts extends formulas{  
		
	//	System.setProperty("log4j.configurationFile","./path_to_the_log4j2_config_file/log4j2.xml");

	//	Logger log = LogManager.getLogger(LogExample.class.getName());
		
		static double df = userInterface.getDf();
		static double columnDf = 0.0;
		static double confidenceLevel = userInterface.getConfidenceLevel() / 200;
		private static final DecimalFormat dfd = new DecimalFormat("0.00");

		
		static double z = getFinalZScore(); // significance test only
		static double t = getFinalTScore(); // significance test only
		static double pValue = 0.0;
		static double zScore = 0.0;
		
		static double tValue = 0.0; 
		
		public static void main(String args[]) throws IOException {
			;
		}
		
		public static void test(double zz) throws IOException{
			confidenceLevel = userInterface.getConfidenceLevel() / 200;
			
			if(userInterface.getConfidenceLevel() == 0.0) {
				confidenceLevel = .01;
			}
		//	System.out.println("CL: " + confidenceLevel);
			// 50, 80, 90, 95, 98, 99.5
			
			if(confidenceLevel == 50) {
				columnDf = 1;
			}
			if(confidenceLevel == 80) {
				columnDf = 2;
			}
			if(confidenceLevel == 90) {
				columnDf = 3;
			}
			if(confidenceLevel == 95) {
				columnDf = 4;
			}
			if(confidenceLevel == 98) {
				columnDf = 5;
			}
			if(confidenceLevel == 99.5) {
				columnDf = 6;
			}
			
		FileInputStream fis = new FileInputStream(new File("/Users/mandychen/Downloads/testChartFinal.xls"));  
	
		HSSFWorkbook wb = new HSSFWorkbook(fis);

		HSSFSheet zTableSheet = wb.getSheetAt(1);
		HSSFSheet tTableSheet = wb.getSheetAt(2);
		
		Row row = null;
		Row row2 = null;
		Cell cell = null;
		int zRow = 0;
		Double num = 0.0;
		int zCol = 0;
		
		int rownum = zTableSheet.getLastRowNum() + 1;
        int colnum = zTableSheet.getRow(0).getLastCellNum();
        Double[][] zTable = new Double[rownum][colnum];
        
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator(); 
		
		for (int i = 0; i < rownum; i++) {
            row = zTableSheet.getRow(i);
            for (int j = 0; j < colnum; j++) {
            	cell = row.getCell(j); 

            	if(cell.getCellType() == CellType.STRING) {
            		continue;
            	}
                
               // System.out.println("i:"+i + " J: "+ j );
                zTable[i][j] = cell.getNumericCellValue();
                //System.out.println(cell.getNumericCellValue());
                
            }
		
		}
		
		for(int i = 0; i < rownum; i++) {
			for(int j = 0; j < colnum; j++) {
				if(zTable[i][0]!=null && zTable[0][j]!= null) {
				if(zTable[i][0] == Math.round(zz * 10.0) / 10.0) {
            		zRow = i;
            		num = Math.round(zz * 10.0) / 10.0;
            	}
					//System.out.println("num" + num);
            		//System.out.println("ldkfajd "+((Math.round(zz * 100.0) / 100.0)));
            		double temp = Double.parseDouble(dfd.format(((Math.round(zz*100)/100.0)-num)));
            		//System.out.println("round:" + dfd.format(((Math.round(zz*100)/100.0)-num)));
            		if(zTable[0][j] == temp) {
                		zCol = j;
            	}
				}
			}
		}
	//	System.out.println("zRow:" + zRow);
	//x
	///	System.out.println("zCol:" + zCol);
		pValue = zTable[zRow][zCol];
		
	//	System.out.println("hhkadhfks " +pValue);
		
		int rownum2 = tTableSheet.getLastRowNum() + 1;
        int colnum2 = tTableSheet.getRow(0).getLastCellNum();
        Double[][] tTable = new Double[rownum2][colnum2];
        
        int tRow = 0;
		int tCol = 0;
		
		for (int i = 0; i < rownum2; i++) {
            row2 = tTableSheet.getRow(i);

            for (int j = 0; j < colnum2; j++) {
            	
                cell = row2.getCell(j);
                
                if(cell.getCellType() == CellType.STRING) {
            		continue;
            	}
                
                tTable[i][j] = cell.getNumericCellValue();
            }
		
		}
		
		for(int i = 0; i < rownum2; i++) {
			for(int j = 0; j < colnum2; j++) {
				if(tTable[i][0]!=null && tTable[0][j]!= null) {
				if(tTable[i][0] == df) {
					tRow = i;
				}
			//	System.out.println(tTable[j][0] + "   " + confidenceLevel);
				if(tTable[0][j] == confidenceLevel) {
					tCol = j;
				}
			}}
		}
	//	System.out.println(tCol);
		tValue = tTable[tRow][tCol];
		zScore = tTable[103][tCol];
		
		}
		
		public static double getPValue() {
			return pValue;
		}
		
		public static double getZScore() {
			
			return zScore;
		}
		public static double getTValue() {
			return tValue;
		}
	}  