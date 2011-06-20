package predator.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
	
		addButtonWL ("setup"," Setup ")//executed method and Button Label
		addButtonWL ("go","Go Once ")
		addToggleButtonWL ("go","Go")
		
		addSliderWL("numRabbits", " Number of Rabbits ", 1, 1, 100, 50)//sliders with range
		addSliderWL("numWolfs", " Number of Wolves ", 1, 1, 20, 5)
		addSliderWL("rateRabbit", " Rabbit Reproduction Rate ", 1, 1, 100, 60)
		addSliderWL("rateWolf", " Wolf Reproduction Rate ", 1, 1, 100, 50)
		addSliderWL("grassEnergy","Grass energy maximum: ", 1, 1, 10, 5)
		addMonitorWL("remainingRabbits", " Remaining Rabbits ", 5)//shows remaining humans
		addMonitorWL("remainingWolfs", " Remaining Wolves ", 5)

	}
}