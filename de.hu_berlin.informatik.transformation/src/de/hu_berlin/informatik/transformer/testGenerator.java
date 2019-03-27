package de.hu_berlin.informatik.transformer;

public class testGenerator {

	public static void main(String[] args) {
		
		String dftUri = "/home/rob/runtime-EclipseApplication/Generated Models/";
		//String editedDftUri = "/home/rob/runtime-EclipseApplication/Generated Models/";
		
		DftGenerator dftGen = new DftGenerator();
		int dftNr = 2;
		int nrOfEvents = 5;
		int eventsToGatesRatio = 1; //ratio for x is: 1/(x-1)
		int nrOfDependencies = 2;
		dftGen.generateDFT(dftUri, "Test" + dftNr, nrOfEvents, eventsToGatesRatio, nrOfDependencies);
		
		dftGen.outputListsToConsole();
		
		dftGen.editRandomly(5, 1, dftUri + "Test" + dftNr + "edited.dynamicfaulttree");

	}

}
