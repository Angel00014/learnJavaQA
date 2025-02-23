package dataProvider;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.example.account.CreditAccount;
import org.testng.annotations.DataProvider;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class CreditAccountDataProvider {

    @DataProvider(name = "AccountListCsv")
    public Object[][] getAccountListFromCsv() throws IOException {
        String csv_file = "src/test/resources/accounts.csv";
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.schemaFor(CreditAccount.class).withHeader().withColumnReordering(true);
        try {
            List<Object> accountList = csvMapper.readerFor(CreditAccount.class)
                    .with(csvSchema)
                    .readValues(new File(csv_file))
                    .readAll();

            System.out.println(accountList);

            Object[][] data = new Object[accountList.size()][1];
            for (int i = 0; i < data.length; i++) {
                data[i][0] = accountList.get(i);
            }

            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}