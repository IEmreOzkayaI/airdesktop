/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package user.abstracts;

import java.util.List;
import user.concretes.Person;
import user.concretes.Personnel;

/**
 *
 * @author EmreOzkaya
 */
public interface IPersonnel {

    List<Person> getAllIsActiveFalse();

    List<Person> getAllIsBlockTrue();
}
