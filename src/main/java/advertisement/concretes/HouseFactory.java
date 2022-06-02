/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advertisement.concretes;

import advertisement.abstracts.House;
import java.io.File;

/**
 *
 * @author EmreOzkaya
 */
public class HouseFactory {

    public House createHouse( String advertisement_Type,File[] imageFiles , String[] imagePaths) {
        String advertisementType = advertisement_Type;
        if (advertisementType.equalsIgnoreCase("apartment")) {
             Apartment apartment = new Apartment();
           return apartment;
            
        }
        if (advertisementType.equalsIgnoreCase("manor")) {
            Manor manor = new Manor();
            return manor;
        }
        if (advertisementType.equalsIgnoreCase("tree house")) {
            TreeHouse treehouse = new TreeHouse();
            return treehouse;
        }
        if (advertisementType.equalsIgnoreCase("villa")) {
            Villa villa = new Villa();
            return villa;
        }
        return null;
    }
        public House getHouse( String advertisement_Type) {
        String advertisementType = advertisement_Type;
        if (advertisementType.equalsIgnoreCase("apartment")) {
             Apartment apartment = new Apartment();
           return apartment;
            
        }
        if (advertisementType.equalsIgnoreCase("manor")) {
            Manor manor = new Manor();
            return manor;
        }
        if (advertisementType.equalsIgnoreCase("tree house")) {
            TreeHouse treehouse = new TreeHouse();
            return treehouse;
        }
        if (advertisementType.equalsIgnoreCase("villa")) {
            Villa villa = new Villa();
            return villa;
        }
        return null;
    }
}
