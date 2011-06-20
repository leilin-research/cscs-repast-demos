package predator.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.BasePatch;
import repast.simphony.relogo.BaseTurtle;
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;

class Rabbit extends BaseTurtle{

	def energyR
	
	def step(){
		
		def max = maxOneOf(neighbors()){
			grassLevel
		}
		//maybe add method to see where wolves are at
		
			face(max)
			forward(1)
			energyR=energyR-1//running away exhausts rabbit
		
		if(energyR>3){//4 is min energy level for rabbits to be able to hatch offsprings
			if((rateRabbit/100)>randomFloat(1)){//birthrate check
					hatchRabbits(1)
					energyR=energyR/2// half energy as giving birth costed energy
			}
		}
		
		if(energyR<=0){//when rabbit has no energy rabbit dies
			die()
		}
	
		def p = patchHere()// return patch on which rabbit is located
		if(p.grassLevel > 0) {
			// eat the grass by decrementing the grass level
			energyR=energyR+2
			p.decrementGrass()
		}
		
	}
	
}
