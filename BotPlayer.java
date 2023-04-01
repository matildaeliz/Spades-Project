import java.util.Random;


public class BotPlayer extends Player {
    public BotPlayer() {

        super();
    }

        public void bidsForEnter () {
            Random rand = new Random();
            int randomNum = rand.nextInt(6);
            bid = randomNum;



        }


    }
