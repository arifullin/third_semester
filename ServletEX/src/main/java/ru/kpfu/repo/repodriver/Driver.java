package ru.kpfu.repo.repodriver;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import ru.kpfu.execptions.DataBaseEx;


public class Driver {
    private final static String extension = "csv";
    private final static String path = "C:\\Users\\хэтфилд\\Desktop\\";

    private static void checkDataBase(String base) throws DataBaseEx{
        File file = new File(pathToDataBase(base));
        if (!file.exists()){
            throw new DataBaseEx("No Data Base at this path");
        }
    }
    private static String pathToDataBase(String base){
        return path+base+"."+extension;
    }
    public static void addEntity(String base,String[] data) throws DataBaseEx{
        checkDataBase(base);
        try(CSVWriter writer = new CSVWriter(new FileWriter(pathToDataBase(base),true))) {
            writer.writeNext(data);
        } catch (IOException e) {
            throw new DataBaseEx("can not add entity",e);
        }
    }
    public static List<String[]> getAllEntities(String base) throws DataBaseEx{
        checkDataBase(base);
        try(CSVReader reader = new CSVReader(new FileReader(pathToDataBase(base)))) {
            return reader.readAll();
        } catch (IOException e) {
            throw new DataBaseEx("can not read data base",e);
        }
    }

}
