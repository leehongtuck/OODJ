/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomException;

/**
 *
 * @author Lee Hong Tuck
 */
public class UsernameDuplicateException extends RuntimeException{
    @Override
    public String getMessage(){
        return "Username duplicate.";
    }
    
}
