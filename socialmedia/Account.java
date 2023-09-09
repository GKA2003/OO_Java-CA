package socialmedia;

import java.io.Serializable;

/**
 * Account class which contains all the methods and attributes of an Account.
 *
 * An Account has a unique ID (incrementing sequentially), a handle (username), a description (user bio),
 * a post count and an endorsement count.
 *
 * @author 720047329
 * @author 720060290
 * @version 1.0
 */
public class Account implements Serializable {

    /**
     * The account id.
     */
    private int id;

    /**
     * The account handle.
     */
    private String handle;

    /**
     * The account description.
     */
    private String description;

    /**
     * The account's post count.
     */
    private int postCount;

    /**
     * The account's endorsement count.
     */
    private int endorsementCount;

    /**
     * Method to get the ID of a user.
     * @return An int of the ID of a user.
     */
    public int getId() {
        return id;
    }

    /**
     * Method to set the ID of a user.
     * @param id an int of the ID of a user.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method to get the handle of a user.
     * @return A String of the handle of a user.
     */
    public String getHandle() {
        return handle;
    }

    /**
     * Method to set the handle of a user.
     * @param handle the new handle of a user.
     */
    public void setHandle(String handle) {
        this.handle = handle;
    }

    /**
     * Method to get the description of a user.
     * @return A String of the description of a user.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to set the description of a user.
     * @param description the new description of a user.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method to get the number of posts from a user.
     * @return An int of how many posts the user has.
     */
    public int getPostCount() {
        return postCount;
    }

    /**
     * Method to increment the post count of a user.
     */
    public void increasePostCount() {
        postCount++;
    }

    /**
     * Method to decrement the post count of a user.
     */
    public void decreasePostCount() {
        postCount--;
    }

    /**
     * Method to get the number of endorsements a user has received.
     * @return An int of how many endorsements a user has received.
     */
    public int getEndorsementCount() {
        return endorsementCount;
    }

    /**
     * Method to increment the number of endorsements a user has received.
     */
    public void increaseEndorsementCount() {
        endorsementCount++;
    }

    /**
     * Method to decrement the number of endorsements a user has received.
     */
    public void decreaseEndorsementCount() {
        endorsementCount--;
    }

    /**
     * Constructor method for Account.
     * @param id The int for the post id.
     * @param handle The String for the user handle.
     */
    public Account (int id, String handle) {
        this.id = id;
        this.handle = handle;
        this.description = "";
        this.postCount = 0;
        this.endorsementCount = 0;
    }

    /**
     * Constructor method for Account.
     * @param id The int for the post id.
     * @param handle The String for the user handle.
     * @param description The String for the user description.
     */
    public Account (int id, String handle, String description) {
        this(id, handle);
        this.description = description;
    }

    /**
     * Method to output the string representation of the Account object.
     * @return The String of the string representation.
     */
    @Override
    public String toString() {
        return "ID: " + id + "\nHandle: " + handle + "\nDescription: " + description + "\nPost Count: " + postCount + "\nEndorsement Count: " + endorsementCount;
    }

}
