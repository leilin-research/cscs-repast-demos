package predator.relogo
import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.BasePatch;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.ast.Diffusible;

class UserPatch extends BasePatch{
	
	def grassLevel
	
	def decrementGrass() {//in Rabbit class
		if (grassLevel>0){
			grassLevel=grassLevel-2
			if(grassLevel==0){
				 pcolor = brown()
			}
			else if(grassLevel<=2){
				pcolor =yellow()
			}
			else{
				 pcolor =green()
			}
		}
	}
	
	def grow(){//in Observer
		if(count(rabbitsHere())==0){//just increment when no rabbit there
			
			if (grassLevel < 5) {
				grassLevel=grassLevel+0.3
				if(grassLevel==0){
					 pcolor = brown()
				}
				else if(grassLevel <= 2){
					pcolor =yellow()
				}
				else{
					 pcolor =green()
				}
				return true
			}
			return false
		}
	}
	
	
}