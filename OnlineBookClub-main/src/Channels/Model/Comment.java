/**
 * The {@code Comment} class represents a comment made by a user in a discussion channel.
 * It stores the username and the comment text.
 *
 * <p>This class provides methods to retrieve the username and set the comment text.</p>
 */
package Channels.Model;

public class Comment {
    /**
     * The name of the user who made the comment.
     */
    private String userName;

    /**
     * The comment text provided by the user.
     */
    private String userComment;

    /**
     * Constructs a {@code Comment} object with the specified username and comment text.
     *
     * @param userName    the name of the user making the comment
     * @param userComment the content of the comment
     */
    public Comment(String userName, String userComment) {
        this.userName = userName;
        this.userComment = userComment;
    }

    /**
     * Gets the username of the comment author.
     *
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Gets the comment text.
     *
     * @return the user comment
     */
    public String getUserComment() {
        return userComment;
    }

    /**
     * Sets the user comment text.
     *
     * @param userComment the new comment text
     */
    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public void showComment(){
        System.out.println( getUserName() + " \n \t" + getUserComment());
    }



}
