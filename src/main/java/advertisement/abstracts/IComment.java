/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package advertisement.abstracts;

import advertisement.concretes.Comment;
import java.util.ArrayList;
import java.util.List;
import user.concretes.Person;

/**
 *
 * @author EmreOzkaya
 */
public interface IComment {
    void post();
    ArrayList<Comment> getAllComments();
    void delete(int commentId);
    public void deleteByPersonId(int personId);
}
