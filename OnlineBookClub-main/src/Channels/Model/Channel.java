package Channels.Model;

import Homepage.Model.Book;
import UserAuthentication.Model.User;

import java.awt.*;
import java.util.ArrayList;

public class Channel {
    private ArrayList<Comment> channelComments = new ArrayList<>();
    private ArrayList<ChannelObserver> observers = new ArrayList<>();

    public ArrayList<User> getMembers() {
        return members;
    }

    private ArrayList<User> members = new ArrayList<>();

    public boolean addMember(User user){
        this.members.add(user);
        return true;
    }
    /**
     * The name of the channel.
     */
    private String channelName;

    /**
     * The image associated with the book for this channel.
     */
    private Image BookImage;

    Book book;
    public void addObserver(ChannelObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ChannelObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Comment comment) {
        for (ChannelObserver observer : observers) {
            observer.onCommentAdded(comment);
        }
    }
    /**
     * Gets the Book name.
     *
     * @return the name of the Book
     */
    public Book getBook() {
        return book;
    }
    /**
     * Sets the book name.
     * @param book book to set on the channel
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Gets the channel name.
     *
     * @return the name of the channel
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * Sets the channel name.
     *
     * @param channelName the new name of the channel
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     * Gets the book image associated with the channel.
     *
     * @return the book image
     */
    public Image getBookImage() {
        return BookImage;
    }

    /**
     * Sets the book image associated with the channel.
     *
     * @param bookImage the book image to set
     */
    public void setBookImage(Image bookImage) {
        this.BookImage = bookImage;
    }

   public Channel(String channelName, Book book, Image bookImage){
        this.channelName = channelName;
        this.book = book;
        this.BookImage = bookImage;
   }
    /**
     * Constructs a {@code Channel} object with the specified channel name.
     *
     * @param channelName the name of the channel
     */
    public Channel(String channelName) {
        this.channelName = channelName;
    }
    /**
     * Constructs a {@code Channel} object with the specified channel name and book identifier.
     *
     * @param channelName the name of the channel
     * @param lop         an additional string parameter (unclear purpose, should be documented further)
     */
    public Channel(String channelName, String lop) {
        this.channelName = channelName;
    }

    public void addComment(Comment comment){
        channelComments.add(comment);
        notifyObservers(comment);
    }

    public void showAllCommentsInChannel(){
        for (Comment comment : channelComments) {
           comment.showComment();
        }
    }
    public ArrayList<Comment> getChannelComments() {
        return channelComments;
    }
}
