package ru.kpfu.repo;

import ru.kpfu.entities.User;
import ru.kpfu.execptions.AlredyExistEx;
import ru.kpfu.execptions.DataBaseEx;
import ru.kpfu.repo.repodriver.Driver;
import ru.kpfu.execptions.NoUserEx;

import java.util.ArrayList;
import java.util.List;

public class Repo {

    public static void add(User user,String base) throws DataBaseEx,AlredyExistEx{
        checkUserExist(user,base);
        String[] temp = new String[]{user.getSoap(),user.getPassword(),"",""};
        if (user.isMan()){
            temp[2] = "true";
        }else temp[2] = "false";
        if (user.isSubscribe()){
            temp[3] = "true";
        }else temp[3] = "false";
        Driver.addEntity(base,temp);
    }
    private static void checkUserExist(User user,String base) throws AlredyExistEx,DataBaseEx{
        List<User> users = getAll(base);
        for (User x:users){
            if (x.equals(user)){
                throw new AlredyExistEx();
            }
        }
    }
    public static List<User> getAll(String base) throws DataBaseEx{
        List<String[]> entities = Driver.getAllEntities(base);
        List<User> users = new ArrayList<>();
        for (String[] entity : entities){
            boolean gender = false;
            boolean subscribe = false;
            if (entity[2].equals("true")){
                gender = true;
            }
            if (entity[3].equals("true")){
                subscribe = true;
            }
            User user = new User(entity[0],entity[1],gender,subscribe);
            users.add(user);
        }
        return users;
    }
    public static List<String[]> getAllAr(String base) throws DataBaseEx{
        List<User> x = getAll(base);
        List<String[]> rslt = new ArrayList<String[]>(x.size());
        for (User user:x){
            rslt.add(User.toArray(user));
        }
        return rslt;
    }
    public static User userAuthentication(String soap,String password,String base) throws DataBaseEx, NoUserEx {
        for (User user:getAll(base)){
            if ((user.getSoap().equals(soap))&&(user.getPassword().equals(password))){
                return user;
            }
        }
        throw new NoUserEx();
    }
}
