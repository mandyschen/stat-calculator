import java.io.IOException;

public class formulas {

	
	static double finalZScore = 0.0;
	static double finalTScore = 0.0;
	
	public static String oneSampleZIntervalForP(double pHat, double zScore, 
			double nValue) {
		
		 
		
		double intervalStart = pHat - (zScore 
				* Math.sqrt((pHat * (1 - pHat)) / nValue));
		double intervalEnd = pHat + (zScore 
				* Math.sqrt((pHat * (1 - pHat)) / nValue));
		
		String oneSampleZIntervalforPAns = "(" + intervalStart + ", " 
				+ intervalEnd + ")";
		
		return oneSampleZIntervalforPAns;
		
	}
	
	public static double oneSampleZTestForP(double pHat, double pNull, 
			double nValue) throws IOException {
		
		finalZScore = (double) (pHat - pNull) / 
				(double)(Math.sqrt(((double) pNull * (1 - pNull)) / (double) nValue));
		// System.out.println("formulas: " + finalZScore);
		 readCharts.test(finalZScore);
		 double oneSampleZTestforPAns = 1 - readCharts.getPValue();
		
		return oneSampleZTestforPAns;
		
	}
	
	public static String twoSampleZIntervalForP1P2(double pHat1,
			double pHat2, double zScore, double nValue1, double nValue2){
		
		double intervalStart = (pHat1 - pHat2) - (zScore
				* (Math.sqrt( (((pHat1 * (1 - pHat1)) / nValue1))
				+ ((pHat2 * (1 - pHat2)) / nValue2))));
		double intervalEnd = (pHat1 - pHat2) + (zScore
				* (Math.sqrt( (((pHat1 * (1 - pHat1)) / nValue1))
				+ ((pHat2 * (1 - pHat2)) / nValue2))));
		
		String twoSampleZIntervalForP1P2Ans = "(" + intervalStart + ", " 
				+ intervalEnd + ")";
		
		return twoSampleZIntervalForP1P2Ans;
	}
	
	public static String twoSampleZTestForP1P2(double pHat1,
			double pHat2, double pHatC, double nValue1, double nValue2){
		
		finalZScore = (pHat1 - pHat2)
				/ (Math.sqrt( (((pHatC * (1 - pHatC)) / nValue1)
						+ ((pHatC * (1 - pHatC)) / nValue2))));
				
		String twoSampleZTestForP1P2Ans = "" + readCharts.getPValue();
		
		return twoSampleZTestForP1P2Ans;
	}
	
	public static String oneSampleTIntervalForMu(double xBar, double tValue, 
			double sampleSD, double nValue) {
		
		double intervalStart = xBar - (tValue * (sampleSD / (Math.sqrt(nValue))));
		double intervalEnd = xBar + (tValue * (sampleSD / (Math.sqrt(nValue))));
		
		String oneSampleTIntervalforMuAns = "(" + intervalStart + ", " 
				+ intervalEnd + ")";
		
		return oneSampleTIntervalforMuAns;
		
	}
	
	public static String oneSampleTTestForMu(double xBar, double muNull, 
			double nValue, double sampleSD) {
		
		finalZScore = (xBar - muNull) 
				/ (sampleSD / Math.sqrt(nValue));
		
		String oneSampleTTestforMuAns = "" + readCharts.getPValue();
		
		return oneSampleTTestforMuAns;
		
	}

	public static String twoSampleTIntervalForMu1Mu2(double xBar1, double xBar2, 
			double tValue, double sampleSD1, double sampleSD2, double nValue1,
			double nValue2) {
		
		double intervalStart = (xBar1 - xBar2) 
				- (tValue * (Math.sqrt( ((sampleSD1 * sampleSD1)/ nValue1)
						+ ((sampleSD2 * sampleSD2)/ nValue2))));
		double intervalEnd = (xBar1 - xBar2) 
				+ (tValue * (Math.sqrt( ((sampleSD1 * sampleSD1)/ nValue1)
						+ ((sampleSD2 * sampleSD2)/ nValue2))));
		
		String twoSampleTIntervalforMu1Mu2Ans = "(" + intervalStart + ", " 
				+ intervalEnd + ")";
		
		return twoSampleTIntervalforMu1Mu2Ans;
		
	}
	
	public static String twoSampleTTestForMu1Mu2(double xBar1, double xBar2, 
			double sampleSD1, double sampleSD2, double nValue1, double nValue2) {
		
		finalTScore = (xBar1 - xBar2) 
				/ ((Math.sqrt( ((sampleSD1 * sampleSD1)/ nValue1)
						+ ((sampleSD2 * sampleSD2)/ nValue2))));
				
		String twoSampleTTestForMu1Mu2Ans = "" + readCharts.getPValue();
		
		return twoSampleTTestForMu1Mu2Ans;
	}
	
	public static String pairedTIntervalForMuDiff(double xBarDiff, double tValue,
			double SDDiff, double nDiff) {
		
		double intervalStart = xBarDiff - (tValue * (SDDiff / Math.sqrt(nDiff)));
		double intervalEnd = xBarDiff + (tValue * (SDDiff / Math.sqrt(nDiff)));
		
		String pairedTIntervalForMuDiffAns = "" + "(" + intervalStart + ", " 
				+ intervalEnd + ")";
		
		return pairedTIntervalForMuDiffAns;
	}
	
	public static String pairedTTestForMuDiff(double xBarDiff, double muNull,
			double SDDiff, double nDiff) {
		
		finalTScore = (xBarDiff - muNull) / (SDDiff / Math.sqrt(nDiff));
		
		String pairedTTestForMuDiffAns = "" + readCharts.getPValue();
		
		return pairedTTestForMuDiffAns;
	}
	
	public static double getFinalZScore() {
		return finalZScore;
	}
	
	public static double getFinalTScore() {
		return finalTScore;
	}
	
	public static boolean needsZ() {
		
		boolean needsZ = false;
		
		if(finalZScore != 0.0) {
			needsZ = true;
		}
		else {
			needsZ = false;
		}
		
		return needsZ;
	}
	
}
