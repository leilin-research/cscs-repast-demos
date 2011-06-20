package predator.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.BasePatch;
import repast.simphony.relogo.BaseTurtle;
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;

class Wolf extends BaseTurtle{
	
	def energyW
	
	//def offspringduration=0
	def step(){
		def food=maxOneOf(neighbors()){
			count(rabbitsOn(it))
		}
		if(rabbitsOn(food)){
			face(food)
		}
		else{
			facexy(randomPxcor(),randomPycor())
		}
		
		forward(2)
		energyW=energyW-1//energy lose after moving
		
		
		if(rabbitsHere()){
			energyW=energyW+3//Energy gain from eaten Rabbit
			def prey=oneOf(rabbitsHere())//link to eaten Entity
			prey.die()//rabbit dies
		}
		
		if(energyW>=3){// energy level high enough to reproduce
			if((rateWolf/100)>randomFloat(1)){
					hatchWolfs(1)
					energyW=energyW/2
			}
		}
		if(energyW<=0){
			die()
		}	
		
	}
	
}
