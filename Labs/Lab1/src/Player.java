/**
 * This class represents a hockey player. Each hockey player has a name, a position, and a jersey number
 * @author william vo
 */
public class Player {

    private String name;
    private String position;
    private int jerseyNum;

    /**
     * Constructor creates player object with a name, position, and jersey number
     * @param name name of the player
     * @param position position of the player
     * @param jerseyNum jersey number of the player
     */
    public Player(String name, String position, int jerseyNum) {
        this.name = name;
        this.position = position;
        this.jerseyNum = jerseyNum;
    }

    /**
     * Accessor method to get the name of a hockey player
     * @return name of hockey player
     */
    public String getName() {
        // Get the player's name.
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getJerseyNum() {
        return jerseyNum;
    }

    /**
     * Setter method to allow user to set a new name for a hockey player
     * @param newName new name for the hockey player
     */
    public void setName(String newName) {
        this.name = newName;
    }

    public void setPosition(String newPosition) {
        this.position = newPosition;
    }

    public void setJerseyNum(int newJerseyNum) {
        this.jerseyNum = newJerseyNum;
    }

    public String toString() {
        return this.name + ": #" + this.jerseyNum;
    }

    public boolean equals(Player other) {
        return this.name.equals(other.name) && this.jerseyNum == other.jerseyNum;
    }
}