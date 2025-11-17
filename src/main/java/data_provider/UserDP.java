package data_provider;

import dto.User;
import org.testng.annotations.DataProvider;
import utils.PropertiesReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDP {

    @DataProvider
    public Iterator<User> dataProviderUserFile(){
        List<User> list = new ArrayList<>();
        String fileName = PropertiesReader.getProperty("base.properties","file_user_csv");
        try(BufferedReader bufferedReader = new BufferedReader
                (new FileReader("src/test/resources/data_scv/IlCarroSignUp.csv"))) {
            String  line = bufferedReader.readLine();
            while (line != null){
                String [] splitArray = line.split(",");
                list.add(User.builder()
                        .firstName(splitArray[0])
                        .lastName(splitArray[1])
                        .username(splitArray[2])
                        .password(splitArray[3])
                        .build());
                line = bufferedReader.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("IO exception");
        }
        return list.listIterator();
    }


}
