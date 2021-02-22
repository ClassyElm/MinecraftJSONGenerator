package com.pjcraig.entity;

import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 * The type User.
 *
 * @author pjcraig
 */
@Entity(name="User")
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String email;
    private String password;
    private String nickname;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Command> commands = new ArrayList<>();

    /**
     * Instantiates a new User.
     */
    public User() {

    }

    /**
     * Instantiates a new User.
     *
     * @param email    the email
     * @param password the password
     * @param nickname the nickname
     */
    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets nickname.
     *
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets nickname.
     *
     * @param nickname the nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Gets this user's saved commands.
     *
     * @return the commands
     */
    public List<Command> getCommands() {
        return commands;
    }

    /**
     * Sets this user's saved commands.
     *
     * @param commands the commands
     */
    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.getId() && email.equals(user.getEmail())
                && password.equals(user.getPassword())
                && nickname.equals(user.getNickname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, nickname);
    }
}
