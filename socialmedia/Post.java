package socialmedia;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Post class which contains all the methods and attributes of a Post.
 *
 * A Post has a unique ID (incrementing sequentially), an Account that posted it, the post content,
 * a count of the number of comments, a count of the number of endorsements, its parent Post (if it is a comment),
 * the post this endorses (if it is an endorsement), and a list of all child posts (comments).
 *
 * @author 720047329
 * @author 720060290
 * @version 1.0
 */
public class Post implements Serializable {

    /**
     * The post id.
     */
    private int id;
    /**
     * The account associated with the post.
     */
    private Account account;
    /**
     * The post content.
     */
    private String postContent;
    /**
     * The number of comments.
     */
    private int commentCount;
    /**
     * The number of endorsements.
     */
    private int endorsementCount;
    /**
     * The parent post.
     */
    private Post parentPost;
    /**
     * The post this endorses.
     */
    private Post endorsementPost;
    /**
     * The list of child posts (comments).
     */
    private ArrayList<Post> childPost = new ArrayList<>();

    /**
     * Method to get the post id.
     * @return An int of the post id.
     */
    public int getId() {
        return id;
    }

    /**
     * Method to get the handle of the Account that made the post.
     * @return The Account object of the user.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Method to set the handle of the Account that made the post.
     * @param account The Account object of the user.
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Method to get the post content.
     * @return A String with the post content.
     */
    public String getPostContent() {
        return postContent;
    }

    /**
     * Method to set the post content.
     * @param postContent The new post content.
     */
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    /**
     * Method to get the number of comments on the post.
     * @return An int of the number of comments on the post.
     */
    public int getCommentCount() {
        return commentCount;
    }

    /**
     * Method to get the number of endorsements.
     * @return An int of the number of endorsements on the post.
     */
    public int getEndorsementCount() {
        return endorsementCount;
    }

    /**
     * Method to set the endorsement count.
     * @param endorsementCount the number of endorsements.
     */
    public void setEndorsementCount(int endorsementCount) {
        this.endorsementCount = endorsementCount;
    }

    /**
     * Method to increase the number of endorsements on the post.
     */
    public void increaseEndorsementCount (){
        endorsementCount++;
    }

    /**
     * Method to decrease the number of endorsements on the post.
     */
    public void decreaseEndorsementCount (){
        if (endorsementCount > 0) {
            endorsementCount--;
        }
    }

    /**
     * Method to increase the number of comments on the post.
     */
    public void increaseCommentCount (){
        commentCount++;
    }

    /**
     * Method to decrease the number of comments on the post.
     */
    public void decreaseCommentCount (){
        if (commentCount > 0) {
            commentCount--;
        }
    }

    /**
     * Method to get the parent post (if post is a comment).
     * @return A Post object of the parent post.
     */
    public Post getParentPost() {
        return parentPost;
    }

    /**
     * Method to set the parent post (if post is a comment).
     * @param parentPost The post to be set as the parent post.
     */
    public void setParentPost(Post parentPost) {
        this.parentPost = parentPost;
    }

    /**
     * Method to get the post this endorses (if post is an endorsement).
     * @return A Post object of the parent post.
     */
    public Post getEndorsementPost() {
        return endorsementPost;
    }

    /**
     * Method to set the post this endorses (if post is an endorsement).
     * @param endorsementPost The post that this post endorses.
     */
    public void setEndorsementPost(Post endorsementPost) {
        this.endorsementPost = endorsementPost;
    }

    /**
     * Method to get the child post (if post has a comment).
     * @return A Post object of the child post.
     */
    public ArrayList<Post> getChildPost() {
        return childPost;
    }

    /**
     * Method to set the child post (if post has a comment).
     * @param childPost The post that is a child of this post.
     */
    public void setChildPost(Post childPost) {
        this.childPost.add(childPost);
    }

    /**
     * Method to remove a child post (if post has a comment).
     * @param childPost The post that is no longer a child of this post.
     */
    public void removeChildPost(Post childPost) {
        this.childPost.remove(childPost);
    }

    /**
     * Constructor method for Post.
     * @param id The int for the post id.
     * @param account The Account of the user.
     * @param postContent The content of the post.
     */
    public Post (int id, Account account, String postContent) {
        this.id = id;
        this.account = account;
        this.postContent = postContent;
    }

    /**
     * Method to output the string representation of the Post object.
     * @return The String of the string representation.
     */
    @Override
    public String toString() {
        return "ID: " + id + "\nAccount: " + account + "\nPost Content: " + postContent + "\nNumber of Endorsements: " + endorsementCount + "\nNumber of Comments: "+ commentCount + "\nParent Post: "+ parentPost;
    }

}
