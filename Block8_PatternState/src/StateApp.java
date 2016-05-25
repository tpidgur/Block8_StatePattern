import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by Зая on 25.05.2016.
 */
public class StateApp {
    public static void main(String[] args) {
        Human human = new Human();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            State state = generateRandomState();
            stateDescription(state);
            human.chooseActivity(state.name());
            human.doSomething();
        }


    }

    public static State generateRandomState() {
        Random random = new Random();
        int val = random.nextInt(3);
        State state = State.values()[val];
        return state;
    }

    public static void stateDescription(State state) {
        switch (state) {
            case FISHER:
                System.out.println("\nYou are on the river bank. What will you do?");
                break;
            case HUNTER:
                System.out.println("\nYou see an animal. What will you do?");
                break;
            case MUSHROOMER:
                System.out.println("\nYou see a mushroom on the forest meadow. What will you do?");
                break;
        }
    }
}

class Human {
    private Activity state;

    public void setState(Activity state) {
        this.state = state;
    }

    void doSomething() {
        state.doSomething();
    }

    void chooseActivity(String str) {
        switch (str) {
            case "FISHER":
                setState(new Fisher());
                break;
            case "HUNTER":
                setState(new Hunter());
                break;
            case "MUSHROOMER":
                setState(new Mushroomer());
                break;
        }


    }
}

interface Activity {
    void doSomething();
}

class Fisher implements Activity {
    @Override
    public void doSomething() {
        System.out.println("I'll fish!");
    }
}

class Hunter implements Activity {

    @Override
    public void doSomething() {
        System.out.println("I'll hunt!");
    }
}

class Mushroomer implements Activity {

    @Override
    public void doSomething() {
        System.out.println("I'll pick mushrooms.");
    }
}