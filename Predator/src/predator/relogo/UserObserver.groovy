package predator.relogo



import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.BaseObserver;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;

class UserObserver extends BaseObserver{
		
		def relogoRun=0
		def setup(){
			relogoRun++
			clearAll()//clear all existing entities
			
			//Rabbit-turtle
			setDefaultShape(Rabbit,"rabbit")//define fault shape
			createRabbits(numRabbits){
				color=brown()
				setxy ( randomXcor (), randomYcor ())
				energyR=8
			}
					
			//Wolf-turtle
			setDefaultShape(Wolf,"wolf")
			createWolfs(numWolfs){
				color=gray()
				setxy ( randomXcor (), randomYcor ())//randomly scatter entities
				energyW=10
			}
			
			//Grass Patch
			ask(patches()){
				pcolor=green()
				grassLevel=grassEnergy
			}
		}
		def go(){
			ask(rabbits()){
				step()
			}
			ask(wolfs()){
				step()
			}
			ask(patches()){
				grow()
			}
			tick()//increments the ReLogo counter every time go is executed.
		}
		
		def timestamp(){// Tracks ReLogo Counter
			ticks()
		}
		
		def remainingRabbits(){
			count(rabbits())
		}
		
		def remainingWolfs(){
			count(wolfs())
		}
		
}