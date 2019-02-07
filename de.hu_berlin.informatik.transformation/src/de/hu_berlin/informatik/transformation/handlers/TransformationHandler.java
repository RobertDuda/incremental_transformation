package de.hu_berlin.informatik.transformation.handlers;

import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import de.hu_berlin.informatik.dynamicFaultTree.DFT;
import de.hu_berlin.informatik.transformer.ModelManager;
import de.hu_berlin.informatik.transformer.Transformer;

import org.eclipse.jface.dialogs.MessageDialog;

public class TransformationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		String dftUriString = null;
		String ctmcUri = null;
		
		
		//set up for the dft
		JOptionPane.showMessageDialog(null, "Please select a fault tree...", "DFT to CTMC", JOptionPane.PLAIN_MESSAGE);
		JFileChooser fileChooserDft = new JFileChooser();
		FileNameExtensionFilter filterdft = new FileNameExtensionFilter("dynamic fault trees", "dynamicfaulttree");
		fileChooserDft.setFileFilter(filterdft);
		fileChooserDft.setDialogTitle("Select a dynamic Fault Tree");
		fileChooserDft.showOpenDialog(null);
		File fileDft = fileChooserDft.getSelectedFile();
		
		URI dftUri = URI.createURI("File:///" + fileDft.getAbsolutePath());
		DFT dft = null;
		ModelManager modMan = null;
		try {
			modMan = new ModelManager(dftUri, "dynamicfaulttree");
			dft = modMan.loadDFT();
			JOptionPane.showMessageDialog(null, "Loaded the DFT " + dft.getName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		//transformation
		Transformer trans = new Transformer();
		trans.preparation(dft);
		trans.transformation();
		String dataFolder = fileDft.getParentFile().getAbsolutePath();
		trans.saveTransformationData(dataFolder, dft.getName()+" Transformation Data", dft);
		
		//building the ctmc
		JOptionPane.showMessageDialog(null, "Please select the destination folder for the CTMC...", "DFT to CTMC", JOptionPane.PLAIN_MESSAGE);
		JFileChooser fileChooserCtmc = new JFileChooser();
		fileChooserCtmc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooserCtmc.setDialogTitle("Select a Directory...");
		fileChooserCtmc.showOpenDialog(null);
		//JOptionPane.showMessageDialog(null, fileChooserCtmc.getSelectedFile(), "", JOptionPane.PLAIN_MESSAGE);
		
		ctmcUri = "File:///" +fileChooserCtmc.getSelectedFile() + "\\"+ JOptionPane.showInputDialog("please enter a file name.") + ".ctmc";
		//JOptionPane.showMessageDialog(null, ctmcUri, "boop", JOptionPane.PLAIN_MESSAGE);
		
		try {
			trans.buildCTMC(ctmcUri);
			JOptionPane.showMessageDialog(null, "Transformation process complete..." + "\nPlease refresh the project folder(s)!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		//JOptionPane.showMessageDialog(null, "Transformation process complete..." + "\nPlease refresh the project folder!");
		//JOptionPane.showMessageDialog(null, "Transformation successfull! Refresh the ctmc project folder.");
		
		/*MessageDialog.openInformation(
				window.getShell(),
				"Transformer",
				"I AM MEGATRON!");
		*/
		//chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		
		return null;
	}
}
