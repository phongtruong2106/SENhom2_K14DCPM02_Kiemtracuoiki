public class Account {
    private static StoreFilesAccount accounts = new StoreFilesAccount("accounts.json");

    private String username;
    private Integer password;
    private String email;
    private boolean loggedIn;
    private Integer phonenumber;

    /**
     * 
     */
    public Account() {
        this.username = null;
        this.loggedIn = false;
        this.password = null;
        this.email = null;
        this.phonenumber = null;
    }

    /**
     * @param username
     * @param password
     * @param email
     * @param loggedIn
     */

    public Account(String username, Integer password, String email, int phonenumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phonenumber = phonenumber;
        // this.loggedIn = loggedIn;
    }

    // check login
    public boolean checkLoggedIn() {
        return loggedIn;
    }

    public void setAccount(String username, Integer password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.loggedIn = true;
    }

    public void logout() {
        this.loggedIn = false;
        this.username = null;
        this.password = null;
        this.email = null;
        System.out.println("[LOGGED_OUT] You have been logged out");

    }

    // hanh vi cuar object
    /**
     * @return the accounts
     */
  public static StoreFilesAccount getAccounts() {
      return accounts;
  }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public Integer getPassword() {
        return password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

}
