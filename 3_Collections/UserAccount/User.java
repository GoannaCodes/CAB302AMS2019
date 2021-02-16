package coll.UserAccounts;

import java.util.ArrayList;

/**
 * Represents a user with a username and password.
 *
 * Maintains a record of existing usernames.
 *
 */
public class User {
    static ArrayList<String> usernames = new ArrayList<String>();

    private String username;
    private String password;

    /**
     * Constructs a user with a given username and password. If a user is
     * successfully constructed, their username is added to the list of usernames.
     *
     * @param username - the username.
     * @param password - the password.
     * @throws UserException if the username or password is invalid.
     */
    public User(String username, String password) throws UserException {
        this.username = username;
        this.password = password;

        //determine if given username or password are valid
        if (badUsername(username)){
            throw new UserException("Username is invalid.");
        } else {
            usernames.add(username);
        }
        if (badPassword(password)){
            throw new UserException("Password less than 8 characters long.");
        }

    }

    /**
     * Checks if a given username is invalid.
     *
     * @param username - the username
     * @return true iff the username already exist.
     */

    //returns false
    public static boolean badUsername(String username) {
        if (usernames.contains(username)){
            return true;
        }
        return false;
    }
    /**
     * Checks if a given password is invalid.
     *
     * @param password - the password
     * @return true iff the password is fewer than 8 characters long.
     */
    public static boolean badPassword(String password) {
        boolean notValidLength = false;
        if (password.length() < 8){
            notValidLength = true;
        }
        return notValidLength;

    }

    /**
     * Gets the username of the user.
     *
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
