package dataProvider;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.example.user.Users;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserDataProvider {

    @DataProvider(name = "UserListCsv")
    public Object[][] getUserListFromCsv() throws IOException {
        String csv_file = "src/test/resources/user.csv";
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.schemaFor(Users.class).withHeader().withColumnReordering(true);
        try {
            List<Object> userList = csvMapper.readerFor(Users.class)
                    .with(csvSchema)
                    .readValues(new File(csv_file))
                    .readAll();

            System.out.println(userList);

            Object[][] data = new Object[userList.size()][1];
            for (int i = 0; i < data.length; i++) {
                data[i][0] = userList.get(i);
            }

            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
