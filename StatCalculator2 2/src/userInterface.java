import java.io.IOException;
import java.util.Scanner;

public class userInterface extends formulas{
	
	static double zScore = readCharts.getZScore();
	static double tValue = readCharts.getTValue();
	
	static double answer1 = 0.0;
	
	static boolean conditionsBool = false;
	static int oneOrTwo = 0;
	static String answer = "0.0";
	
	static double confidenceLevel = 0;
	static double alphaLevel = 0.0;
	static double sampleSize = 0.0;
	static double sampleSize2 = 0.0;
	static double df = 0.0;
	static double pValue = 0.0;
	static double nullA = 0.0;
	static double nullA2 = 0.0;
	
	// variables for proportions
	
	static double pHat = 0.0;
	static double pHat2 = 0.0;
	static double combinedPHat = 0.0;
	static double YpHat = 0.0;
	static double YpHat2 = 0.0;
	
	// variables for means
	
	static double standardDeviation = 0.0;
	static double standardDeviation2 = 0.0;
	static double xBar = 0.0;
	static double xBar2 = 0.0;
	
	// variables for slope
	
	static double slope = 0.0;
	
	static Scanner scan = new Scanner(System.in);
	
	// random and 10% conditions
	
	
	static boolean isInterval = false;
	static boolean isTest = false;
	
	static boolean isProportion = false;
	static boolean isMeans = false;
	static boolean isSlope = false;
	
	public static void conditions() {
		System.out.println("Are there random samples or an approximately Normal"
				+ " distribution? (y/n)");
		String randomInput = scan.next();
		
		System.out.println("Is/Are the sample(s) less than 10% of the population? (y/n)");
		String tenPercentInput = scan.next();
		
		if(randomInput.equals("y") && tenPercentInput.equals("y")) {
			conditionsBool = true;
		}
		else {
			System.out.println("Sorry, the conditions are not met.");
		}
	}
		
	// prompts user to enter data

	public static void main(String[] args) throws IOException {
		
		boolean userContinue = true;
		
		loop: while(userContinue) {
			
			System.out.println();
		
		System.out.println("Welcome to the Statistical Inference Calculator! "
				+ "Press any key to continue or 'x' to escape.");

		
		String userInput = scan.next();
		
		if(userInput.equals("x")) {
			System.out.println("Thank you for using the calculator!");
			break;
		}

		System.out.println("Interval (1) or Test (2)?");
			
		String intervalOrTest = scan.next();
			
			switch(intervalOrTest) {
			case "1":
				isInterval = true;
				break;
			case "2":
				isTest = true;
				break;
			default:
				System.out.println("Error: invalid input.");
				System.out.println();
				continue;
			}
			
		System.out.println("Proportion (1) or Means (2)?"); // or Slope (3)
			
		String populationParameter = scan.next();
			
			switch(populationParameter) {
			case "1":
				isProportion = true;
				break;
			case "2":
				isMeans = true;
				break;
			case "3":
				isSlope = true;
				break;
			default:
				System.out.println("Error: invalid input.");
				System.out.println();
				continue;
			}
			
			conditions();
			
			if(!conditionsBool) {
				break loop;
			}
			
			if(!isSlope) {
				System.out.println("Are there one or two samples? (1 or 2)");
					oneOrTwo = scan.nextInt();
					
				System.out.println("What is the sample size?");
					sampleSize = scan.nextDouble();
					
					if(oneOrTwo == 2) {
						System.out.println("What is the second sample size?");
							sampleSize2 = scan.nextDouble();
						}
					}
			
			// confidence level/alpha level
		
			if(isInterval) {
				System.out.println("What is the confidence level? (50, 80, 90, 95, 98, 99.5)");
					confidenceLevel = scan.nextDouble();
			}
			
			if(isTest) {
				System.out.println("What is the alpha level?");
					alphaLevel = scan.nextDouble();
			}
			
			// conditions for proportions, p hats
			
			if(isProportion) {
				System.out.println("What is the expected sample proportion (p-hat)?");
					nullA = scan.nextDouble();
					
					System.out.println("What is your sample proportion (p-hat)?");
					pHat = scan.nextDouble();
					
						if((pHat * sampleSize < 10 || (1 - pHat) * sampleSize < 10) && !isTest) {
							System.out.println("Sorry, the conditions are not met.");
						}
						
						if(oneOrTwo == 2) {
							System.out.println("What is the second expected proportion (p-hat)?");
								nullA2 = scan.nextDouble();
								
								System.out.println("What is your sample proportion (p-hat)?");
								pHat2 = scan.nextDouble();
								
							if((pHat2 * sampleSize < 10 || (1 - pHat2) * sampleSize < 10) && !isTest) {
								System.out.println("Sorry, the conditions are not met.");
							}
						}
					
					if(isTest && oneOrTwo == 2) {
						combinedPHat = ((pHat * sampleSize) + (pHat2 * sampleSize2)) / (sampleSize + sampleSize2);
						
						if(combinedPHat * sampleSize < 10 || combinedPHat * sampleSize2 < 10
								|| (1 - combinedPHat) * sampleSize < 10 || (1 - combinedPHat) * sampleSize2 < 10) {
							System.out.println("Sorry, the conditions are not met.");
						}
					}
				
			}
			
			// conditions for means, x bar, sd
			
			if(isMeans) {
				System.out.println("Is the data approximately Normal or greater than 30? (y/n)");
					String normal = scan.next();
					
					if(!normal.equals("y")) {
						System.out.println("Sorry, the conditions are not met.");
						break loop;
					}
					
				System.out.println("What is the sample mean (x-bar)?");
					xBar = scan.nextDouble();
				System.out.println("What is the standard deviation?");
					standardDeviation = scan.nextDouble();
				df = sampleSize - 1;
					
					if(oneOrTwo == 2) {
						System.out.println("What is the second sample mean (x-bar)?");
							xBar2 = scan.nextDouble();
						System.out.println("What is the second standard deviation?");
							standardDeviation2 = scan.nextDouble();
							
							if(sampleSize < sampleSize2) {
								df = sampleSize - 1;
							}
							else {
								df = sampleSize2 - 1;
							}
					}
			}
			
			// conditions for slope
			
			if(isSlope) {
				System.out.println("Is the relationship between x and y fairly linear? (y/n)");
					String linear = scan.next();
				System.out.println("Is the distribution of y approximately Normal? (y/n)");
					String normal = scan.next();
				System.out.println("Does every y have the same standard deviation? (y/n)");
					String sd = scan.next();
					
				if(linear.equals("y") || normal.equals("y") || sd.equals("y")) {
					conditionsBool = true;
				}
				
				else {
					System.out.println("Sorry, the conditions are not met.");
					break loop;
				}
				
				System.out.println("What is the slope (b)?");
					slope = scan.nextDouble();
				
				System.out.println("What is the standard error (SE)?");
					standardDeviation = scan.nextDouble();
			}
			
			if(isInterval) {
				
				if(oneOrTwo == 1) {
				
					if(isProportion) {
						answer = oneSampleZIntervalForP(pHat, zScore, sampleSize);
					}
					
					if(isMeans) {
						answer = oneSampleTIntervalForMu(xBar, tValue, standardDeviation, sampleSize);
					}
					
				}
				
				else {
					if(isProportion) {
						answer = twoSampleZIntervalForP1P2(pHat, pHat2, zScore, sampleSize, sampleSize2);
					}
					
					if(isMeans) {
						answer = twoSampleTIntervalForMu1Mu2(xBar, xBar2, tValue, standardDeviation, 
								standardDeviation2, sampleSize, sampleSize2);
					}
				}
				
				//	if(isSlope) {
				//		pairedTIntervalForMuDiff(xBarDiff, tValue, SDDiff, nDiff);
				//	}
				
				System.out.println("We are " + confidenceLevel + "% confident that "
					+ "the interval " + answer + " captures the true population parameter.");
			}
			
			if(isTest) {
				
				if(oneOrTwo == 1) {
				//	System.out.println("hiiiii");
					if(isProportion) {
					//	System.out.println(" " + pHat + " " + nullA + " " + sampleSize);
						answer1 = oneSampleZTestForP(pHat, nullA, sampleSize);
					//	System.out.println("uI:" + answer);
						//pValue = readCharts.getPValue();
						//System.out.println("pvalue " + pValue);
					}
					
					if(isMeans) {
						answer = oneSampleTTestForMu(xBar, nullA , sampleSize, standardDeviation);
						pValue = Double.parseDouble(answer);
					}
				
				}
				
				else {
					
					if(isProportion) {
						answer = twoSampleZTestForP1P2(pHat, pHat2, combinedPHat, sampleSize, sampleSize2);
						pValue = Double.parseDouble(answer);
					}
					
					if(isMeans) {
						answer = twoSampleTTestForMu1Mu2(xBar, xBar2, standardDeviation, standardDeviation2, 
								sampleSize, sampleSize2);
						pValue = Double.parseDouble(answer);
					}
			
				}
				
			//	if(isSlope) {
			//		answer = pairedTTestForMuDiff(xBarDiff, muNull, SDDiff, nDiff);
			//		pValue = Double.parseDouble(answer);
			//	}
				
				String pValueEquality = "";
				String convincingEvidence = "";
				
				if(Double.parseDouble(answer) >= alphaLevel) {
					pValueEquality = "greater than or equal to ";
					convincingEvidence = "not ";
				}
				else {
					pValueEquality = "less than ";
					
				}
				
				System.out.println("Because " + answer1 + " is " + pValueEquality + alphaLevel +
						" there is " + convincingEvidence + "convincing evidence"
						+ " that the alternate hypothesis is correct.");
			}
			
		} // bracket for loop
		
	} // bracket for main class
	
	public static double getConfidenceLevel() {
		return confidenceLevel;
	}

	public static double getDf() {
		return df;
	}
	
	public static boolean getIsProportions() {
		return isProportion;
	}
	
	public static boolean getIsTest() {
		return isTest;
	}
	
	
}
